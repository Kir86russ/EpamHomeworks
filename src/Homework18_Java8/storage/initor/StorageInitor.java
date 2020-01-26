package Homework18_Java8.storage.initor;

import Homework18_Java8.common.business.exception.checked.InitStorageException;

public interface StorageInitor {
  void initStorage() throws InitStorageException;
}
