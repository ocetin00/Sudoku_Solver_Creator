package com.company;

import java.util.Random;

public class SudokuCreater {

    private SudokuSolver sudokuSolver;
    private int[][] sudoku;
    private int sudokuLenght;

    int[][] grid = new int[][] {
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
    };

    SudokuCreater(int sudokuLenght){

        this.sudokuLenght = sudokuLenght;
        sudokuSolver = new SudokuSolver();



    }


     int[][] generateSudoku() {
        //create empty 9x9 array
        int temp[][] = new int[sudokuLenght][sudokuLenght];
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

        return sudoku;
    }


}
