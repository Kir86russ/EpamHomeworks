package Homework23_Database.cargo.repo.impl;

import Homework23_Database.cargo.domain.Cargo;
import Homework23_Database.cargo.search.CargoSearchCondition;
import Homework23_Database.common.solutions.dbConnectors.PoolConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CargoDatabaseRepoImpl extends CommonCargoRepo {

    private Connection connection;

    public void insertCargo(Connection connection, List<String> list) throws SQLException {

        PreparedStatement p_statement;
        String sql = "insert into cargo values (?,?,?,?,?,?,?,?)";

        try {
            p_statement = connection.prepareStatement(sql);

            p_statement.setInt(1, Integer.parseInt(list.get(0)));
            p_statement.setString(2, list.get(1));
            p_statement.setInt(3, Integer.parseInt(list.get(2)));
            p_statement.setString(4, list.get(3));
            p_statement.setString(5, list.get(4));
            p_statement.setString(6, list.get(5));
            p_statement.setDate(7, Date.valueOf(list.get(6)));
            p_statement.setInt(8, Integer.parseInt(list.get(7)));

            p_statement.executeUpdate();
        } catch (IllegalArgumentException | SQLException ex) {
            ex.printStackTrace();
        }
    }


    void deleteCargoById(int id) throws SQLException {
        if (!isExistCargo(id)) {
            System.out.println("Such cargo is not exist!");
            return;
        }

        PoolConnector poolConnector = PoolConnector.getInstance();
        connection = poolConnector.getConnection();

        PreparedStatement p_statement;
        String sql = "delete from cargo where id = " + id;


        try {
            p_statement = connection.prepareStatement(sql);
            p_statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        poolConnector.disconnect();
    }


    private void updateCargoById(int id, List<String> list) throws SQLException {
        if (!isExistCargo(id)) {
            System.out.println("Such cargo is not exist");
            return;
        }

        PoolConnector poolConnector = PoolConnector.getInstance();
        connection = poolConnector.getConnection();

        PreparedStatement p_statement;
        String sql = "update cargo set id = ?, name = ?, weight = ?, entity_type = ?, clothers_size = ?, " +
                "clother_material = ?, food_expiration_date = ?, food_store_temperature = ? where id = " + id;

        try {
            p_statement = connection.prepareStatement(sql);

            p_statement.setInt(1, Integer.parseInt(list.get(0)));
            p_statement.setString(2, list.get(1));
            p_statement.setInt(3, Integer.parseInt(list.get(2)));
            p_statement.setString(4, list.get(3));
            p_statement.setString(5, list.get(4));
            p_statement.setString(6, list.get(5));
            p_statement.setDate(7, Date.valueOf(list.get(6)));
            p_statement.setInt(8, Integer.parseInt(list.get(7)));

            p_statement.executeUpdate();
        } catch (SQLException | IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        poolConnector.disconnect();
    }

    private List<String> selectById(int id) throws SQLException {
        if (!isExistCargo(id)) {
            System.out.println("Such cargo is not exist!");
            return null;
        }

        List<String> resultList = new ArrayList<>();

        PoolConnector poolConnector = PoolConnector.getInstance();
        connection = poolConnector.getConnection();

        PreparedStatement p_statement;
        String sql = "select * from cargo where id = " + id;

        try {
            p_statement = connection.prepareStatement(sql);
            ResultSet resultSet = p_statement.executeQuery();

            while (resultSet.next()) {
                String ID = String.valueOf(resultSet.getInt("id"));
                resultList.add("id = " + ID);
                String name = resultSet.getString("name");
                resultList.add("name = " + name);
                String weight = String.valueOf(resultSet.getInt("weight"));
                resultList.add("weight = " + weight);
                String type = resultSet.getString("entity_type");
                resultList.add("type = " + type);
                String size = resultSet.getString("clothers_size");
                resultList.add("size = " + size);
                String material = resultSet.getString("clother_material");
                resultList.add("material  = " + material);
                String date_expir = String.valueOf(resultSet.getDate("food_expiration_date"));
                resultList.add("food date = " + date_expir);
                String food_store_temperature = String.valueOf(resultSet.getInt("food_store_temperature"));
                resultList.add("temperature store = " + food_store_temperature);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultList;
    }

    private boolean isExistCargo(int id) throws SQLException {
        PoolConnector poolConnector = PoolConnector.getInstance();
        Connection connection = poolConnector.getConnection();
        String query = "select * from cargo where id  = " + id;
        PreparedStatement p_state = connection.prepareStatement(query);
        ResultSet res;

        try {
            res = p_state.executeQuery();
        } catch (SQLException e) {
            return false;
        }

        return res.next();

    }


    @Override
    public Optional<Cargo> getByIdFetchingTransportations(long id) {
        return Optional.empty();
    }

    @Override
    public Cargo[] findByName(String name) {
        return new Cargo[0];
    }

    @Override
    public List<Cargo> search(CargoSearchCondition cargoSearchCondition) {
        return null;
    }

    @Override
    public Optional<Cargo> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Cargo entity) {
    }

    @Override
    public boolean update(Cargo entity) {
        return false;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }

    @Override
    public List<Cargo> getAll() {
        return null;
    }

    @Override
    public int countAll() {
        return 0;
    }


    public static void main(String[] args) throws SQLException {
        List<String> list = Arrays.asList("2", "KIR", "44", "food", "832190kg", "cadsaotton", "2020-02-02", "12");


        //new CargoDatabaseRepoImpl().updateCargoById(2, list);
        System.out.println(new CargoDatabaseRepoImpl().selectById(2));
    }
}
