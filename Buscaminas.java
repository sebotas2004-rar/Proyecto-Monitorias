package co.edu.uptc.run;

import java.util.Scanner;

public class Buscaminas {

    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);

        String[] Filas = { "#", "#", "#", "#" };
        String[] Fila2 = { "#", "#", "#", "#" };
        String[] Fila3 = { "#", "#", "#", "#" };
        String[] Fila4 = { "#", "#", "#", "#" };

        String[] Minas1 = { "1", "1", "1", "0" };
        String[] Minas2 = { "*", "2", "1", "0" };
        String[] Minas3 = { "2", "*", "2", "1" };
        String[] Minas4 = { "1", "1", "2", "*" };

        boolean juegoActivo = true;
        int casillasDespejadas = 0;

        while (juegoActivo) {
            for (int i = 0; i < Filas.length; i++) System.out.print("[" + Filas[i] + "]");
            System.out.println();
            for (int i = 0; i < Fila2.length; i++) System.out.print("[" + Fila2[i] + "]");
            System.out.println();
            for (int i = 0; i < Fila3.length; i++) System.out.print("[" + Fila3[i] + "]");
            System.out.println();
            for (int i = 0; i < Fila4.length; i++) System.out.print("[" + Fila4[i] + "]");
            System.out.println();

            System.out.println("Ingrese coordenadas (Fila X y Columna Y):");
            int X = SC.nextInt();
            int Y = SC.nextInt();

            if (X < 1 || X > 4 || Y < 1 || Y > 4) {
                System.out.println("No valido");
                continue;
            }

            int posicion = Y - 1;
            boolean jugadaValida = false;

            if (X == 1) {
                if (Filas[posicion].equals("#")) {
                    if (Minas1[posicion].equals("*")) {
                        Filas[posicion] = "*";
                        juegoActivo = false;
                    } else {
                        Filas[posicion] = Minas1[posicion];
                        jugadaValida = true;
                    }
                }
            } else if (X == 2) {
                if (Fila2[posicion].equals("#")) {
                    if (Minas2[posicion].equals("*")) {
                        Fila2[posicion] = "*";
                        juegoActivo = false;
                    } else {
                        Fila2[posicion] = Minas2[posicion];
                        jugadaValida = true;
                    }
                }
            } else if (X == 3) {
                if (Fila3[posicion].equals("#")) {
                    if (Minas3[posicion].equals("*")) {
                        Fila3[posicion] = "*";
                        juegoActivo = false;
                    } else {
                        Fila3[posicion] = Minas3[posicion];
                        jugadaValida = true;
                    }
                }
            } else if (X == 4) {
                if (Fila4[posicion].equals("#")) {
                    if (Minas4[posicion].equals("*")) {
                        Fila4[posicion] = "*";
                        juegoActivo = false;
                    } else {
                        Fila4[posicion] = Minas4[posicion];
                        jugadaValida = true;
                    }
                }
            }

            if (!juegoActivo) {
                for (int i = 0; i < Filas.length; i++) if (Minas1[i].equals("*")) Filas[i] = "*";
                for (int i = 0; i < Fila2.length; i++) if (Minas2[i].equals("*")) Fila2[i] = "*";
                for (int i = 0; i < Fila3.length; i++) if (Minas3[i].equals("*")) Fila3[i] = "*";
                for (int i = 0; i < Fila4.length; i++) if (Minas4[i].equals("*")) Fila4[i] = "*";
                
                for (int i = 0; i < Filas.length; i++) System.out.print("[" + Filas[i] + "]");
                System.out.println();
                for (int i = 0; i < Fila2.length; i++) System.out.print("[" + Fila2[i] + "]");
                System.out.println();
                for (int i = 0; i < Fila3.length; i++) System.out.print("[" + Fila3[i] + "]");
                System.out.println();
                for (int i = 0; i < Fila4.length; i++) System.out.print("[" + Fila4[i] + "]");
                System.out.println();
                break;
            }

            if (jugadaValida) {
                casillasDespejadas++;
                if (casillasDespejadas == 13) {
                    break;
                }
            }
        }
        SC.close();
    }
}