package Homework19_Optional.common.business.repo;

import Homework19_Optional.common.business.domain.BaseEntity;

public final class CommonRepoHelper {

  private CommonRepoHelper() {

  }

  public static Integer findEntityIndexInArrayStorageById(BaseEntity[] data, long entityId) {
    for (int i = 0; i < data.length; i++) {
      if (Long.valueOf(entityId).equals(data[i].getId())) {
        return i;
      }
    }

    return null;
  }
}
