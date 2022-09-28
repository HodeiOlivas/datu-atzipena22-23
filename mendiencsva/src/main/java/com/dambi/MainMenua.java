package com.dambi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.sound.sampled.SourceDataLine;
import javax.xml.stream.StreamFilter;
import javax.xml.transform.stream.StreamSource;



public class MainMenua {
    private static String[] zutabeak;
    private Scanner in = new Scanner(System.in);
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
                    mendienZerrendaIkusi();
                    break;
                case 2:
                    mendiAltuena();
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

    public static void mendiAltuena() throws IOException {

/* 
        try (BufferedReader s = new BufferedReader(new FileReader("Mendiak.csv"))){
            int lerroZenbakia = 0;
            String banatzailea = ";";
            String[] mendirikAltuena = null;
            String l;
            while ((l = s.readLine()) != null) {
                zutabeak = l.split(banatzailea);
                if(lerroZenbakia != 0 && (mendirikAltuena == null || Integer.parseInt(mendirikAltuena[1]) < Integer.parseInt(zutabeak[1]))){
                    mendirikAltuena = zutabeak;
                }
                lerroZenbakia++;
            }

            System.out.println("Mendirik altuena: ");
            System.out.printf("%10s | %8s | %10s",mendirikAltuena[0],mendirikAltuena[1],mendirikAltuena[2]);
            s.close();
        }catch(FileNotFoundException e){
            System.out.println("Ez da fitxategia aurkitu");
        }
    


*/







      /*   Scanner s = null;
        String mendia;
        int kont;
        int altuera = 0;
        String probintzia;
        String zakarrontzia;

        try {
            s = new Scanner(new BufferedReader(new FileReader("Mendiak.csv")));
           
           
            while (s.hasNext()) {
               // s.next().replace(";", " ");
                
                s.useDelimiter(";"+" ");
                
                mendia = s.next();
                try{
                 int itest = Integer.parseInt(s.next()); 
                 kont = itest;
             
                if (altuera <= kont ){
                    altuera = kont;
                    probintzia = s.next();
                   
                } else {
                   
                   probintzia = s.next();
                }
              
            } finally {
                if (s != null) {
                    
                }
         
            }
            System.out.println(kont);
            System.out.println(altuera);

        }   
            
            
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

      */
    
    }

    public static void mendiakEsportatu() {

    }


}
