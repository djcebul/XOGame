package com.company;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static String[][] array = new String[4][4];
    public static void main(String[] args) {
        var s = new Scanner(System.in);
        int liczbaX=0,liczbaO=0;

        //Wczytywanie
        int licznik = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = " ";
                licznik++;
            }
        }
        //Wyswietlacz
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j==0) System.out.print("| ");
                System.out.print(array[i][j] + " ");
                if (array[i][j].equals("X")) liczbaX++;
                if (array[i][j].equals("O")) liczbaO++;
            }
            System.out.println("|");
        }
        System.out.println("---------");

        boolean xMove = true;

        while(true){



        try {
            while (true) {
                System.out.print("Enter the coordinates: ");
                int cords1 = s.nextInt() - 1;
                int cords2 = s.nextInt() - 1;

                if (cords1 < 0 || cords1 > 2 || cords2 < 0 || cords2 > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (!array[cords1][cords2].equals(" ")) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    if (xMove) {
                        array[cords1][cords2] = "X";
                        xMove = false;
                        break;
                    }
                    else{
                        array[cords1][cords2] = "O";
                        xMove = true;
                        break;
                    }

                }
            }
            //Sprawdzenie w poziomie

            boolean x = false, o = false, impossible = false;

            for (int i = 0; i < 3; i++) {
                if (Objects.equals(array[i][0], array[i][1]) && Objects.equals(array[i][1], array[i][2]) && Objects.equals(array[i][1], "X")) {
                    x = true;
                } else if (Objects.equals(array[i][0], array[i][1]) && Objects.equals(array[i][1], array[i][2]) && Objects.equals(array[i][1], "O")) {
                    o = true;
                } else if (array[1][i].equals(array[0][i]) && array[1][i].equals(array[2][i]) && array[0][i].equals("X")) {
                    x = true;
                } else if (array[1][i].equals(array[0][i]) && array[1][i].equals(array[2][i]) && array[0][i].equals("O")) {
                    o = true;
                } else if (array[i][i].equals(array[i + 1][i + 1]) && array[i + 1][i + 1].equals(array[i + 2][i + 2]) && array[0][i].equals("O")) {
                    o = true;
                    break;
                } else if (array[i][i].equals(array[i + 1][i + 1]) && array[i + 1][i + 1].equals(array[i + 2][i + 2]) && array[0][i].equals("X")) {
                    x = true;
                    break;
                } else if (array[0][2].equals(array[1][1]) && array[1][1].equals(array[2][0]) && array[0][2].equals("X")) {
                    x = true;
                } else if (array[0][2].equals(array[1][1]) && array[1][1].equals(array[2][0]) && array[0][2].equals("O")) {
                    o = true;
                } else if (Math.abs(liczbaO - liczbaX) > 1) {
                    impossible = true;
                    break;
                }
            }
            //Czy remis
            boolean a = false, draw = false;

            int licznikDraw = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (array[i][j].equals("X") || array[i][j].equals("O")) licznikDraw++;
                }}
            if (!x && !o && !impossible && licznikDraw >= 9){
                draw = true;}


        if (x&&o) System.out.println("Impossible");
        else if (x){
            rysuj();
            System.out.println("X wins");
            break;
        }
        else if (o) {
            rysuj();
            System.out.println("O wins");
            break;
        }

        else if (impossible) {
            rysuj();
            System.out.println("Impossible");
            break;
        }
        else if (draw){
            rysuj();
            System.out.println("Draw");
            break;
        }

        }catch (NoSuchElementException e){
            System.out.println("You should enter numbers!");
        }
        //Aktualizacja planszy
        rysuj();

    }}

public static void rysuj()
{
    System.out.println("---------");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (j==0) System.out.print("| ");
            System.out.print(array[i][j] + " ");
        }
        System.out.println("|");
    }
    System.out.println("---------");
}}




//package com.company;
//
//import java.util.NoSuchElementException;
//import java.util.Scanner;
//
//public class Xo {
//    public static void main(String[] args) {
//
//
//                var s = new Scanner(System.in);
//                int liczbaX=0,liczbaO=0;
//
//                //Wczytywanie
//                System.out.print("Enter cells: ");
//                String input = s.next();
//                int licznik = 0;
//                String[][] array = new String[4][4];
//                for (int i = 0; i < 3; i++) {
//                    for (int j = 0; j < 3; j++) {
//                        array[i][j] = String.valueOf(input.charAt(licznik));
//                        licznik++;
//                    }
//                }
//
//                //Wyswietlacz
//                System.out.println("---------");
//                for (int i = 0; i < 3; i++) {
//                    for (int j = 0; j < 3; j++) {
//                        if (j==0) System.out.print("| ");
//                        System.out.print(array[i][j] + " ");
//                        if (array[i][j].equals("X")) liczbaX++;
//                        if (array[i][j].equals("O")) liczbaO++;
//                    }
//                    System.out.println("|");
//                }
//                System.out.println("---------");
//        try{
//                //Wprowadzanie danych XO i sprawdzenie poprawnosci danych
//                //System.out.print("Enter the coordinates:");
//
//
//
//
//
//
//            while (true) {
//                System.out.print("Enter the coordinates: ");
//                int cords1 = s.nextInt() - 1;
//                int cords2 = s.nextInt() - 1;
//
//
//                    if ( cords1 < 0 || cords1 > 2 || cords2 < 0 || cords2 > 2) {
//                        System.out.println("Coordinates should be from 1 to 3!");
//                        continue;
//                    }
//                    if (!array[cords1][cords2].equals("_")) {
//                        System.out.println("This cell is occupied! Choose another one!");
//                    } else {
//                        array[cords1][cords2] = "X";
//                        break;
//                    }
//
//            }
//              // else array[cords1][cords2] = "X";
//
//                //Aktualizacja planszy
//        System.out.println("---------");
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (j==0) System.out.print("| ");
//                System.out.print(array[i][j] + " ");
//                }
//            System.out.println("|");
//        }
//        System.out.println("---------");
//
//                } catch (NoSuchElementException e){
//                    System.out.println("You should enter numbers!");
//                }
//
//    }
//}
