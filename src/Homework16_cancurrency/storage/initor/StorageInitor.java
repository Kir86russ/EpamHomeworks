package Homework16_cancurrency.storage.initor;

import Homework16_cancurrency.common.business.exception.checked.InitStorageException;

public interface StorageInitor {
  void initStorage() throws InitStorageException;
}
