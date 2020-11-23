package com.company;

import java.util.Random;

public class SudokuCreater {

    private SudokuSolver sudokuSolver;
    private int[][] sudoku;
    private int sudokuLenght;



    SudokuCreater(int sudokuLenght){

        this.sudokuLenght = sudokuLenght;
        sudokuSolver = new SudokuSolver();



    }

    //create empty array given size
     int[][] generateSudoku() {
        int[][] temp = new int[sudokuLenght][sudokuLenght];
        for(int i=0;i<sudokuLenght;i++){
            for(int j=0;j<sudokuLenght;j++){
                temp[i][j] = 0;
            }
        }

         //create real sudoku problem
         sudokuSolver.solveSudoku(temp,sudokuLenght);
         for(int i=0;i<sudokuLenght;i += (int)(Math.random() *3)){
             for(int j=0;j<sudokuLenght;j+= (int)(Math.random() *4)){
                 temp[i][j] = 0;
             }
         }

         sudoku =temp;
         print(sudoku,sudokuLenght);

        return sudoku;
    }

    public void print(
            int[][] grid, int N)
    {

        System.out.println("this is sudoku problem");

        for (int a = 0; a < N; a++)
        {
            for (int b = 0; b < N; b++)
            {
                System.out.print(grid[a][b]);
                System.out.print(" ");
            }
            System.out.println(" ");

            if ((a + 1) % (int)Math.sqrt(N) == 0)
            {
                System.out.print("");
            }
        }
        System.out.println("");
    }



}
