package Homework23_Database.cargo.service;

import Homework23_Database.cargo.domain.Cargo;
import Homework23_Database.cargo.exception.unckecked.CargoDeleteConstraintViolationException;
import Homework23_Database.cargo.repo.CargoRepo;
import Homework23_Database.cargo.repo.impl.CargoDatabaseRepoImpl;
import Homework23_Database.cargo.search.CargoSearchCondition;
import Homework23_Database.common.solutions.dbConnectors.PoolConnector;
import Homework23_Database.transportation.domain.Transportation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CargoServiceImpl implements CargoService {

    private CargoRepo cargoRepo;
    private static CargoDatabaseRepoImpl cargoDatabaseRepo = new CargoDatabaseRepoImpl();

    public CargoServiceImpl(CargoRepo cargoRepo) {
        this.cargoRepo = cargoRepo;
    }


    private static void saveSeveralCargoes(int capacityCargoes) throws SQLException {


        // захардкодил я короче люто с вводом данных в этом месте (тупо ради примера пока что)
        // нам ведь просто нужно убедиться в валидности транзакции
        List<String> valuesCargo = Arrays.asList("15", "kir", "101", "entity1", "832190kg", "cadsaotton", "2020-02-02", "12");

        PoolConnector poolConnector = PoolConnector.getInstance();
        Connection connection = poolConnector.getConnection();
        connection.setAutoCommit(false);

        // Генерирую новоге карго с id = id + 1
        for (int i = 0; i < capacityCargoes; i++) {
            cargoDatabaseRepo.insertCargo(connection, valuesCargo);
            int id = Integer.parseInt(valuesCargo.get(1)) + 1;
            valuesCargo.set(1, String.valueOf(id));
        }

        connection.commit();
        poolConnector.disconnect();

    }


    @Override
    public Optional<Cargo> findById(Long id) {
        if (id != null) {
            return cargoRepo.findById(id);
        }
        return Optional.empty();
    }

    @Override
    public void save(Cargo entity) {
        ;
    }

    @Override
    public Optional<Cargo> getByIdFetchingTransportations(Long id) {
        if (id != null) {
            return cargoRepo.getByIdFetchingTransportations(id);
        }
        return Optional.empty();
    }

    @Override
    public List<Cargo> getAll() {
        return cargoRepo.getAll();
    }

    @Override
    public int countAll() {
        return this.cargoRepo.countAll();
    }

    @Override
    public List<Cargo> findByName(String name) {
        Cargo[] found = cargoRepo.findByName(name);
        return (found == null || found.length == 0) ? Collections.emptyList() : Arrays.asList(found);
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<Cargo> cargoOptional = this.getByIdFetchingTransportations(id);

        if (cargoOptional.isPresent()) {
            List<Transportation> transportations = cargoOptional.get().getTransportations();
            boolean hasTransportations = transportations != null && transportations.size() > 0;
            if (hasTransportations) {
                throw new CargoDeleteConstraintViolationException(id);
            }

            return cargoRepo.deleteById(id);
        } else {
            return false;
        }
    }

    @Override
    public void printAll() {
        List<Cargo> allCargos = cargoRepo.getAll();

        for (Cargo cargo : allCargos) {
            System.out.println(cargo);
        }
    }

    @Override
    public boolean update(Cargo cargo) {
        if (cargo != null) {
            return cargoRepo.update(cargo);
        }

        return false;
    }

    @Override
    public List<Cargo> search(CargoSearchCondition cargoSearchCondition) {
        return cargoRepo.search(cargoSearchCondition);
    }

  public static void main(String[] args) throws SQLException {
      saveSeveralCargoes(3);
  }
}
