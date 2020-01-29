package Homework19_Optional.cargo.repo.impl;


import Homework19_Optional.cargo.domain.Cargo;
import Homework19_Optional.cargo.search.CargoSearchCondition;
import Homework19_Optional.carrier.domain.Carrier;
import Homework19_Optional.common.solutions.utils.ArrayUtils;
import Homework19_Optional.common.solutions.utils.CollectionUtils;
import Homework19_Optional.storage.IdGenerator;

import java.util.*;

import static Homework19_Optional.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static Homework19_Optional.storage.Storage.cargoArray;
import static Homework19_Optional.storage.Storage.cargoIndex;

public class CargoArrayRepoImpl extends CommonCargoRepo {

  private static final Cargo[] EMPTY_CARGO_ARRAY = new Cargo[0];

  @Override
  public Cargo getByIdFetchingTransportations(long id) {
    return findById(id);
  }

  @Override
  public Cargo[] findByName(String name) {
    Cargo[] searchResultWithNullableElems = getByNameIncludingNullElements(name);
    if (searchResultWithNullableElems.length == 0) {
      return EMPTY_CARGO_ARRAY;
    } else {
      return excludeNullableElementsFromArray(searchResultWithNullableElems);
    }
  }

  private Cargo[] getByNameIncludingNullElements(String name) {
    Cargo[] result = new Cargo[cargoArray.length];

    int curIndex = 0;
    for (Cargo carrier : cargoArray) {
      if (carrier != null && Objects.equals(carrier.getName(), name)) {
        result[curIndex++] = carrier;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Object[] arr = {new Carrier(), null, null, new Carrier()};
    for (Object obj : arr) {
      Optional.ofNullable(obj).ifPresent(System.out::println);
    }
  }

  /**
   * [A,B,C, null, null] [A,B,C, null, null, null, D] [A,B,C]
   *
   * new String[3]
   */

  private Cargo[] excludeNullableElementsFromArray(Cargo[] cargos) {
    int sizeOfArrWithNotNullElems = 0;

    for (Cargo cargo : cargos) {
      if (cargo != null) {
        sizeOfArrWithNotNullElems++;
      }
    }

    if (sizeOfArrWithNotNullElems == 0) {
      return EMPTY_CARGO_ARRAY;
    } else {
      Cargo[] result = new Cargo[sizeOfArrWithNotNullElems];
      int index = 0;
      for (Cargo cargo : cargos) {
        if (cargo != null) {
          result[index++] = cargo;
        }
      }

      return result;
    }
  }

  @Override
  public List<Cargo> search(CargoSearchCondition searchCondition) {
    List<Cargo> cargos = getAll();

    if (CollectionUtils.isNotEmpty(cargos)) {
      if (searchCondition.needSorting()) {
        Comparator<Cargo> cargoComparator = createCargoComparator(searchCondition);
        cargos.sort(searchCondition.isAscOrdering() ? cargoComparator : cargoComparator.reversed());
      }
    }

    return cargos;
  }

  @Override
  public Cargo findById(Long id) {
    for (Cargo cargo : cargoArray) {
      if (cargo != null && id != null && id.equals(cargo.getId())) {
        return cargo;
      }
    }

    return null;
  }

  @Override
  public void save(Cargo cargo) {
    if (cargoIndex == cargoArray.length) {
      Cargo[] newCargos = new Cargo[cargoArray.length * 2];
      ArrayUtils.copyArray(cargoArray, newCargos);
      cargoArray = newCargos;
    }

    cargo.setId(IdGenerator.generateId());
    cargoArray[cargoIndex] = cargo;
    cargoIndex++;
  }

  @Override
  public boolean update(Cargo entity) {
    return true;
  }

  @Override
  public boolean deleteById(Long id) {
    Integer indexToDelete = findEntityIndexInArrayStorageById(cargoArray, id);

    if (indexToDelete == null) {
      return false;
    } else {
      ArrayUtils.removeElement(cargoArray, indexToDelete);
      return true;
    }
  }

  @Override
  public List<Cargo> getAll() {
    Cargo[] cargos = excludeNullableElementsFromArray(cargoArray);
    return cargos.length == 0 ? Collections.emptyList() : Arrays.asList(cargoArray);
  }

  @Override
  public int countAll() {
    return getAll().size();
  }
}
