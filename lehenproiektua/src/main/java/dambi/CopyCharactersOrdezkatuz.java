package dambi;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**Programa hau,  Xanadu.txt fitxategiko testuaren karaktere bakoitzak banaka banaka irakurtzen ditu eta
 * a letra daukaten karaktereak i letrengatik aldatzen ditu.

 */

public class CopyCharactersOrdezkatuz {

    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;


     


        try {
            inputStream = new FileReader("./xanadu.txt");
            outputStream = new FileWriter("ordezkatu.txt");

            int c;
            while ((c = inputStream.read()) != -1) {

                if (c == 97){
                    c = 111;}

                if (c == 65){
                     c = 79; }
                     
                outputStream.write(c);
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

        
    
