
package dambi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Programa honek proiektuaren erroan dagoen Xanadu fitxategia bytez byte
 * irakurtzen du,byte bakoitza outagain.txt fitxategian idatziz.
 Fitxategia ez bada aurkitzen abisatuko digu programa.
 */

public class CopyBytesFNEKontrolatuz {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("./anadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c); }
        }
        catch (FileNotFoundException e ){

             System.out.println("Fitxategia ez da aurkitzen!");
            }
        
         finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
