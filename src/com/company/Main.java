package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int sudokuLenght =  scanner.nextInt();


        SudokuCreater sudokuCreater = new SudokuCreater(sudokuLenght);
        SudokuSolver sudokuSolver = new SudokuSolver();

        int sudoku[][] = sudokuCreater.generateSudoku();



        if (sudokuSolver.solveSudoku(sudoku, sudokuLenght))
        {
            //ekrana yazdırma
             print(sudoku, sudokuLenght);
        }
        else {
            System.out.println("There is no solition");
        }





    }
    //print sudoku
    public static void print(
            int[][] grid, int N)
    {

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
    }



}
