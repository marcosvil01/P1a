package exercicis;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class ex_21 {
    public static void main(String[] args) {
        try {
            // 1. Preparar els fitxers XML i XSL
            File xmlFile = new File("files/Exercici22.xml");
            File xslFile = new File("files/Exercici26.xsl");

            // 2. Crear una instància de TransformerFactory
            TransformerFactory factory = TransformerFactory.newInstance();

            // 3. Crear el transformer a partir del fitxer XSL
            Source xslt = new StreamSource(xslFile);
            Transformer transformer = factory.newTransformer(xslt);

            // 4. Definir el fitxer de sortida (HTML)
            Source xmlSource = new StreamSource(xmlFile);
            StreamResult result = new StreamResult(new File("files/Exercici21.html"));

            // 5. Aplicar la transformació
            transformer.transform(xmlSource, result);

            System.out.println("Transformació completada. S'ha generat 'Exercici21.html'.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
