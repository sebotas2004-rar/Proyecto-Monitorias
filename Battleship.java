package co.edu.uptc.run;

import java.util.Scanner;
import java.util.Random;

public class Battleship {
	
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        Random ran = new Random();

        String[] Filas = { "#", "#", "#", "#", "#" };
        String[] Fila2 = { "#", "#", "#", "#", "#" };
        String[] Fila3 = { "#", "#", "#", "#", "#" };
        String[] Fila4 = { "#", "#", "#", "#", "#" };
        String[] Fila5 = { "#", "#", "#", "#", "#" };

        String[][] Barcos = {
            { " ", " ", " ", " ", " " },
            { " ", " ", " ", " ", " " },
            { " ", " ", " ", " ", " " },
            { " ", " ", " ", " ", " " },
            { " ", " ", " ", " ", " " }
        };

        int[] tamaños = {3, 2, 1};
        for (int b = 0; b < tamaños.length; b++) {
            int tam = tamaños[b];
            boolean colocado = false;
            while (!colocado) {
                int orientacion = ran.nextInt(2); 
                int filaRad = ran.nextInt(5);
                int colRad = ran.nextInt(5);
                
                boolean espacioLibre = true;
                if (orientacion == 0) { 
                    if (colRad + tam <= 5) {
                        for (int i = 0; i < tam; i++) {
                            if (!Barcos[filaRad][colRad + i].equals(" ")) espacioLibre = false;
                        }
                        if (espacioLibre) {
                            for (int i = 0; i < tam; i++) Barcos[filaRad][colRad + i] = "*";
                            colocado = true;
                        }
                    }
                } else { 
                    if (filaRad + tam <= 5) {
                        for (int i = 0; i < tam; i++) {
                            if (!Barcos[filaRad + i][colRad].equals(" ")) espacioLibre = false;
                        }
                        if (espacioLibre) {
                            for (int i = 0; i < tam; i++) Barcos[filaRad + i][colRad] = "*";
                            colocado = true;
                        }
                    }
                }
            }
        }

        boolean partidaActiva = true;
        int barcosHundidos = 0;

        while (partidaActiva) {
            System.out.println("TABLERO 1 (DISPAROS):");
            for (int i = 0; i < 5; i++) System.out.print("[" + Filas[i] + "]");
            System.out.println();
            for (int i = 0; i < 5; i++) System.out.print("[" + Fila2[i] + "]");
            System.out.println();
            for (int i = 0; i < 5; i++) System.out.print("[" + Fila3[i] + "]");
            System.out.println();
            for (int i = 0; i < 5; i++) System.out.print("[" + Fila4[i] + "]");
            System.out.println();
            for (int i = 0; i < 5; i++) System.out.print("[" + Fila5[i] + "]");
            System.out.println();

            System.out.println("TABLERO 2 (BARCOS):");
            for (int i = 0; i < 5; i++) System.out.print("[" + Barcos[0][i] + "]");
            System.out.println();
            for (int i = 0; i < 5; i++) System.out.print("[" + Barcos[1][i] + "]");
            System.out.println();
            for (int i = 0; i < 5; i++) System.out.print("[" + Barcos[2][i] + "]");
            System.out.println();
            for (int i = 0; i < 5; i++) System.out.print("[" + Barcos[3][i] + "]");
            System.out.println();
            for (int i = 0; i < 5; i++) System.out.print("[" + Barcos[4][i] + "]");
            System.out.println("\n-----------------");

            System.out.println("Ingrese las coordenadas (Fila X y Columna Y):");
            int X = SC.nextInt() - 1;
            int Y = SC.nextInt() - 1;

            if (X < 0 || X > 4 || Y < 0 || Y > 4) {
                System.out.println("Coordenadas no validas");
                continue;
            }

            boolean yaDisparado = false;
            if (X == 0 && !Filas[Y].equals("#")) yaDisparado = true;
            else if (X == 1 && !Fila2[Y].equals("#")) yaDisparado = true;
            else if (X == 2 && !Fila3[Y].equals("#")) yaDisparado = true;
            else if (X == 3 && !Fila4[Y].equals("#")) yaDisparado = true;
            else if (X == 4 && !Fila5[Y].equals("#")) yaDisparado = true;

            if (yaDisparado) {
                System.out.println("Ya disparaste aqui, intenta de nuevo");
                continue;
            }

            if (Barcos[X][Y].equals("*")) {
                if (X == 0) Filas[Y] = "X";
                else if (X == 1) Fila2[Y] = "X";
                else if (X == 2) Fila3[Y] = "X";
                else if (X == 3) Fila4[Y] = "X";
                else if (X == 4) Fila5[Y] = "X";
                
                Barcos[X][Y] = "X";
                barcosHundidos++;
            } else {
                if (X == 0) Filas[Y] = "O";
                else if (X == 1) Fila2[Y] = "O";
                else if (X == 2) Fila3[Y] = "O";
                else if (X == 3) Fila4[Y] = "O";
                else if (X == 4) Fila5[Y] = "O";
                
                Barcos[X][Y] = "O";
            }

            if (barcosHundidos == 6) {
                System.out.println("TABLERO DISPAROS FINAL:");
                for (int i = 0; i < 5; i++) System.out.print("[" + Filas[i] + "]");
                System.out.println();
                for (int i = 0; i < 5; i++) System.out.print("[" + Fila2[i] + "]");
                System.out.println();
                for (int i = 0; i < 5; i++) System.out.print("[" + Fila3[i] + "]");
                System.out.println();
                for (int i = 0; i < 5; i++) System.out.print("[" + Fila4[i] + "]");
                System.out.println();
                for (int i = 0; i < 5; i++) System.out.print("[" + Fila5[i] + "]");
                System.out.println();
                break;
            }
        }
        SC.close();
    }
}