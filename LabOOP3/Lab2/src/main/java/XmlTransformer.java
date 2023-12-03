package org.example;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XmlTransformer {
    public static void transformXmlToHtml(String xmlPath, String xsltPath, String outputPath) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslStream = new StreamSource(new File(xsltPath));
        Transformer transformer = factory.newTransformer(xslStream);

        StreamSource in = new StreamSource(new File(xmlPath));
        StreamResult out = new StreamResult(new File(outputPath));
        transformer.transform(in, out);
    }
}