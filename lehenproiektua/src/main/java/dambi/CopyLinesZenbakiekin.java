package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

/** Programa honek proiektuaren erroan dagoen Xanadu fitxategia lineaz lineaz irakurtzen du, linea bakoitza linesZenbakiekin.txt" fitxategian idatziz.
 * Linea bakoitzaren hasieran linea zenbakiak jarriko ditu.
     */

public class CopyLinesZenbakiekin {
    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("./xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("linesZenbakiekin.txt"));

            String l;
            int zenbakia =1;
            while ((l = inputStream.readLine()) != null) {
                
                
               outputStream.println(zenbakia+" "+l);
                zenbakia = zenbakia +1;

            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
