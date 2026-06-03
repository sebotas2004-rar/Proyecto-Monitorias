package co.edu.uptc.run;

import java.util.Scanner;

public class Triqui {

    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);

        String[] Filas = { "#", "#", "#" };
        String[] Fila2 = { "#", "#", "#" };
        String[] Fila3 = { "#", "#", "#" };

        boolean win = false;
        boolean turn = false;
        String caracter = "";
        int turnosContador = 0;

        while (!win) {
            if (turn == false) {
                caracter = "X";
            } else {
                caracter = "O";
            }

            System.out.println("Turno del jugador: " + caracter);
            
            for (int i = 0; i < Filas.length; i++) {
                System.out.print(Filas[i]);
            }
            System.out.println();
            for (int i = 0; i < Fila2.length; i++) {
                System.out.print(Fila2[i]);
            }
            System.out.println();
            for (int i = 0; i < Fila3.length; i++) {
                System.out.print(Fila3[i]);
            }
            System.out.println();

            System.out.println("Ingrese las coordenadas");
            int X = SC.nextInt();
            int Y = SC.nextInt();

            if (X < 1 || X > 3 || Y < 1 || Y > 3) {
                System.out.println("Coordenadas no validas");
                continue;
            }

            int posicion = Y - 1;
            boolean jugadaValida = false;

            if (X == 1) {
                if (Filas[posicion].equals("#")) {
                    Filas[posicion] = caracter;
                    jugadaValida = true;
                }
            } else if (X == 2) {
                if (Fila2[posicion].equals("#")) {
                    Fila2[posicion] = caracter;
                    jugadaValida = true;
                }
            } else if (X == 3) {
                if (Fila3[posicion].equals("#")) {
                    Fila3[posicion] = caracter;
                    jugadaValida = true;
                }
            }

            if (jugadaValida) {
                turnosContador++;

                if (Filas[0].equals(caracter) && Filas[1].equals(caracter) && Filas[2].equals(caracter)) win = true;
                if (Fila2[0].equals(caracter) && Fila2[1].equals(caracter) && Fila2[2].equals(caracter)) win = true;
                if (Fila3[0].equals(caracter) && Fila3[1].equals(caracter) && Fila3[2].equals(caracter)) win = true;

                if (Filas[0].equals(caracter) && Fila2[0].equals(caracter) && Fila3[0].equals(caracter)) win = true;
                if (Filas[1].equals(caracter) && Fila2[1].equals(caracter) && Fila3[1].equals(caracter)) win = true;
                if (Filas[2].equals(caracter) && Fila2[2].equals(caracter) && Fila3[2].equals(caracter)) win = true;

                if (Filas[0].equals(caracter) && Fila2[1].equals(caracter) && Fila3[2].equals(caracter)) win = true;
                if (Filas[2].equals(caracter) && Fila2[1].equals(caracter) && Fila3[0].equals(caracter)) win = true;

                if (win) {
                    for (int i = 0; i < Filas.length; i++) System.out.print(Filas[i]);
                    System.out.println();
                    for (int i = 0; i < Fila2.length; i++) System.out.print(Fila2[i]);
                    System.out.println();
                    for (int i = 0; i < Fila3.length; i++) System.out.print(Fila3[i]);
                    System.out.println();
                    break;
                }

                if (turnosContador == 9) {
                    break;
                }

                turn = !turn;
            } else {
                System.out.println("Casilla ya ocupada, intente de nuevo");
            }
        }
        SC.close();
    }
}