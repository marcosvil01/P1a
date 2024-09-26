package exercicis;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class ex_20 {
    public static void main(String[] args) {
        try {
            // 1. Crear una instància de SAXParserFactory i obtenir un SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // 2. Definir el gestor de contingut (DefaultHandler) per comptar els empleats
            DefaultHandler handler = new DefaultHandler() {

                int count = 0; // Comptador d'elements <empleat>

                // Aquest mètode es crida quan es troba l'inici d'un element
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("employee")) {
                        count++; // Incrementem el comptador cada vegada que trobem un <empleat>
                    }
                }

                // Aquest mètode es crida quan s'acaba de llegir el document
                public void endDocument() throws SAXException {
                    // Mostrar el nombre total d'elements <empleat>
                    System.out.println("Nombre total d'empleats: " + count);
                }
            };

            // 3. Llegir el fitxer XML
            File inputFile = new File("files/employees.xml");
            saxParser.parse(inputFile, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
