package com.dambi;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.text.ParseException;

import javax.sound.sampled.SourceDataLine;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;


public class JavaFilePath {





    public static void main(String[] args) throws Exception {
       
       
        Scanner in = new Scanner(System.in);
       
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENUAREN IZENBURUA");
            System.out.println("====================================");
            System.out.println("1.- Lehen Aukera");
            System.out.println("2.- Bigarren Aukera");
            System.out.println("3.- ...");
            System.out.println("4.- ...");
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
                
                case 5:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.next();
}

public static void  existitzenda(){
    System.out.println("Sartu nahi duzun helbidea: ");
    Scanner in =new Scanner (System.in);
    String helbidea = in.next();

    Path p1 = Paths.get(helbidea);
	

	//private static void printPaths(Path p1) throws IOException {
		System.out.println("Absolute Path: " + p1.toAbsolutePath());
      
	
	//}
     File archivo = new File(helbidea);
        if (archivo.exists()) {
            if (archivo.isFile()) System.out.println("Exists!, its a file");
            if (archivo.isDirectory()) System.out.println("Exists!, its a folder");
        }
        else {
            System.out.println("No exists!");
        }
}

public static void ErakutsiKarpetarenOsagaiak(File folder){
       
    
            System.out.println("Sartu nahi duzun helbidea: ");
            Scanner in =new Scanner (System.in);
            String helbidea = in.next();
            for (File file : folder.listFiles()) {
                if (!file.isDirectory()) {
                    System.out.println(file.getName());
                } else {
                    ErakutsiKarpetarenOsagaiak(file);
                }
               folder = new File(helbidea);
               ErakutsiKarpetarenOsagaiak(folder);
            }              
    }
}