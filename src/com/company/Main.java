package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sudoku[][] = null;

        int sudokuLenght = 9;

        SudokuCreater sudokuCreater = new SudokuCreater(sudokuLenght);
        SudokuSolver sudokuSolver = new SudokuSolver();


        System.out.println("Enter   C for create and, S for solve");

        
            if (scanner.nextLine().toUpperCase().equals("C")) {
                sudoku = sudokuCreater.generateSudoku();
                if (scanner.nextLine().toUpperCase().equals("S")) {
                    if (sudokuSolver.solveSudoku(sudoku, sudokuLenght)) {
                        //ekrana yazdırma
                        print(sudoku, sudokuLenght);
                    } else {
                        System.out.println("There is no solition");
                    }
                }

            } else {
                System.out.println("Please enter a valid letter");
            }


    }

    //print sudoku
    public static void print(
            String[][] grid, int N) {
        System.out.println("This is solved sudoku");

        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; b++) {
                System.out.print(grid[a][b]);
                System.out.print(" ");
            }
            System.out.println(" ");

            if ((a + 1) % (int) Math.sqrt(N) == 0) {
                System.out.print("");
            }
        }
    }


}
