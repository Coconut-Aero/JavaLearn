public class eightQueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[8][8];
        solveEightQueens(board, 0);
    }

    public static void solveEightQueens(boolean[][] board, int row) {
        if (row == 8) {
            // 所有皇后都已经放置完毕，打印解决方案
            eightQueenBool2DArrayPrint(board);
            return;
        }

        // 在当前行尝试放置皇后
        for (int col = 0; col < 8; col++) {
            if (eightQueenValid(board, row, col)) {
                board[row][col] = true; // 放置皇后
                solveEightQueens(board, row + 1); // 继续解决下一行
                board[row][col] = false; // 回溯，尝试下一个位置
            }
        }
    }

    public static void eightQueenBool2DArrayPrint(boolean[][] arr){
        for (boolean[] booleans : arr) {
            System.out.print("|");
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    System.out.print("Q|");
                } else {
                    System.out.print(" |");
                }
            }
             System.out.println();
        }
        System.out.println();
    }

    public static boolean eightQueenValid(boolean[][] arr,int row, int col){
        for (int k = 0; k < row; k++) {
            if (arr[k][col]){
                return false;
            }
        }
        for (int k = row; k < arr.length; k++) {
            if (arr[k][col]){
                return false;
            }
        }
        for (int k = row-1, l= col -1; k >= 0 && l >= 0; k--,l--) {
            if (arr[k][l]){
                return false;
            }
        }
        for (int k = row-1, l= col +1; k >= 0 && l < arr.length; k--,l++) {
            if (arr[k][l]){
                return false;
            }
        }
        return true;
    }
}
