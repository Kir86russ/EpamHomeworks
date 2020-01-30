package Homework20_Stream_date_J8.storage.initor;

import Homework20_Stream_date_J8.storage.initor.fileinitor.TextFileDataInitor;
import Homework20_Stream_date_J8.storage.initor.fileinitor.xml.dom.XmlDomFileDataInitor;
import Homework20_Stream_date_J8.storage.initor.fileinitor.xml.sax.XmlSaxFileDataInitor;
import Homework20_Stream_date_J8.storage.initor.multithread.MultiThreadStorageInitor;

public final class StorageInitorFactory {

  private StorageInitorFactory() {

  }

  public static StorageInitor getStorageInitor(InitStorageType initStorageType) {
    switch (initStorageType) {

      case MEMORY: {
        return new InMemoryStorageInitor();
      }
      case TEXT_FILE: {
        return new TextFileDataInitor();
      }
      case XML_DOM_FILE: {
        return new XmlDomFileDataInitor();
      }
      case XML_SAX_FILE: {
        return new XmlSaxFileDataInitor();
      }

      case MULTI_THREAD: {
        return new MultiThreadStorageInitor();
      }
      default: {
        throw new RuntimeException("Unknown storage init type " + initStorageType);
      }
    }
  }

}
