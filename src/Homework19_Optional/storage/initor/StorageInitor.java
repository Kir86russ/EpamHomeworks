package Homework19_Optional.storage.initor;

import Homework19_Optional.common.business.exception.checked.InitStorageException;

public interface StorageInitor {
  void initStorage() throws InitStorageException;
}
