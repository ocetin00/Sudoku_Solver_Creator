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

        return sudoku;
    }


}
