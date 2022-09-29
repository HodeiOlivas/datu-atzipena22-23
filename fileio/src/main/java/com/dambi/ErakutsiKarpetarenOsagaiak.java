package com.dambi;

import java.io.File;
import java.util.Scanner;

public class ErakutsiKarpetarenOsagaiak {



   

    public static void main(String[] args) throws Exception {
       
    
public static void ErakutsiKarpetarenOsagaia(File folder){
        System.out.println("Sartu nahi duzun helbidea: ");
        Scanner in =new Scanner (System.in);
        String helbidea = in.next();
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                System.out.println(file.getName());
            } else {
                ErakutsiKarpetarenOsagaia(file);
            }
           folder = new File(helbidea);
           ErakutsiKarpetarenOsagaia(folder);
        }              
}
    

}