# Java-Learn

------------------------------------------------------------------------

[![last commit](https://img.shields.io/github/last-commit/Coconut-Aero/JavaLearn)](https://github.com/Coconut-Aero/JavaLearn/commits/master)
[![Static Badge](https://img.shields.io/badge/Coconut-Aero-blue)](https://github.com/Coconut-Aero)


_Updated 2024-04-16 15:20 CST_

A Java Repository for learning purpose of Coconut-Aero


[![OrelaV](https://i2.hdslb.com/bfs/face/d812a48f1ca84d4f60a112dc31ba65546a787a76.jpg@240w_240h_1c_1s_!web-avatar-space-header.avif "@OrelaV")](https://space.bilibili.com/3546375738361934)

关注[OrelaV](https://space.bilibili.com/3546375738361934)谢谢喵

BooleanWrapper.java 提供可以在方法内部修改并传递到方法外的boolean类型 BooleanWrapper

可以调用的方法：

| 来源                  |   类型    | 用法                                                                   |
|---------------------|:-------:|----------------------------------------------------------------------|
| arraytest.java      |  void   | printArr(int[] arr,int size)                                         |
| quadSolve.java      |   int   | solveQuadratic(double[] eqn, BooleanWrapper haveRoot, double[] root) |
| sorted.java         | boolean | IsSorted(int[] list)                                                 |
| mergeArray.java     |  int[]  | merge(int[] list1,int[] list2)                                       |
| sorted.java         |  int[]  | Sort(int[] res)                                                      |
| eightQueens.java    |  void   | eightQueenBool2DArrayPrint(boolean[][] arr)                          |
| eightQueens.java    |  void   | solveEightQueens(boolean[][] board, int row)                         |
| eightQueens.java    | boolean | eightQueenValid(boolean[][] arr,int row, int col)                    |
| enhancedRandom.java |   int   | getRandom(int start, int end, int... numbers)                        |


包含：

| 序号 | 文件名                 | 描述                           | 备注   |
|----|---------------------|------------------------------|------|
| 1  | test.java           | Hello World                  | 作业   |
| 2  | time.java           | 输出系统的UNIX时间戳指向的日期（已经完善）      | 作业   |
| 3  | sumdigit.java       | 一个0~1000的数字各位的和              | 作业   |
| 4  | trianglearea.java   | 输入三个点的坐标，输出它们构成的三角形的面积（海伦公式） | 作业   |
| 5  | daysinmonth.java    | 某年某月所包含的天数                   | 作业   |
| 6  | srpgame.java        | 剪刀石头布游戏                      | 作业   |
| 7  | srpwin2.java        | 人胜利两次自动终止循环的变种               | 作业   |
| 8  | numberpyramid.java  | 数字金字塔，2的幂                    | 作业   |
| 9  | cityorder.java      | 把城市按字母顺序排序                   | 4.24 |
| 10 | estimatepi.java     | 计算圆周率                        | 6.14 |
| 11 | printcalendar2.java | 输出以周一为一周第一天的日历               | 作业   |
| 12 | arraytest.java      | 输入一个数组，将其变换后输出               | 作业   |
| 13 | enhancedRandom.java | 增强的random，可以选择范围，排除一些不想要的数字  | 作业   |
| 14 | intSum.java         | 命令行参数计算多个数字的和                | 作业   |
| 15 | hangman.java        | 猜单词的小游戏                      | 7.35 |
| 16 | quadSolve.java      | 解一元二次方程，方法可以调用               | 7.25 |
| 17 | sorted.java         | 检查数组是否按从小到大排序了               | 7.19 |
| 18 | lockerPuzzle.java   | 储物柜难题                        | 7.23 |
| 19 | mergeArray.java     | 合并两个有序列表                     | 7.31 |
| 20 | eightQueens.java    | 八皇后难题                        | 7.36 |
| 21 | repeatedInArray     | 计算数字的出现次数                    | 7.3  |

跨Class引用函数关系如下：

| 序号 | 引用自                 | 引用到                   | 引用方法/类型的名称     |
|----|---------------------|-----------------------|----------------|
| 1  | BooleanWrapper.java | quadSolve.java        | BooleanWrapper |
| 2  | arraytest.java      | sorted.java           | printarr()     |
| 3  | arraytest.java      | mergeArray.java       | printarr()     |
| 4  | sorted.java         | mergeArray.java       | IsSorted()     |
| 5  | sorted.java         | mergeArray.java       | Sort()         |
| 6  | sorted.java         | repeatedInArray.java  | Sort()         |

