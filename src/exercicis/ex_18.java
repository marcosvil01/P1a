package exercicis;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class ex_18 {
    public static void main(String[] args) {
        try {
            // 1. Crear una instància de SAXParserFactory i obtenir un SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // 2. Definir el gestor de contingut (DefaultHandler)
            DefaultHandler handler = new DefaultHandler() {

                boolean isEmployee = false;
                boolean isSubDepartment = false;

                // Mètode cridat quan comença un element
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("employee")) {
                        isEmployee = true;
                        System.out.println("Employee:");
                        System.out.println("  Name: " + attributes.getValue("name"));
                        System.out.println("  Position: " + attributes.getValue("position"));
                        System.out.println("  Salary: " + attributes.getValue("salary"));
                    }
                    if (qName.equalsIgnoreCase("department")) {
                        System.out.println("Department: " + attributes.getValue("name"));
                    }
                    if (qName.equalsIgnoreCase("sub-department")) {
                        isSubDepartment = true;
                        System.out.println("  Sub-Department: " + attributes.getValue("name"));
                    }
                }

                // Mètode cridat quan acaba un element
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("employee")) {
                        isEmployee = false;
                    }
                    if (qName.equalsIgnoreCase("sub-department")) {
                        isSubDepartment = false;
                    }
                }

                // Mètode per processar el text dins d'un element
                public void characters(char[] ch, int start, int length) throws SAXException {
                    // No cal processar caràcters en aquest cas, ja que tots els atributs són processats per startElement
                }
            };

            // 3. Llegir el fitxer XML
            File inputFile = new File("files/company.xml");
            saxParser.parse(inputFile, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
