package Homework18_Java8.storage.initor.fileinitor.xml.sax;

import Homework18_Java8.cargo.domain.Cargo;
import Homework18_Java8.carrier.domain.Carrier;
import Homework18_Java8.common.business.exception.checked.InitStorageException;
import Homework18_Java8.common.solutions.utils.FileUtils;
import Homework18_Java8.common.solutions.utils.xml.sax.XmlSaxUtils;
import Homework18_Java8.storage.initor.fileinitor.BaseFileInitor;
import Homework18_Java8.transportation.domain.Transportation;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class XmlSaxFileDataInitor extends BaseFileInitor {

  private static final String FILE = "/ru/epam/javacore/lesson_16_concurrency/initdata/xmldata.xml";

  @Override
  public void initStorage() throws InitStorageException {
    File file = null;
    try {
      file = getFileWithInitData();
      SAXParser parser = XmlSaxUtils.getParser();
      SaxHandler saxHandler = new SaxHandler();
      parser.parse(file, saxHandler);
      Map<String, Cargo> cargoMap = saxHandler.getCargoMap();
      Map<String, Carrier> carrierMap = saxHandler.getCarrierMap();
      List<ParsedTransportation> transportations = saxHandler.getTransportations();
      setReferencesBetweenEntities(cargoMap, carrierMap, transportations);

      persistCargos(cargoMap.values());
      persistCarriers(carrierMap.values());
      List<Transportation> transportationList = getTransportationsFromParsedObject(transportations);
      persistTransportations(transportationList);
    } catch (Exception e) {
      e.printStackTrace();
      throw new InitStorageException(e.getMessage());
    } finally {
      if (file != null) {
        file.delete();
      }
    }
  }

  private File getFileWithInitData() throws IOException {
    return FileUtils
        .createFileFromResource(
            XmlSaxFileDataInitor.class, "init-data", "lesson12", FILE);
  }
}

