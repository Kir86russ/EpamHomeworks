package Homework13_saxParser.storage.initor.parsers.saxParser.handlers;

import Homework13_saxParser.storage.Storage;
import Homework13_saxParser.transportation.domain.Transportation;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TransportationHandler extends DefaultHandler {

    private StringBuilder stringBuilder = new StringBuilder();

    private Transportation curTransportation;
    private String id;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stringBuilder.setLength(0);
        if (qName.equals("transportation")) {
                curTransportation = new Transportation();
                id = attributes.getValue("id");
                curTransportation.setCargo(Storage.cargoMap.get(attributes.getValue("cargo_id")));
                curTransportation.setCarrier(Storage.carrierMap.get(attributes.getValue("carrier_id")));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String data = stringBuilder.toString();
        if (curTransportation != null) {
            switch (qName) {
                case "description":
                    curTransportation.setDescription(data);
                    break;
                case "billTo":
                    curTransportation.setBillTo(data);
                    break;
                case "beginDate":
                    try {
                        curTransportation.setTransportationBeginDate(new SimpleDateFormat("dd/MM/yyyy").parse(data));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "transportation":
                    Storage.transportationMap.put(id, curTransportation);
                    break;
            }
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        String data = new String(chars, start, length);
        stringBuilder.append(data);
    }
}
