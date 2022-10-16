package com.dambi;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.text.ParseException;

import javax.sound.sampled.SourceDataLine;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

public class JavaFilePath {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENUAREN IZENBURUA");
            System.out.println("====================================");
            System.out.println("1.- Fitxategia edo karpeta existitzen dela egiaztatu");
            System.out.println("2.- Karpeta baten edukia bistaratu");
            System.out.println("3.- Fitxategia sortu");

            System.out.println("5.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    existitzenda();
                    break;
                case 2:
                    ErakutsiKarpetarenOsagaiak();
                    break;
                case 3:
                    fitxategiaSortu();
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

    public static void existitzenda() {
        System.out.println("Sartu nahi duzun helbidea: ");
        Scanner in = new Scanner(System.in);
        String helbidea = in.next();

        Path p1 = Paths.get(helbidea);

        // private static void printPaths(Path p1) throws IOException {
        System.out.println("Absolute Path: " + p1.toAbsolutePath());

        // }
        File archivo = new File(helbidea);
        if (archivo.exists()) {
            if (archivo.isFile())
                System.out.println("Exists!, its a file");
            if (archivo.isDirectory())
                System.out.println("Exists!, its a folder");
        } else {
            System.out.println("No exists!");
        }
    }

    public static void ErakutsiKarpetarenOsagaiak() {

        System.out.print("Sartu karpeta edo fitxategiaren path-a: ");
        
        String pathIzena = in.next();

        File f = new File(pathIzena);
        if (f.exists()) {
            File[] files = f.listFiles();
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
            }
        } else {
            System.out.println(pathIzena + " ez da existitzen");
        }
    }



    private static void fitxategiaSortu() throws IOException{
        System.out.print("Zer zoaz deskribatzera(Ugaztuna,Arraina,Barazkia,Esnekia): ");
        String karpeta = in.next();
        System.out.print("Zein: ");
        String fitxategia = in.next();
        System.out.print("Nolakoa da: ");
        in.nextLine();
        String deskribapena = in.nextLine();

        if(karpeta.toLowerCase().equals("ugaztuna") || karpeta.toLowerCase().equals("arraina")){
            File f = new File("C:\\Users\\Hodei\\Documents\\GitHub\\datu-atzipena22-23\\1-FitxategiakStreamModuanAtzitzekoak\\fileio\\karpeta_berriak\\animaliak" + "\\" + karpeta + "k\\" + fitxategia + ".txt");
            if(f.createNewFile()){
                System.out.println("Fitxategia sortu da: " + f.getName());
                PrintWriter out = new PrintWriter(f);
                out.write(deskribapena);
                out.close();
            }
        }else if(karpeta.toLowerCase().equals("barazkia") || karpeta.toLowerCase().equals("esnekia")){
            File f = new File("C:\\Users\\soto.aitzol\\Desktop\\datu-atzipena22-23\\1-Fitxategiak\\fileio\\src\\karpeta berriak\\elikagaiak" + "\\" + karpeta + "k\\" + fitxategia + ".txt");
            if(f.createNewFile()){
                System.out.println("Fitxategia sortu da: " + f.getName());
                PrintWriter out = new PrintWriter(f);
                out.write(deskribapena);
                out.close();
            }
        }else{
            System.out.println("Fitxategia ez da sortu,ez da karpeta aurkitu");
        }
    }

}
