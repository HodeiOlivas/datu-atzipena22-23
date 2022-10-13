package dambi;

import java.io.*;
import java.util.Scanner;

/** Programa hau xanadu fitxategiko hitz bakoitza hartzen du linea desberdinetan kokatuz.  
    */ 
public class ScanXan {
    public static void main(String[] args) throws IOException {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));

            while (s.hasNext()) { //hasNext() metodoa konprobatzen du ea hurrengo hutsunea karakterea edo hutsune zuria den, hutsune zuria bada hurrengo karakterea hitzarengandik banaduko da.
                System.out.println(s.next()); // next() salto de linea
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}