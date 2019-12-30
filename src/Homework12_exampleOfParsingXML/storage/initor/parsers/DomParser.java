package Homework12_exampleOfParsingXML.storage.initor.parsers;


import Homework12_exampleOfParsingXML.cargo.domain.Cargo;
import Homework12_exampleOfParsingXML.cargo.domain.CargoType;
import Homework12_exampleOfParsingXML.cargo.domain.ClothersCargo;
import Homework12_exampleOfParsingXML.cargo.domain.FoodCargo;
import Homework12_exampleOfParsingXML.carrier.domain.Carrier;
import Homework12_exampleOfParsingXML.carrier.domain.CarrierType;
import Homework12_exampleOfParsingXML.transportation.domain.Transportation;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class DomParser {
    private File file;

    public DomParser(File file) {
        this.file = file;
    }

    static class ElementOfNode<T> {
        String key;
        T t;

        ElementOfNode(String key, T t) {
            this.key = key;
            this.t = t;
        }
    }

    private Map<String, Cargo> cargoMap = new LinkedHashMap<>();
    private Map<String, Carrier> carrierMap = new LinkedHashMap<>();
    private Map<String, Transportation> transMap = new LinkedHashMap<>();

    private Document getDocumentFromFile() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        return builder.parse(file);
    }

    private void parseXML() throws Exception {
        Document doc = getDocumentFromFile();

        parseCargoes(doc);
        parseCarrier(doc);
        parseTransportation(doc);
        System.out.println(cargoMap);
        System.out.println(carrierMap);
        System.out.println(transMap);

    }

    private void parseCargoes(Document document) throws ParseException {
        NodeList cargoNodes = document.getElementsByTagName("cargo");
        for (int i = 0; i < cargoNodes.getLength(); i++) {
            if (cargoNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Node cargo = cargoNodes.item(i);
                ElementOfNode cargoElement = getElementFromNode(cargo);
                cargoMap.put(cargoElement.key, (Cargo) cargoElement.t);
            }
        }
    }

    private ElementOfNode getElementFromNode(Node node) throws ParseException {
        NamedNodeMap atributes = node.getAttributes();
        String id = atributes.getNamedItem("id").getNodeValue();
        ElementOfNode elementOfNode = null;


        switch (node.getNodeName()) {
            case "cargo":
                Cargo cargo;
                if (atributes.getNamedItem("type").getNodeValue().equals(String.valueOf(CargoType.FOOD))) {
                    FoodCargo foodCargo = new FoodCargo();
                    foodCargo.setStoreTemperature(Integer.parseInt(((Element) node).getElementsByTagName("temperature").item(0).getTextContent()));
                    foodCargo.setExpirationDate(new SimpleDateFormat("dd/MM/yyyy").parse(((Element) node).getElementsByTagName("expirationDate").item(0).getTextContent()));
                    cargo = foodCargo;
                } else if (atributes.getNamedItem("type").getNodeValue().equals(String.valueOf(CargoType.CLOTHES))) {
                    ClothersCargo clothersCargo = new ClothersCargo();
                    clothersCargo.setSize(((Element) node).getElementsByTagName("size").item(0).getTextContent());
                    clothersCargo.setMaterial(((Element) node).getElementsByTagName("material").item(0).getTextContent());
                    cargo = clothersCargo;
                } else throw new IllegalArgumentException("WRONG CARGO TYPE");

                cargo.setName(((Element) node).getElementsByTagName("name").item(0).getTextContent());
                cargo.setWeight(Integer.parseInt(((Element) node).getElementsByTagName("weight").item(0).getTextContent()));

                elementOfNode = new ElementOfNode(id, cargo);
                break;
            case "carrier":
                Carrier carrier = new Carrier();
                carrier.setName(((Element) node).getElementsByTagName("name").item(0).getTextContent());
                carrier.setAddress(((Element) node).getElementsByTagName("address").item(0).getTextContent());
                carrier.setCarrierType(CarrierType.valueOf(atributes.getNamedItem("type").getNodeValue()));

                elementOfNode = new ElementOfNode(id, carrier);
                break;
            case "transportation":
                Transportation transportation = new Transportation();

                transportation.setCargo(cargoMap.get(atributes.getNamedItem("cargo_id").getNodeValue()));
                transportation.setCarrier(carrierMap.get(atributes.getNamedItem("carrier_id").getNodeValue()));
                transportation.setDescription(((Element) node).getElementsByTagName("description").item(0).getTextContent());
                transportation.setBillTo(((Element) node).getElementsByTagName("billTo").item(0).getTextContent());
                transportation.setTransportationBeginDate(new SimpleDateFormat("dd/MM/yyyy").parse(((Element) node).getElementsByTagName("beginDate").item(0).getTextContent()));

                elementOfNode = new ElementOfNode(id, transportation);
                break;

            default:
                throw new IllegalArgumentException("WRONG ENTITY TYPE!");
        }

        return elementOfNode;
    }

    private void parseCarrier(Document document) throws ParseException {
        NodeList carrierNodes = document.getElementsByTagName("carrier");
        for (int i = 0; i < carrierNodes.getLength(); i++) {
            if (carrierNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Node carrier = carrierNodes.item(i);
                ElementOfNode carrierElement = getElementFromNode(carrier);
                carrierMap.put(carrierElement.key, (Carrier) carrierElement.t);
            }
        }
    }

    private void parseTransportation(Document document) throws ParseException {
        NodeList transportations = document.getElementsByTagName("transportation");
        for (int i = 0; i < transportations.getLength(); i++) {
            if (transportations.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Node tarnsportation = transportations.item(i);
                ElementOfNode transElement = getElementFromNode(tarnsportation);
                transMap.put(transElement.key, (Transportation) transElement.t);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        DomParser domParser = new DomParser(new File("resources/Entities.xml"));
        domParser.parseXML();
    }
}

