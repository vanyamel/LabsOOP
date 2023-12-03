package org.example;


import org.example.util.XmlValidator;

public class Main {
    public static void main(String[] args) {
        String xsdPath = "src/main/resources/tariffs.xsd";
        String xmlPath = "src/main/resources/tariffs.xml";

        boolean isValid = XmlValidator.validateXMLSchema(xsdPath, xmlPath);
        if (isValid) {
            System.out.println("XML is valid against the XSD.");
        } else {
            System.out.println("XML is not valid against the XSD.");
        }

        try {
            XmlTransformer.transformXmlToHtml("src/main/resources/tariffs.xml", "src/main/resources/tariffs.xslt", "src/main/resources/output.html");
            System.out.println("Transformation completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}