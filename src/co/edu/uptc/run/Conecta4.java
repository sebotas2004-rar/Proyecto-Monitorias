package co.edu.uptc.run;

import java.util.Scanner;

public class Conecta4 {

    public static void print(String[] fila1, String[] fila2, String[] fila3, String[] fila4) {
        System.out.println(" 1  2  3  4 ");
        
        for (int i = 0; i < fila1.length; i++) System.out.print("[" + fila1[i] + "]");
        System.out.println();
        for (int i = 0; i < fila2.length; i++) System.out.print("[" + fila2[i] + "]");
        System.out.println();
        for (int i = 0; i < fila3.length; i++) System.out.print("[" + fila3[i] + "]");
        System.out.println();
        for (int i = 0; i < fila4.length; i++) System.out.print("[" + fila4[i] + "]");
        System.out.println("\n-----------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] fila1 = { "#", "#", "#", "#" };
        String[] fila2 = { "#", "#", "#", "#" };
        String[] fila3 = { "#", "#", "#", "#" };
        String[] fila4 = { "#", "#", "#", "#" };

        String JA = "X";
        boolean win = false;
        int turno = 0;

        while (!win) {
            print(fila1, fila2, fila3, fila4);
            System.out.println("Turno de [" + JA + "]. Elija una columna (1-4): ");
            
            int input = sc.nextInt();
            int columna = input - 1;

            if (columna < 0 || columna > 3) {
                System.out.println("¡Número no válido! Intenta otra vez.");
                continue;
            }

            boolean jugadaV = false;

            if (fila4[columna].equals("#")) {
                fila4[columna] = JA;
                jugadaV = true;
            } else if (fila3[columna].equals("#")) {
                fila3[columna] = JA;
                jugadaV = true;
            } else if (fila2[columna].equals("#")) {
                fila2[columna] = JA;
                jugadaV = true;
            } else if (fila1[columna].equals("#")) {
                fila1[columna] = JA;
                jugadaV = true;
            } else {
                System.out.println("Esta columna ya está llena. Intenta en otra.");
            }

            if (jugadaV) {
                turno++;

                if (fila1[0].equals(JA) && fila1[1].equals(JA) && fila1[2].equals(JA) && fila1[3].equals(JA)) win = true;
                if (fila2[0].equals(JA) && fila2[1].equals(JA) && fila2[2].equals(JA) && fila2[3].equals(JA)) win = true;
                if (fila3[0].equals(JA) && fila3[1].equals(JA) && fila3[2].equals(JA) && fila3[3].equals(JA)) win = true;
                if (fila4[0].equals(JA) && fila4[1].equals(JA) && fila4[2].equals(JA) && fila4[3].equals(JA)) win = true;

                if (fila1[0].equals(JA) && fila2[0].equals(JA) && fila3[0].equals(JA) && fila4[0].equals(JA)) win = true;
                if (fila1[1].equals(JA) && fila2[1].equals(JA) && fila3[1].equals(JA) && fila4[1].equals(JA)) win = true;
                if (fila1[2].equals(JA) && fila2[2].equals(JA) && fila3[2].equals(JA) && fila4[2].equals(JA)) win = true;
                if (fila1[3].equals(JA) && fila2[3].equals(JA) && fila3[3].equals(JA) && fila4[3].equals(JA)) win = true;

                if (fila1[0].equals(JA) && fila2[1].equals(JA) && fila3[2].equals(JA) && fila4[3].equals(JA)) win = true;
                if (fila1[3].equals(JA) && fila2[2].equals(JA) && fila3[1].equals(JA) && fila4[0].equals(JA)) win = true;

                if (win) {
                    print(fila1, fila2, fila3, fila4);
                    break;
                }
                
                if (turno == 16) {
                    print(fila1, fila2, fila3, fila4);
                    break;
                }

                if (JA.equals("X")) {
                    JA = "O";
                } else {
                    JA = "X";
                }
            }
        }
        sc.close();
    }
}