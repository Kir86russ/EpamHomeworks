package Homework23_Database.cargo.repo.impl;


import Homework23_Database.cargo.domain.Cargo;
import Homework23_Database.cargo.domain.CargoField;
import Homework23_Database.cargo.repo.CargoRepo;
import Homework23_Database.cargo.search.CargoSearchCondition;
import Homework23_Database.common.solutions.comparator.SimpleComparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static Homework23_Database.cargo.domain.CargoField.NAME;
import static Homework23_Database.cargo.domain.CargoField.WEIGHT;

public abstract class CommonCargoRepo implements CargoRepo {

  private static final List<CargoField> FIELDS_ORDER_TO_SORT_CARGOS = Arrays.asList(NAME, WEIGHT);

  private static final Comparator<Cargo> CARGO_NAME_COMPARATOR = (o1, o2) ->
      SimpleComparator.STRING_COMPARATOR.compare(o1.getName(), o2.getName());

  private static final Comparator<Cargo> CARGO_WEIGHT_COMPARATOR = Comparator
      .comparingInt(Cargo::getWeight);

  protected Comparator<Cargo> createCargoComparator(CargoSearchCondition searchCondition) {
    Comparator<Cargo> result = null;
    //NAME, WEIGHT
    for (CargoField cargoField : FIELDS_ORDER_TO_SORT_CARGOS) {
      if (searchCondition.shouldSortByField(cargoField)) {

        if (result == null) {
          result = getComparatorForCargoField(cargoField);
        } else {
          result = result.thenComparing(getComparatorForCargoField(cargoField));
        }
      }
    }

    return result;
  }


  private Comparator<Cargo> getComparatorForCargoField(CargoField cargoField) {
    switch (cargoField) {

      case NAME: {
        return CARGO_NAME_COMPARATOR;
      }
      case WEIGHT: {
        return CARGO_WEIGHT_COMPARATOR;
      }
      default: {
        throw new RuntimeException("Unknown cargo field " + cargoField);
      }
    }
  }


}
