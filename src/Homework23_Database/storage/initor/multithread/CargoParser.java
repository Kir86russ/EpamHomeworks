package Homework23_Database.storage.initor.multithread;

import Homework23_Database.cargo.domain.Cargo;
import Homework23_Database.common.solutions.utils.FileUtils;
import Homework23_Database.common.solutions.utils.xml.sax.XmlSaxUtils;
import Homework23_Database.storage.initor.fileinitor.xml.sax.SaxHandler;
import Homework23_Database.storage.initor.fileinitor.xml.sax.XmlSaxFileDataInitor;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CargoParser implements Runnable {

  private static final String FILE = "/ru/epam/javacore/lesson_18_19_20_java_8/initdata/xmldata.xml";

  private volatile boolean hasError = false;

  private Map<String, Cargo> cargoMap;

  @Override
  public void run() {
    File file = null;
    try {
      file = getFileWithInitData();
      Map<String, Cargo> cargoMap = parseCargosFromFile(file);
      setCargoMap(cargoMap);
    } catch (Exception e) {
      e.printStackTrace();
      hasError = true;
    } finally {
      if (file != null) {
        file.delete();
      }
    }
  }

  private Map<String, Cargo> parseCargosFromFile(File file) throws Exception {
    SAXParser parser = XmlSaxUtils.getParser();
    SaxHandler saxHandler = new SaxHandler();
    parser.parse(file, saxHandler);
    return saxHandler.getCargoMap();
  }

  private File getFileWithInitData() throws IOException {
    return FileUtils
        .createFileFromResource(
            XmlSaxFileDataInitor.class, "init-data", "lesson", FILE);
  }

  public boolean isHasError() {
    return hasError;
  }

  private synchronized void setCargoMap(Map<String, Cargo> cargoMap) {
    this.cargoMap = cargoMap;
  }

  public synchronized Map<String, Cargo> getCargoMap() {
    return this.cargoMap;
  }
}
