public class Sudoku {
    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean check(int sudoku[][], int row, int col, int num) {
        // up or down
        for (int i = 0; i < 9; i++) {
            if (i == row)
                continue;
            if (num == sudoku[i][col])
                return false;
        }
        // left or right
        for (int i = 0; i < 9; i++) {
            if (i == col)
                continue;
            if (num == sudoku[row][i])
                return false;
        }
        // box
        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++) {
                if (num == sudoku[i][j])
                    return false;
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        if (row == 8 && col == 9) // end
            return true;

        if (col == 9) // next row
            return sudokuSolver(sudoku, row + 1, 0);

        if (sudoku[row][col] != 0) // already have value
            return sudokuSolver(sudoku, row, col + 1);

        for (int i = 1; i <= 9; i++) // main code
            if (check(sudoku, row, col, i)) {
                sudoku[row][col] = i;
                if (sudokuSolver(sudoku, row, col + 1))
                    return true;
                sudoku[row][col] = 0;
            }
        return false;
    }

    public static void main(String args[]) {
        // Sudoku Solver
        // Update values as required
        int sudoku[][] = {
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };
        sudokuSolver(sudoku, 0, 0);
        printMatrix(sudoku);
    }
}