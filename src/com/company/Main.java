package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int sudokuLenght =  scanner.nextInt();


        //eğer iyi bir satır sayısı değilse tekrar girilmeli
        //örnek :eğer uzunluk 81 ise 9x9(9 tane 9 luk grup)) ,geçerli
        //örnek :12 3.46x3.46 gibi bir sayı yani tam sayı değil net birşekilde gruplandıramayız, geçersiz !
        while ( (int)Math.sqrt(sudokuLenght) != Math.sqrt(sudokuLenght)){
            System.out.println("Lütfen geçerli satır sayısı giriniz");
            sudokuLenght = scanner.nextInt();
        }




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
        System.out.println("This is solved sudoku");

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
