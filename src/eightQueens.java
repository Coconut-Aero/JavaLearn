public class eightQueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[8][8];
        solveEightQueens(board, 0);
    }

    public static void solveEightQueens(boolean[][] board, int row) {
        if (row == 8) {
            eightQueenBool2DArrayPrint(board);
            return;
        }
        for (int col = 0; col < 8; col++) {
            if (eightQueenValid(board, row, col)) {
                board[row][col] = true; 
                solveEightQueens(board, row + 1); 
                board[row][col] = false; 
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
