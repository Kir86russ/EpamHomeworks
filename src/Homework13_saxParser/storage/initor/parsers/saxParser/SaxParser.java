package Homework13_saxParser.storage.initor.parsers.saxParser;

import Homework13_saxParser.storage.initor.parsers.saxParser.handlers.CargoHandler;
import Homework13_saxParser.storage.initor.parsers.saxParser.handlers.CarrierHandler;
import Homework13_saxParser.storage.initor.parsers.saxParser.handlers.TransportationHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParser {

    private final static String FILE = "resources/Entities.xml";

    private CargoHandler cargoHandler = new CargoHandler();
    private CarrierHandler carrierHandler = new CarrierHandler();
    private TransportationHandler transportationHandler = new TransportationHandler();


    private void runSaxParser() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        saxParser.parse(new File(FILE), cargoHandler);
        saxParser.parse(new File(FILE), carrierHandler);
        saxParser.parse(new File(FILE), transportationHandler);

    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        SaxParser saxParser = new SaxParser();
        saxParser.runSaxParser();
    }
}
