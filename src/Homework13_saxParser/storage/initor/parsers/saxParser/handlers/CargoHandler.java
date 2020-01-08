package Homework13_saxParser.storage.initor.parsers.saxParser.handlers;

import Homework13_saxParser.cargo.domain.Cargo;
import Homework13_saxParser.cargo.domain.ClothersCargo;
import Homework13_saxParser.cargo.domain.FoodCargo;
import Homework13_saxParser.storage.Storage;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CargoHandler extends DefaultHandler {

    private StringBuilder stringBuilder = new StringBuilder();

    private Cargo curCargo;
    private String id;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stringBuilder.setLength(0);
        if (qName.equals("cargo")) {
            id = attributes.getValue("id");
            String cargoType = attributes.getValue("type");
            switch (cargoType) {
                case "FOOD":
                    curCargo = new FoodCargo();
                    break;
                case "CLOTHES":
                    curCargo = new ClothersCargo();
                    break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String data = stringBuilder.toString();

        if (curCargo != null) {
            if (curCargo.getCargoType().equals("FOOD")) {
                FoodCargo foodCargo = new FoodCargo();

                switch (qName) {
                    case "expirationDate":

                        try {
                            foodCargo.setExpirationDate(new SimpleDateFormat("dd/MM/yyyy").parse(data));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;

                    case "temperature":
                        foodCargo.setStoreTemperature(Integer.parseInt(data));
                        break;
                }

                curCargo = foodCargo;

            } else if (curCargo.getCargoType().equals("CLOTHES")) {
                ClothersCargo clothesCargo = new ClothersCargo();

                switch (qName) {
                    case "size":
                        clothesCargo.setSize(data);
                        break;
                    case "material":
                        clothesCargo.setMaterial(data);
                        break;
                }
                curCargo = clothesCargo;
            }

            switch (qName) {
                case "name":
                    curCargo.setName(data);
                    break;
                case "weight":
                    curCargo.setWeight(Integer.parseInt(data));
                    break;
                case "cargo":
                    Storage.cargoMap.put(id, curCargo);
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
