package Homework13_saxParser.storage.initor.parsers;

import Homework13_saxParser.cargo.domain.CargoType;
import Homework13_saxParser.cargo.domain.ClothersCargo;
import Homework13_saxParser.cargo.domain.FoodCargo;
import Homework13_saxParser.carrier.domain.Carrier;
import Homework13_saxParser.carrier.domain.CarrierType;
import Homework13_saxParser.storage.IdGenerator;
import Homework13_saxParser.storage.Storage;
import Homework13_saxParser.transportation.domain.Transportation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Parser {

    private static final int CARGO_AMOUNT_ARGUMENTS = 5;
    private static final int CARRIER_AMOUNT_ARGUMENTS = 3;
    private static final int TRANSPORTATION_AMOUNT_ARGUMENTS = 5;

    private static final String FILE_PATH = "C:\\Users\\Kir\\Desktop\\input_file.txt";

    private static String currentEntityForCreate;

    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.readFile(FILE_PATH);
        System.out.println(Storage.cargoCollection);
        System.out.println(Storage.carrierCollection);
        System.out.println(Storage.transportationCollection);
    }

    private void readFile(String filePath) {
        File file = new File(filePath);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                if (!checkBEGINString(line) && !checkENDString(line))
                    createEntity(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


    private void createEntity(String string) throws ParseException {
        String[] str_split = string.split("#");

        if (isNotEmptyValues(str_split)) {

            if (currentEntityForCreate.equals("CARGO")) createCargo(str_split);
            else if (currentEntityForCreate.equals("CARRIER")) createCarrier(str_split);
            else if (currentEntityForCreate.equals("TRANSPORTATION")) createTransportation(str_split);

        }
    }


    private void createCargo(String[] strings) throws ParseException {
        if (strings.length == CARGO_AMOUNT_ARGUMENTS) {

            if (strings[0].equals("FOOD"))
                createFoodCargoAndAddToStorage(strings);

            else if (strings[0].equals("CLOTHES"))
                createClothesCargoAndAddToStorage(strings);


        } else System.out.println("WRONG AMOUNT OF CARGO FOOD'S ARGUMENTS!");
    }

    private void createFoodCargoAndAddToStorage(String[] strings) throws ParseException {
        FoodCargo cargo = new FoodCargo();
        cargo.setId(IdGenerator.generateId());
        cargo.setCargoType(CargoType.FOOD);
        cargo.setName(strings[1]);
        cargo.setWeight(Integer.parseInt(strings[2]));
        cargo.setExpirationDate(new SimpleDateFormat("dd/MM/yyyy").parse(strings[3]));
        cargo.setStoreTemperature(Integer.parseInt(strings[4].trim()));
        Storage.cargoCollection.add(cargo);

    }

    private void createClothesCargoAndAddToStorage(String[] strings) throws ParseException {
        ClothersCargo cargo = new ClothersCargo();
        cargo.setId(IdGenerator.generateId());
        cargo.setCargoType(CargoType.CLOTHES);
        cargo.setName(strings[1]);
        cargo.setWeight(Integer.parseInt(strings[2]));
        cargo.setSize(strings[3]);
        cargo.setMaterial(strings[4]);
        Storage.cargoCollection.add(cargo);

    }


    private void createCarrier(String[] strings) throws ParseException {
        if (strings.length == CARRIER_AMOUNT_ARGUMENTS) {

            Carrier carrier = new Carrier();
            carrier.setId(IdGenerator.generateId());
            carrier.setName(strings[0]);
            carrier.setAddress(strings[1]);
            carrier.setCarrierType(getCarrierTypeFromString(strings[2].trim()));

            Storage.carrierCollection.add(carrier);

        } else System.out.println("WRONG AMOUNT OF CARGO FOOD'S ARGUMENTS!");
    }

    private void createTransportation(String[] strings) throws ParseException {
        if (strings.length == TRANSPORTATION_AMOUNT_ARGUMENTS) {

            Transportation transportation = new Transportation();
            transportation.setId(IdGenerator.generateId());
            transportation.setCargo(Storage.cargoCollection.get(Integer.parseInt(strings[0])));
            transportation.setCarrier(Storage.carrierCollection.get(Integer.parseInt(strings[1])));
            transportation.setDescription(strings[2]);
            transportation.setBillTo(strings[3]);
            transportation.setTransportationBeginDate(new SimpleDateFormat("dd/MM/yyyy").parse(strings[4]));

            Storage.transportationCollection.add(transportation);
        }
    }


    private CarrierType getCarrierTypeFromString(String string) {

        switch (string) {
            case "PLANE":
                return CarrierType.PLANE;


            case "CAR":
                return CarrierType.CAR;


            case "SHIP":
                return CarrierType.SHIP;

            case "TRAIN":
                return CarrierType.TRAIN;

            default:
                System.out.println("WRONG CARRIER TYPE");
                return null;

        }
    }


    private boolean checkBEGINString(String str) {

        if (str.contains("CARGO BEGIN")) {
            currentEntityForCreate = "CARGO";
            return true;
        } else if (str.contains("CARRIER BEGIN")) {
            currentEntityForCreate = "CARRIER";
            return true;
        } else if (str.contains("TRANSPORTATION BEGIN")) {
            currentEntityForCreate = "TRANSPORTATION";
            return true;
        } else return false;

    }

    private boolean checkENDString(String string) {
        if (string.contains("END")) {
            currentEntityForCreate = "";
            return true;
        } else return false;

    }


    private boolean isNotEmptyValues(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            if (strings[i] == null) {
                System.out.println("EMPTY VALUE! ERROR");
                return false;
            } else
                strings[i] = strings[i].trim();

        }
        return true;
    }


}
