package practice;

import homework.enhancedRandom; // 假设你自己定义了这个随机数生成器
import java.util.Scanner;


public class buckshotTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 玩家相关信息初始化
        String Player1Name, Player2Name;
        int Player1Health = 6, Player2Health = 6;
        int[] Player1Prop = buckshot.createProp(), Player2Prop = buckshot.createProp();
        boolean Player1Win = false, Player2Win = false;
        boolean exit = false;

        System.out.print("Enter Player 1's name: ");
        Player1Name = input.nextLine();
        System.out.print("Enter Player 2's name: ");
        Player2Name = input.nextLine();

        while (!exit) {
            // 三局比赛
            for (int round = 1; round <= 3; round++) {
                Player1Health = 6;
                Player2Health = 6;
                Player1Prop = buckshot.createProp();
                Player2Prop = buckshot.createProp();

                System.out.println("\n======= ROUND " + round + " START =======");

                while (Player1Health > 0 && Player2Health > 0) {
                    boolean[] shellType = buckshot.shell(); // 本回合子弹阵列
                    int playWho = 1; // 1表示Player1，2表示Player2
                    boolean knifeMore = false; // 是否用刀（加倍伤害）
                    boolean Player1NoMove = false;
                    boolean Player2NoMove = false;

                    for (int j = 0; j < shellType.length; j++) {
                        buckshot.PrintHealth(Player1Health, Player2Health, Player1Name, Player2Name);
                        buckshot.printProp(Player1Prop, Player1Name);
                        buckshot.printProp(Player2Prop, Player2Name);

                        String activePlayer = (playWho == 1) ? Player1Name : Player2Name;
                        int[] activeProp = (playWho == 1) ? Player1Prop : Player2Prop;
                        int[] enemyProp = (playWho == 1) ? Player2Prop : Player1Prop;
                        boolean activeNoMove = (playWho == 1) ? Player1NoMove : Player2NoMove;
                        boolean enemyNoMove = (playWho == 1) ? Player2NoMove : Player1NoMove;
                        int activeHealth = (playWho == 1) ? Player1Health : Player2Health;
                        int enemyHealth = (playWho == 1) ? Player2Health : Player1Health;

                        // --- 道具阶段 ---
                        knifeMore = false; // 每回合初始化刀效果
                        boolean usedPropStage = true;
                        while (usedPropStage) {
                            System.out.println("\nIt's " + activePlayer + "'s turn!");
                            System.out.println("Do you want to use a prop? (cigarette/knife/drug/handcuff/magnify/adrenaline/phone/reverser/no)");
                            System.out.print("> ");
                            String useProp = input.nextLine().trim().toLowerCase();

                            if (useProp.equals("no")) {
                                usedPropStage = false;
                            } else {
                                boolean success = buckshot.useProp(useProp, activeProp, enemyProp, shellType, j);
                                if (useProp.equals("knife")) {
                                    knifeMore = true;
                                }
                                if (!success) {
                                    System.out.println("You don't have that prop or wrong input.");
                                }
                            }
                        }

                        // --- 射击阶段 ---
                        System.out.println("\nSHOT TIME! " + activePlayer + "'s turn!");
                        System.out.println("Shoot 'You' or 'Opposite'?");
                        String shotWho = input.nextLine().trim();

                        boolean shotType = buckshot.shot(shellType[j]);
                        if (shotType) {
                            System.out.println("REAL SHELL HIT!");

                            if (shotWho.equalsIgnoreCase("You")) {
                                if (!knifeMore) activeHealth--;
                                else activeHealth -= 2;
                            } else if (shotWho.equalsIgnoreCase("Opposite")) {
                                if (!knifeMore) enemyHealth--;
                                else enemyHealth -= 2;
                            } else {
                                System.out.println("Invalid target. Missed shot!");
                            }
                        } else {
                            System.out.println("NO SHELL (blank fire)!");
                        }

                        // 更新血量回写
                        if (playWho == 1) {
                            Player1Health = activeHealth;
                            Player2Health = enemyHealth;
                        } else {
                            Player2Health = activeHealth;
                            Player1Health = enemyHealth;
                        }

                        // 回合切换规则
                        if (shotType) {
                            if (!enemyNoMove) {
                                playWho = 3 - playWho; // 切换玩家
                            }
                        } else {
                            playWho = 3 - playWho; // 没开枪也切换
                        }

                        Player1NoMove = false;
                        Player2NoMove = false;

                        if (Player1Health <= 0 || Player2Health <= 0) break;
                    }

                    // 每轮后增加新的道具
                    buckshot.addProp(Player1Prop);
                    buckshot.addProp(Player2Prop);
                }

                if (Player1Health <= 0) {
                    Player2Win = true;
                    break;
                } else if (Player2Health <= 0) {
                    Player1Win = true;
                    break;
                }
            }

            // --- 最终胜负判断 ---
            if (Player1Win) {
                System.out.println("\n" + Player1Name + " has won the match!");
            } else if (Player2Win) {
                System.out.println("\n" + Player2Name + " has won the match!");
            }

            exit = !buckshot.exit(); // 继续游戏？
        }
    }
}




