package org.example.parser;

import org.example.model.Tariff;
import org.example.parser.SaxTariffHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.IOException;
import java.util.List;

public class SaxTariffParser {
    public List<Tariff> parseTariffs(String filename) throws SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        SaxTariffHandler handler = new SaxTariffHandler();
        reader.setContentHandler(handler);
        reader.parse(filename);
        return handler.getTariffs();
    }
}
