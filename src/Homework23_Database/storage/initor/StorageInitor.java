package Homework23_Database.storage.initor;

import Homework23_Database.common.business.exception.checked.InitStorageException;

public interface StorageInitor {
  void initStorage() throws InitStorageException;
}
