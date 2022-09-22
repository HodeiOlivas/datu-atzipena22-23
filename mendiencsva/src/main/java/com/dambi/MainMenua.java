package com.dambi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainMenua {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENDIEN MENUA");
            System.out.println("====================================");
            System.out.println("1.- Mendien zerrenda ikusi (taula formatuan)");
            System.out.println("2.- Mendirik altuena bistaratu");
            System.out.println("3.- Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
            System.out.println("4.- ...");
            System.out.println("5.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    mendienZerrendaIkusi();
                    break;
                case 2:
                    mendiAltuena();
                    break;
                case 3:
                    mendiakEsportatu();
                    break;
                case 5:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.next();
    }

    public static void mendienZerrendaIkusi() throws FileNotFoundException {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("Mendiak.csv")));

            while (s.hasNext()) {
                System.out.println(s.next().replace(";", " | "));
                System.out.println("-------------------------------");
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    public static void mendiAltuena() throws FileNotFoundException {
       String mendiakKatea;

        try {
            FileReader mendia = new FileReader("Mendiak.csv");
            BufferedReader a = new BufferedReader(mendia);
            int altuena = 0;
            while ((mendiakKatea = a.readLine()) != null) {
               // split-ek String motako array bat itzultzen du, int bihurtzeko cast bat egiten dugu
               int[] parts = Stream.of(mendiakKatea.split(",")).mapToInt(Integer::parseInt).toArray();
               for (int i=0;i<parts.length;i++ ) {
                //iteramos y comparamos para obtener el mayor
                if(altuena<parts[i]){
                    altuena=parts[i];
                 }
            }
        } finally {
            if (s != null) {
                BufferedReader mendia;
                mendia.close();;
            }
        }

    }

    public static void mendiakEsportatu() {

    }

}
