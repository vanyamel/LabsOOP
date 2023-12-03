package org.example.parser;

import org.example.model.CallPrices;
import org.example.model.Parameters;
import org.example.model.Tariff;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class SaxTariffHandler extends DefaultHandler {
    private List<Tariff> tariffs;
    private Tariff currentTariff;
    private CallPrices currentCallPrices;
    private Parameters currentParameters;
    private StringBuilder elementValue;

    public SaxTariffHandler() {
        tariffs = new ArrayList<>();
        elementValue = new StringBuilder();
    }

    public List<Tariff> getTariffs() {
        return tariffs;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementValue.setLength(0); // Очищення буфера
        if (qName.equalsIgnoreCase("Tariff")) {
            String id = attributes.getValue("id");
            currentTariff = new Tariff(id, null, null, 0, null, 0, null);
        } else if (qName.equalsIgnoreCase("CallPrices")) {
            currentCallPrices = new CallPrices(0, 0, 0);
        } else if (qName.equalsIgnoreCase("Parameters")) {
            currentParameters = new Parameters(0, null, 0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String value = elementValue.toString().trim();
        if (value.length() == 0) return; // Ігнорування пустих елементів

        switch (qName.toLowerCase()) {
            case "name":
                currentTariff.setName(value);
                break;
            case "operatorname":
                currentTariff.setOperatorName(value);
                break;
            case "payroll":
                currentTariff.setPayroll(Double.parseDouble(value));
                break;
            case "insidenetwork":
                currentCallPrices.setInsideNetwork(Double.parseDouble(value));
                break;
            case "outsidenetwork":
                currentCallPrices.setOutsideNetwork(Double.parseDouble(value));
                break;
            case "landline":
                currentCallPrices.setLandline(Double.parseDouble(value));
                break;
            case "callprices":
                currentTariff.setCallPrices(currentCallPrices);
                break;
            case "smsprice":
                currentTariff.setSmsPrice(Double.parseDouble(value));
                break;
            case "favoritenumbers":
                currentParameters.setFavoriteNumbers(Integer.parseInt(value));
                break;
            case "tariffication":
                currentParameters.setTariffication(value);
                break;
            case "connectionfee":
                currentParameters.setConnectionFee(Double.parseDouble(value));
                break;
            case "parameters":
                currentTariff.setParameters(currentParameters);
                break;
            case "tariff":
                tariffs.add(currentTariff);
                break;
        }
    }
}
