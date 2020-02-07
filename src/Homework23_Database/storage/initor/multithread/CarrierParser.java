package Homework23_Database.storage.initor.multithread;

import Homework23_Database.carrier.domain.Carrier;
import Homework23_Database.common.solutions.utils.FileUtils;
import Homework23_Database.common.solutions.utils.xml.sax.XmlSaxUtils;
import Homework23_Database.storage.initor.fileinitor.xml.sax.SaxHandler;
import Homework23_Database.storage.initor.fileinitor.xml.sax.XmlSaxFileDataInitor;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CarrierParser implements Runnable{

  private static final String FILE = "/ru/epam/javacore/lesson_18_19_20_java_8/initdata/xmldata.xml";

  private volatile boolean hasError = false;

  private Map<String, Carrier> carrierMap;

  @Override
  public void run() {
    File file = null;
    try {
      file = getFileWithInitData();
      Map<String, Carrier> carrierMap = parseCarriersFromFile(file);
      setCarrierMap(carrierMap);
    } catch (Exception e) {
      e.printStackTrace();
      hasError = true;
    } finally {
      if (file != null) {
        file.delete();
      }
    }
  }

  private Map<String, Carrier> parseCarriersFromFile(File file) throws Exception {
    SAXParser parser = XmlSaxUtils.getParser();
    SaxHandler saxHandler = new SaxHandler();
    parser.parse(file, saxHandler);
    return saxHandler.getCarrierMap();
  }

  private File getFileWithInitData() throws IOException {
    return FileUtils
        .createFileFromResource(
            XmlSaxFileDataInitor.class, "init-data", "lesson", FILE);
  }

  public boolean isHasError() {
    return hasError;
  }

  private synchronized void setCarrierMap(Map<String, Carrier> carrierMap) {
    this.carrierMap = carrierMap;
  }

  public synchronized Map<String, Carrier> getCarrierMap() {
    return this.carrierMap;
  }
}
