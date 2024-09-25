package exercicis;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class ex_19 {
    public static void main(String[] args) {
        try {
            // 1. Llegir el fitxer XML existent
            File inputFile = new File("files/company.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputFile);
            document.getDocumentElement().normalize();

            // Mostra el contingut actual a la consola
            System.out.println("Contingut actual del fitxer XML:");
            NodeList departmentList = document.getElementsByTagName("department");
            printEmployees(departmentList);

            // 2. Actualitzar el salari i la posició de l'empleat amb ID 3
            updateEmployee(document, "Charlie", "Senior Developer", "65000");

            // 3. Esborrar l'empleat amb ID 4
            deleteEmployee(document, "Eve");

            // 4. Escriure el fitxer XML actualitzat a un nou fitxer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("files/updated_employees.xml"));
            transformer.transform(source, result);

            System.out.println("El fitxer actualitzat s'ha desat com a updated_employees.xml.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mètode per mostrar el contingut del fitxer XML a la consola
    private static void printEmployees(NodeList departmentList) {
        for (int i = 0; i < departmentList.getLength(); i++) {
            Node departmentNode = departmentList.item(i);
            if (departmentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element department = (Element) departmentNode;
                System.out.println("Department: " + department.getAttribute("name"));

                NodeList employeeList = department.getElementsByTagName("employee");
                for (int j = 0; j < employeeList.getLength(); j++) {
                    Element employee = (Element) employeeList.item(j);
                    System.out.println("  Name: " + employee.getAttribute("name"));
                    System.out.println("  Position: " + employee.getAttribute("position"));
                    System.out.println("  Salary: " + employee.getAttribute("salary"));
                }
            }
        }
    }

    // Mètode per actualitzar l'empleat
    private static void updateEmployee(Document document, String employeeName, String newPosition, String newSalary) {
        NodeList employees = document.getElementsByTagName("employee");
        for (int i = 0; i < employees.getLength(); i++) {
            Element employee = (Element) employees.item(i);
            if (employee.getAttribute("name").equals(employeeName)) {
                employee.setAttribute("position", newPosition);
                employee.setAttribute("salary", newSalary);
                System.out.println("Empleat " + employeeName + " actualitzat amb èxit.");
                return;
            }
        }
    }

    // Mètode per esborrar un empleat
    private static void deleteEmployee(Document document, String employeeName) {
        NodeList employees = document.getElementsByTagName("employee");
        for (int i = 0; i < employees.getLength(); i++) {
            Element employee = (Element) employees.item(i);
            if (employee.getAttribute("name").equals(employeeName)) {
                employee.getParentNode().removeChild(employee);
                System.out.println("Empleat " + employeeName + " esborrat amb èxit.");
                return;
            }
        }
    }
}
