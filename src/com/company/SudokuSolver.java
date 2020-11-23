package com.company;

public class SudokuSolver {

    public boolean solveSudoku(
            int[][] grid, int n)
    {
        int row = 0;
        int col = 0;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 0)
                {
                    row = i;
                    col = j;


                    //pozisyon boş işe direk direk döngüden cıkıyoruz
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // Boş alan yok
        if (isEmpty)
        {

            return true;
        }

        //deneyebileceğimiz tüm cevalar denenir
        for (int num = 1; num <= n; num++)
        {
            if (isSafe(grid, row, col, num))
            {
                grid[row][col] = num;
                //recursive olarak hala boş yer olup olmadıgı kontrol edilir
                if (solveSudoku(grid, n))
                {
                    //print answer
                    return true;
                }
                else
                {
                    // replace it
                    grid[row][col] = 0;
                }
            }
        }
        return false;
    }

    public  boolean isSafe(int[][] board,
                                 int row, int col,
                                 int num)
    {
        // satırda eslesme var mı?
        for (int d = 0; d < board.length; d++)
        {


            /*
            eğer zaten denediğimiz numara satırdaki numaralardan biri ise false döndür
             */
            if (board[row][d] == num) {
                return false;
            }
        }

        // satırda eslesme var mı?
        for (int r = 0; r < board.length; r++)
        {
            /*
            eğer zaten denediğimiz numara sütünde numaralardan biri ise false döndür
             */
            if (board[r][col] == num)
            {
                return false;
            }
        }

        /*
        Yerleştireceğimiz numara bulunduğu grupta var mı?
         */
        //grup ölçüsünü bulma
        int sqrt = (int)Math.sqrt(board.length);
        //bulunduğu grubun baslangıç satırını bulma(if row= 5 => startRow = 3)
        int boxRowStart = row - row % sqrt;
        //bulunduğu grubun baslangıç sutünunu bulma(if col= 8 => startCol = 6)
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++)
            {
                if (board[r][d] == num)
                {
                    return false;
                }
            }
        }

        //Herhangi bir eşleşme yoksa return true
        return true;
    }





}
