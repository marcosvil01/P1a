package exercicis;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class ex_17 {
    public static void main(String[] args) {
        try {
            // 1. Crear una instància de DocumentBuilderFactory i DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 2. Crear el document XML i el node arrel <company>
            Document document = builder.newDocument();
            Element company = document.createElement("company");
            document.appendChild(company);

            // 3. Crear el departament IT i afegir empleats
            Element departmentIT = document.createElement("department");
            departmentIT.setAttribute("name", "IT");
            company.appendChild(departmentIT);

            // Afegir empleats al departament IT
            Element employee1 = createEmployee(document, "Alice", "Developer", "50000");
            departmentIT.appendChild(employee1);

            Element employee2 = createEmployee(document, "Bob", "SysAdmin", "45000");
            departmentIT.appendChild(employee2);

            // Afegir un sub-departament dins del departament IT
            Element subDepartment = document.createElement("sub-department");
            subDepartment.setAttribute("name", "Security");
            departmentIT.appendChild(subDepartment);

            // Afegir empleat al sub-departament Security
            Element employee3 = createEmployee(document, "Charlie", "Security Analyst", "55000");
            subDepartment.appendChild(employee3);

            // 4. Crear el departament HR i afegir empleats
            Element departmentHR = document.createElement("department");
            departmentHR.setAttribute("name", "HR");
            company.appendChild(departmentHR);

            Element employee4 = createEmployee(document, "Dana", "HR Manager", "60000");
            departmentHR.appendChild(employee4);

            Element employee5 = createEmployee(document, "Eve", "Recruiter", "40000");
            departmentHR.appendChild(employee5);

            // 5. Escriure l'XML a un fitxer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("files/company.xml"));
            transformer.transform(domSource, streamResult);

            System.out.println("El fitxer XML s'ha generat correctament!");
            // 6. Mostrar resultat
            StreamResult console = new StreamResult(System.out);
            transformer.transform(domSource, console);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mètode per crear un node <employee> amb atributs
    private static Element createEmployee(Document document, String name, String position, String salary) {
        Element employee = document.createElement("employee");
        employee.setAttribute("name", name);
        employee.setAttribute("position", position);
        employee.setAttribute("salary", salary);
        return employee;
    }
}
