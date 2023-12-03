package org.example.parser;

import org.example.model.CallPrices;
import org.example.model.Parameters;
import org.example.model.Tariff;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class DomTariffParser {

    public List<Tariff> parseTariffs(String filename) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(filename);

        List<Tariff> tariffs = new ArrayList<>();
        NodeList nodeList = document.getDocumentElement().getElementsByTagName("Tariff");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element tariffElement = (Element) nodeList.item(i);
            tariffs.add(buildTariff(tariffElement));
        }

        return tariffs;
    }

    private Tariff buildTariff(Element element) {
        String id = element.getAttribute("id");
        String name = getElementTextContent(element, "Name");
        String operatorName = getElementTextContent(element, "OperatorName");
        double payroll = Double.parseDouble(getElementTextContent(element, "Payroll"));
        CallPrices callPrices = buildCallPrices((Element) element.getElementsByTagName("CallPrices").item(0));
        double smsPrice = Double.parseDouble(getElementTextContent(element, "SMSPrice"));
        Parameters parameters = buildParameters((Element) element.getElementsByTagName("Parameters").item(0));

        return new Tariff(id, name, operatorName, payroll, callPrices, smsPrice, parameters);
    }

    private CallPrices buildCallPrices(Element element) {
        double insideNetwork = Double.parseDouble(getElementTextContent(element, "InsideNetwork"));
        double outsideNetwork = Double.parseDouble(getElementTextContent(element, "OutsideNetwork"));
        double landline = Double.parseDouble(getElementTextContent(element, "Landline"));

        return new CallPrices(insideNetwork, outsideNetwork, landline);
    }

    private Parameters buildParameters(Element element) {
        int favoriteNumbers = Integer.parseInt(getElementTextContent(element, "FavoriteNumbers"));
        String tariffication = getElementTextContent(element, "Tariffication");
        double connectionFee = Double.parseDouble(getElementTextContent(element, "ConnectionFee"));

        return new Parameters(favoriteNumbers, tariffication, connectionFee);
    }

    private String getElementTextContent(Element parentElement, String elementName) {
        return parentElement.getElementsByTagName(elementName).item(0).getTextContent();
    }
}
