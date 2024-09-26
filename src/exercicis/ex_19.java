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
            File inputFile = new File("files/employees.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputFile);
            document.getDocumentElement().normalize();

            // Mostrem el contingut actual del fitxer XML a la consola
            System.out.println("============ Contingut Inicial del Fitxer XML ============");
            NodeList departmentList = document.getElementsByTagName("department");
            printEmployees(departmentList);

            // 2. Actualitzar el salari i la posició de l'empleat amb ID 3 (segons la seva posició)
            updateEmployeeByPosition(document, 3, "Senior Developer", "65000");

            // 3. Esborrar l'empleat amb ID 4 (segons la seva posició)
            deleteEmployeeByPosition(document, 4);

            // 4. Escriure el fitxer XML actualitzat a un nou fitxer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("files/updated_employees.xml"));
            transformer.transform(source, result);

            // Mostrem les modificacions a la consola
            System.out.println("============ Contingut Després de les Modificacions ============");
            printEmployees(departmentList);

            System.out.println("El fitxer actualitzat s'ha desat com a 'updated_employees.xml'.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mètode per mostrar el contingut del fitxer XML de manera ordenada i ben formatejada
    private static void printEmployees(NodeList departmentList) {
        int idCounter = 1; // Comptador per assignar un ID simulat
        for (int i = 0; i < departmentList.getLength(); i++) {
            Node departmentNode = departmentList.item(i);
            if (departmentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element department = (Element) departmentNode;
                System.out.println("\n---------------------------------------");
                System.out.println("Departament: " + department.getAttribute("name"));
                System.out.println("---------------------------------------");

                NodeList employeeList = department.getElementsByTagName("employee");
                for (int j = 0; j < employeeList.getLength(); j++) {
                    Element employee = (Element) employeeList.item(j);
                    System.out.println("Empleat ID: " + idCounter +
                            "  Nom: " + employee.getAttribute("name") +
                            "  Posició: " + employee.getAttribute("position") +
                            "  Salari: " + employee.getAttribute("salary"));
                    idCounter++;
                }
            }
        }
    }

    // Mètode per actualitzar un empleat segons la seva posició a la llista d'empleats
    private static void updateEmployeeByPosition(Document document, int employeeId, String newPosition, String newSalary) {
        NodeList employees = document.getElementsByTagName("employee");
        if (employeeId > 0 && employeeId <= employees.getLength()) {
            Element employee = (Element) employees.item(employeeId - 1); // L'índex comença des de 0, per això fem -1
            employee.setAttribute("position", newPosition);
            employee.setAttribute("salary", newSalary);
            System.out.println("Empleat amb ID " + employeeId + " actualitzat amb èxit.");
        } else {
            System.out.println("Error: No s'ha trobat cap empleat amb ID " + employeeId);
        }
    }

    // Mètode per esborrar un empleat segons la seva posició a la llista d'empleats
    private static void deleteEmployeeByPosition(Document document, int employeeId) {
        NodeList employees = document.getElementsByTagName("employee");
        if (employeeId > 0 && employeeId <= employees.getLength()) {
            Element employee = (Element) employees.item(employeeId - 1); // L'índex comença des de 0, per això fem -1
            employee.getParentNode().removeChild(employee);
            System.out.println("Empleat amb ID " + employeeId + " esborrat amb èxit.");
        } else {
            System.out.println("Error: No s'ha trobat cap empleat amb ID " + employeeId);
        }
    }
}