class buckshot {
    private static final String[] props = {
            "cigarette", "knife", "drug", "handcuff", "magnify", "adrenaline", "phone", "reverser"
    };

    // --- 随机生成子弹阵列 --- //
    public static boolean[] shell() {
        boolean[] shellArray = new boolean[6];
        for (int i = 0; i < 6; i++) {
            // 25%几率是真弹
            shellArray[i] = (enhancedRandom.getRandom(0, 3) == 0);
        }
        return shellArray;
    }

    // --- 初始化玩家道具栏，每种0个 --- //
    public static int[] createProp() {
        return new int[8];
    }

    // --- 玩家使用道具逻辑 --- //
    public static boolean useProp(String propName, int[] activeProp, int[] enemyProp, boolean[] shell, int round) {
        int index = propIndex(propName);
        if (index == -1 || activeProp[index] <= 0) {
            return false; // 无此道具或数量不足
        }

        switch (propName) {
            case "cigarette":
                // 香烟：偷看未来两颗子弹
                System.out.println("[Cigarette] Preview:");
                for (int i = round; i < Math.min(round + 2, shell.length); i++) {
                    System.out.println("Position " + (i + 1) + ": " + (shell[i] ? "REAL SHELL" : "BLANK"));
                }
                break;

            case "knife":
                // 刀：普通攻击翻倍（已在main处理）
                System.out.println("[Knife] Will deal double damage this turn.");
                break;

            case "drug":
                // 药剂：回一滴血（但最大6）
                System.out.println("[Drug] Healing...");
                if (activeProp == null) break; // 防止意外空指针
                activeProp[7]++; // 临时写入标记，等主程序处理回血（7号位为特殊标记）
                break;

            case "handcuff":
                // 手铐：敌人下回合无法开火
                System.out.println("[Handcuff] Enemy will be unable to move next turn.");
                enemyProp[6]++; // 敌人被冻结1次（6号位为冻结标记）
                break;

            case "magnify":
                // 放大镜：下颗子弹提前暴露
                System.out.println("[Magnify] Next bullet is exposed.");
                System.out.println("Next bullet: " + (shell[round] ? "REAL SHELL" : "BLANK"));
                break;

            case "adrenaline":
                // 肾上腺素：下回合不受任何冻结影响
                System.out.println("[Adrenaline] You are immune to freeze next round.");
                activeProp[6]--; // 移除自己被冻结
                break;

            case "phone":
                // 电话：随机增加一个道具
                System.out.println("[Phone] Calling for backup...");
                int reward = enhancedRandom.getRandom(0, props.length - 1);
                activeProp[reward]++;
                System.out.println("Received a new prop: " + props[reward]);
                break;

            case "reverser":
                // 反转器：子弹顺序反转
                System.out.println("[Reverser] Reversing bullets...");
                reverse(shell);
                break;
        }

        activeProp[index]--; // 使用道具扣除
        return true;
    }

    // --- 血量展示 --- //
    public static void PrintHealth(int p1Health, int p2Health, String p1Name, String p2Name) {
        System.out.println("\n【HEALTH STATUS】");
        System.out.println(p1Name + ": " + p1Health + " HP");
        System.out.println(p2Name + ": " + p2Health + " HP\n");
    }

    // --- 道具栏展示 --- //
    public static void printProp(int[] prop, String playerName) {
        System.out.println("【" + playerName + "'s Props】");
        boolean hasProp = false;
        for (int i = 0; i < props.length; i++) {
            if (prop[i] > 0) {
                System.out.println(props[i] + " x" + prop[i]);
                hasProp = true;
            }
        }
        if (!hasProp) {
            System.out.println("No props owned.");
        }
        System.out.println();
    }


    // --- 枪击结果 --- //
    public static boolean shot(boolean bulletType) {
        return bulletType;
    }

    // --- 每局结算时补充随机道具 --- //
    public static void addProp(int[] prop) {
        int newProp = enhancedRandom.getRandom(0, props.length - 1);
        prop[newProp]++;
    }

    // --- 是否继续游戏 --- //
    public static boolean exit() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlay again? (y/n)");
        String answer = input.nextLine().trim().toLowerCase();
        return answer.equals("y");
    }

    // --- 工具函数：根据名字找到道具序号 --- //
    private static int propIndex(String propName) {
        for (int i = 0; i < props.length; i++) {
            if (props[i].equals(propName)) {
                return i;
            }
        }
        return -1;
    }

    // --- 工具函数：反转数组 --- //
    private static void reverse(boolean[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            boolean temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
}
