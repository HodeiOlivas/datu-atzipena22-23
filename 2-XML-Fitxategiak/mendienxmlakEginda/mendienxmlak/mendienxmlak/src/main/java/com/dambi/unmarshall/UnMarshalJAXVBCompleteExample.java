package com.dambi.unmarshall;
import java.io.File;

import com.dambi.business.Mendiak;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;


/**
 * This class shows how to unmarshall a simple XML structure into java classes
 * 
 * @author dgutierrez-diez
 */
public class UnMarshalJAXVBCompleteExample
{
    public static void main( String[] args )
    {

        try
        {

            File file = new File( "hirumendi.xml" );
            // File file = new File( "countries.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( Mendiak.class );

            /**
             * the only difference with the marshaling operation is here
             */
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Mendiak mendi = (Mendiak)jaxbUnmarshaller.unmarshal( file );
            System.out.println( mendi );

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }

}
