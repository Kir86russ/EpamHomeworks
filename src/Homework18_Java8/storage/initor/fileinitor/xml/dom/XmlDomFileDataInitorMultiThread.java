package Homework18_Java8.storage.initor.fileinitor.xml.dom;


import Homework18_Java8.cargo.domain.Cargo;
import Homework18_Java8.carrier.domain.Carrier;
import Homework18_Java8.common.business.exception.checked.InitStorageException;
import Homework18_Java8.common.solutions.utils.xml.dom.XmlDomUtils;
import Homework18_Java8.transportation.domain.Transportation;
import org.w3c.dom.Document;

import java.io.File;
import java.util.List;
import java.util.Map;

public class XmlDomFileDataInitorMultiThread extends XmlDomFileDataInitor {

    private final static String FILE = "resources/Entities.xml";

    @Override
    public void initStorage() throws InitStorageException {
        File file = null;
        try {
            file = new File(FILE);
            Document document = XmlDomUtils.getDocument(file);
            Map<String, Cargo> cargoMap = parseCargos(document);
            Map<String, Carrier> carrierMap = parseCarriers(document);
            List<ParsedTransportation> transportations = parseTransportationsData(document);
            setReferencesBetweenEntities(cargoMap, carrierMap, transportations);
            List<Transportation> transportationList = getTransportationsFromParsedObject(transportations);

            Thread persistingCargoesThread = new Thread(() -> persistCargos(cargoMap.values()));
            Thread persistingCarriersThread = new Thread(() -> persistCarriers(carrierMap.values()));

            persistingCargoesThread.start();
            persistingCarriersThread.start();

            persistingCargoesThread.join();
            persistingCarriersThread.join();

            persistTransportations(transportationList);

        } catch (Exception e) {
            e.printStackTrace();
            throw new InitStorageException(e.getMessage());
        }
    }

    public static void main(String[] args) throws InitStorageException {
        XmlDomFileDataInitorMultiThread xmlDomFileDataInitorMultiThread = new XmlDomFileDataInitorMultiThread();
        xmlDomFileDataInitorMultiThread.initStorage();

    }
}
