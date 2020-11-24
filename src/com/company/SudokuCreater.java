package com.company;

import java.util.Random;

public class SudokuCreater {

    private SudokuSolver sudokuSolver;
    private String[][] sudoku;
    private int sudokuLenght;



    SudokuCreater(int sudokuLenght){

        this.sudokuLenght = sudokuLenght;
        sudokuSolver = new SudokuSolver();



    }

    //create empty array given size
     String[][] generateSudoku() {
        String[][] temp = new String[sudokuLenght][sudokuLenght];
        for(int i=0;i<sudokuLenght;i++){
            for(int j=0;j<sudokuLenght;j++){
                temp[i][j] = " ";
            }
        }

         //create real sudoku problem
         sudokuSolver.solveSudoku(temp,sudokuLenght);
         for(int i=0;i<sudokuLenght;i += (int)(Math.random() *2)){
             for(int j=0;j<sudokuLenght;j+= (int)(Math.random() *3)){
                 temp[i][j] = " ";
             }
         }

         sudoku =temp;
         print(sudoku,sudokuLenght);

        return sudoku;
    }

    public void print(
            String[][] grid, int N)
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
