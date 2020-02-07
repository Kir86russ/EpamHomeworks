package Homework23_Database.transportation.repo.impl;


import Homework23_Database.common.solutions.utils.ArrayUtils;
import Homework23_Database.storage.IdGenerator;
import Homework23_Database.transportation.domain.Transportation;
import Homework23_Database.transportation.repo.TransportationRepo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static Homework23_Database.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static Homework23_Database.storage.Storage.transportationArray;
import static Homework23_Database.storage.Storage.transportationIndex;

public class TransportationArrayRepoImpl implements TransportationRepo {

  private static final Transportation[] EMPTY_TRANSPORTATION_ARRAY = new Transportation[0];

  @Override
  public void save(Transportation transportation) {
    if (transportationIndex == transportationArray.length) {
      Transportation[] newTransportations =
          new Transportation[transportationArray.length * 2];
      ArrayUtils.copyArray(transportationArray, newTransportations);
      transportationArray = newTransportations;
    }

    transportation.setId(IdGenerator.generateId());
    transportationArray[transportationIndex] = transportation;
    transportationIndex++;
  }

  @Override
  public Optional<Transportation> findById(Long id) {
    for (Transportation transportation : transportationArray) {
      if (transportation != null && transportation.getId().equals(id)) {
        return Optional.of(transportation);
      }
    }

    return Optional.empty();
  }

  @Override
  public List<Transportation> getAll() {
    Transportation[] transportations = excludeNullableElementsFromArray(transportationArray);
    return transportations.length == 0 ? Collections.emptyList()
        : Arrays.asList(transportationArray);
  }

  @Override
  public int countAll() {
    return getAll().size();
  }

  private Transportation[] excludeNullableElementsFromArray(Transportation[] transportations) {
    int sizeOfArrWithNotNullElems = 0;

    for (Transportation transportation : transportations) {
      if (transportation != null) {
        sizeOfArrWithNotNullElems++;
      }
    }

    if (sizeOfArrWithNotNullElems == 0) {
      return EMPTY_TRANSPORTATION_ARRAY;
    } else {
      Transportation[] result = new Transportation[sizeOfArrWithNotNullElems];
      int index = 0;
      for (Transportation transportation : transportations) {
        if (transportation != null) {
          result[index++] = transportation;
        }
      }

      return result;
    }
  }


  @Override
  public boolean update(Transportation transportation) {
    return true;
  }

  @Override
  public boolean deleteById(Long id) {
    Integer indexToDelete = findEntityIndexInArrayStorageById(transportationArray, id).orElse(null);

    if (indexToDelete == null) {
      return false;
    } else {
      ArrayUtils.removeElement(transportationArray, indexToDelete);
      return true;
    }
  }
}
