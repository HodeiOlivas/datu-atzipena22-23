package com.dambi.marshall;

import java.io.File;

import com.dambi.business.Mendia;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;


/**
 * Simple example of usage of jaxb marshaling functionalities
 * 
 * @author dgutierrez-diez
 */
public class MendiBatSortu
{

    public static void main( String[] args )
    {
        try
        {

            /* init very simple data to marshal */
            /*
             Anboto;1331;Bizkaia
             */
            Mendia anboto = new Mendia();
            anboto.setIzena("Anboto");
            anboto.setAltuera(1331);
            anboto.setProbintzia("Bizkaia");
            anboto.setImportance(6);


            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance( Mendia.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( anboto, new File( "mendibat.xml" ) );
            jaxbMarshaller.marshal( anboto, System.out );
        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }
}