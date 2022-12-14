package com.dambi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.security.auth.kerberos.KerberosKey;
import javax.sound.sampled.SourceDataLine;
import javax.xml.stream.StreamFilter;
import javax.xml.transform.stream.StreamSource;

public class MainMenua {
    private static String[] zutabeak;
    private static Scanner in = new Scanner(System.in);

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
            System.out.println("4.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    mendienZerrendaIkusi2();
                    break;
                case 2:
                    mendiTxikiena();
                    // mendiAltuena();
                    break;
                case 3:
                    mendiakEsportatu();
                    break;
                case 4:
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

    public static void mendienZerrendaIkusi2() throws IOException {

        try (BufferedReader s = new BufferedReader(new FileReader("Mendiak.csv"))) {

            int lerroZenbakia = 0;
            String banatzailea = ";";

            String[] lineaBakoitza = null;
            String linea;
            while ((linea = s.readLine()) != null) {

                zutabeak = linea.split(banatzailea);
                if (lerroZenbakia != 0) {

                    lineaBakoitza = zutabeak;

                    System.out.printf("%10s | %3s | %8s", lineaBakoitza[0], lineaBakoitza[1], lineaBakoitza[2]);
                    System.out.println();

                }
                lerroZenbakia++;

            }

            s.close();

        }

    }

    public static void mendiAltuena() throws IOException {

        try (BufferedReader s = new BufferedReader(new FileReader("Mendiak.csv"))) {
            int lerroZenbakia = 0;
            String banatzailea = ";";
            String[] mendirikAltuena = null;
            String linea;
            while ((linea = s.readLine()) != null) {
                zutabeak = linea.split(banatzailea);
                if (lerroZenbakia != 0 && (mendirikAltuena == null
                        || Integer.parseInt(mendirikAltuena[1]) < Integer.parseInt(zutabeak[1]))) {
                    mendirikAltuena = zutabeak;
                }
                lerroZenbakia++;
            }

            System.out.printf("Mendirik altuena: ");
            System.out.printf("%10s | %3s | %8s", mendirikAltuena[0], mendirikAltuena[1], mendirikAltuena[2]);
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ez da fitxategia aurkitu");
        }

    }

    public static void mendiTxikiena() throws IOException {

        try (BufferedReader s = new BufferedReader(new FileReader("Mendiak.csv"))) {
            int lerroZenbakia = 0;
            String banatzailea = ";";
            String[] mendirikAltuena = null;
            String linea;
            while ((linea = s.readLine()) != null) {
                zutabeak = linea.split(banatzailea);
                if (lerroZenbakia != 0 && (mendirikAltuena == null
                        || Integer.parseInt(mendirikAltuena[1]) > Integer.parseInt(zutabeak[1]))) {
                    mendirikAltuena = zutabeak;
                }
                lerroZenbakia++;
            }

            System.out.printf("Mendirik altuena: ");
            System.out.printf("%10s | %3s | %8s", mendirikAltuena[0], mendirikAltuena[1], mendirikAltuena[2]);
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ez da fitxategia aurkitu");
        }

    }

    private static void mendiakEsportatu() throws IOException{
        System.out.println("Aukeratu probintzia");
        System.out.println("1.Araba");
        System.out.println("2.Bizkaia");
        System.out.println("3.Gipuzkoa");
        System.out.println("4.Nafarroa");
        System.out.print("Sartu zenbaki bat: ");
        int probintzia = in.nextInt();
        String aukeratutakoProbintzia = "";

        
        try (BufferedReader inputStream = new BufferedReader(new FileReader("Mendiak.csv"))){
            PrintWriter outputStream = new PrintWriter(new FileWriter("MendiGuztiak.csv"));
            switch(probintzia){
                case 1:
                    aukeratutakoProbintzia = "Araba";
                    outputStream = new PrintWriter(new FileWriter("Araba.csv"));
                    break;
                case 2:
                    aukeratutakoProbintzia = "Bizkaia";
                    outputStream = new PrintWriter(new FileWriter("Bizkaia.csv"));
                    break;
                case 3:
                    aukeratutakoProbintzia = "Gipuzkoa";
                    outputStream = new PrintWriter(new FileWriter("Gipuzkoa.csv"));
                    break;
                case 4:
                    aukeratutakoProbintzia = "Nafarroa";
                    outputStream = new PrintWriter(new FileWriter("Nafarroa.csv"));
                    break;
                default:
                    mendiakEsportatu();
                    break;
            }
            String banatzailea = ";";
            String l;
            while ((l = inputStream.readLine()) != null) {
                zutabeak = l.split(banatzailea);
                if(aukeratutakoProbintzia.equals(zutabeak[2])){
                    outputStream.println(l);
                }
            }
            inputStream.close();
            outputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("Ez da fitxategia aurkitu");
        }
    }
}

