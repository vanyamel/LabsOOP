package org.example.parser;

import org.example.model.CallPrices;
import org.example.model.Parameters;
import org.example.model.Tariff;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.namespace.QName;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class StaxTariffParser {

    public List<Tariff> parseTariffs(String filename) throws Exception {
        List<Tariff> tariffs = new ArrayList<>();
        String id = null, name = null, operatorName = null, tariffication = null;
        double payroll = 0, smsPrice = 0, insideNetwork = 0, outsideNetwork = 0, landline = 0, connectionFee = 0;
        int favoriteNumbers = 0;
        boolean isInsideCallPrices = false, isInsideParameters = false;

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = factory.createXMLEventReader(new FileInputStream(filename));

        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();

            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                String qName = startElement.getName().getLocalPart();

                switch (qName) {
                    case "Tariff":
                        id = startElement.getAttributeByName(new QName("id")).getValue();
                        break;
                    case "CallPrices":
                        isInsideCallPrices = true;
                        break;
                    case "Parameters":
                        isInsideParameters = true;
                        break;
                }
            } else if (event.isCharacters()) {
                Characters characters = event.asCharacters();
                String data = characters.getData().trim();

                if (!data.isEmpty()) {
                    if (isInsideCallPrices) {
                        if (event.asStartElement().getName().getLocalPart().equals("InsideNetwork")) {
                            insideNetwork = Double.parseDouble(data);
                        } else if (event.asStartElement().getName().getLocalPart().equals("OutsideNetwork")) {
                            outsideNetwork = Double.parseDouble(data);
                        } else if (event.asStartElement().getName().getLocalPart().equals("Landline")) {
                            landline = Double.parseDouble(data);
                        }
                    } else if (isInsideParameters) {
                        if (event.asStartElement().getName().getLocalPart().equals("FavoriteNumbers")) {
                            favoriteNumbers = Integer.parseInt(data);
                        } else if (event.asStartElement().getName().getLocalPart().equals("Tariffication")) {
                            tariffication = data;
                        } else if (event.asStartElement().getName().getLocalPart().equals("ConnectionFee")) {
                            connectionFee = Double.parseDouble(data);
                        }
                    } else {
                        if (event.asStartElement().getName().getLocalPart().equals("Name")) {
                            name = data;
                        } else if (event.asStartElement().getName().getLocalPart().equals("OperatorName")) {
                            operatorName = data;
                        } else if (event.asStartElement().getName().getLocalPart().equals("Payroll")) {
                            payroll = Double.parseDouble(data);
                        } else if (event.asStartElement().getName().getLocalPart().equals("SMSPrice")) {
                            smsPrice = Double.parseDouble(data);
                        }
                    }
                }
            } else if (event.isEndElement()) {
                if (event.asEndElement().getName().getLocalPart().equals("CallPrices")) {
                    isInsideCallPrices = false;
                } else if (event.asEndElement().getName().getLocalPart().equals("Parameters")) {
                    isInsideParameters = false;
                } else if (event.asEndElement().getName().getLocalPart().equals("Tariff")) {
                    CallPrices callPrices = new CallPrices(insideNetwork, outsideNetwork, landline);
                    Parameters parameters = new Parameters(favoriteNumbers, tariffication, connectionFee);
                    Tariff tariff = new Tariff(id, name, operatorName, payroll, callPrices, smsPrice, parameters);
                    tariffs.add(tariff);
                }
            }
        }

        return tariffs;
    }
}

