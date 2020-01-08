package Homework13_saxParser.storage.initor.parsers.saxParser.handlers;

import Homework13_saxParser.carrier.domain.Carrier;
import Homework13_saxParser.carrier.domain.CarrierType;
import Homework13_saxParser.storage.Storage;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CarrierHandler extends DefaultHandler {

    private StringBuilder stringBuilder = new StringBuilder();

    private Carrier curCarrier;
    private String id;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stringBuilder.setLength(0);

        if (qName.equals("carrier")) {
            id = attributes.getValue("id");
            curCarrier = new Carrier();
            curCarrier.setCarrierType(CarrierType.valueOf(attributes.getValue("type")));
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String data = stringBuilder.toString();

        if (curCarrier != null) {
            switch (qName) {
                case "name":
                    curCarrier.setName(data);
                    break;
                case "address":
                    curCarrier.setAddress(data);
                    break;
                case "carrier":
                    Storage.carrierMap.put(id, curCarrier);
                    break;
            }

        }

    }

    @Override
    public void characters(char[] chars, int start, int length) {
        String data = new String(chars, start, length);
        stringBuilder.append(data);
    }
}
