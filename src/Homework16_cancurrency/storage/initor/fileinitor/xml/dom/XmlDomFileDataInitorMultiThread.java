package Homework16_cancurrency.storage.initor.fileinitor.xml.dom;


import Homework16_cancurrency.cargo.domain.Cargo;
import Homework16_cancurrency.carrier.domain.Carrier;
import Homework16_cancurrency.common.business.exception.checked.InitStorageException;
import Homework16_cancurrency.common.solutions.utils.xml.dom.XmlDomUtils;
import Homework16_cancurrency.storage.initor.fileinitor.BaseFileInitor;
import Homework16_cancurrency.transportation.domain.Transportation;
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
            List<BaseFileInitor.ParsedTransportation> transportations = parseTransportationsData(document);
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

}
