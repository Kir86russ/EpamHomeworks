package Homework12_exampleOfParsingXML.storage.initor.writer;

import Homework12_exampleOfParsingXML.cargo.domain.Cargo;
import Homework12_exampleOfParsingXML.cargo.domain.CargoType;
import Homework12_exampleOfParsingXML.cargo.domain.ClothersCargo;
import Homework12_exampleOfParsingXML.cargo.domain.FoodCargo;
import Homework12_exampleOfParsingXML.carrier.domain.Carrier;
import Homework12_exampleOfParsingXML.transportation.domain.Transportation;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class WriterIntoFile {


    private List<Cargo> cargoes = new ArrayList<>();
    private List<Carrier> carriers = new ArrayList<>();
    private List<Transportation> transportations = new ArrayList<>();


    public void printStorage() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(new File("resources/output_file.txt"))
        )) {
            List<String> cargoesString = fromCargoesToStringList(cargoes);
            List<String> carriersString = fromCarriersToStringList(carriers);
            List<String> transportationsString = fromTransportationsToStringList(transportations);
            writeIntoFile(cargoesString, carriersString, transportationsString, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeIntoFile(List<String> cargoesString, List<String> carriersString, List<String> transportationsString, PrintWriter writer) {
        writer.write("---CARGOES---" + "\n");
        for (String cargo : cargoesString) {
            writer.write(cargo + "\n");
        }
        writer.write("\n" + "---CARRIERS---" + "\n");
        for (String carrier : carriersString) {
            writer.write(carrier + "\n");
        }
        writer.write("\n" + "---TRANSPORTATIONS---" + "\n");
        for (String trans : transportationsString) {
            writer.write(trans + "\n");
        }
    }


    private List<String> fromCargoesToStringList(List<Cargo> cargos) {
        List<String> list = new ArrayList<>();
        for (Cargo cargo : cargos) {
            list.add(fromCargoToString(cargo));
        }
        return list;
    }

    private List<String> fromCarriersToStringList(List<Carrier> carriers) {
        List<String> list = new ArrayList<>();
        for (Carrier carrier : carriers) {
            list.add(fromCarrierToString(carrier));
        }
        return list;
    }


    private String fromCargoToString(Cargo cargo) {

        StringBuilder builder = new StringBuilder();

        builder.append(cargo.getId()).append("#");
        builder.append(cargo.getName()).append("#");
        builder.append(cargo.getWeight()).append("#");
        CargoType cargoType = cargo.getCargoType();
        builder.append(cargo.getCargoType()).append("#");

        switch (cargoType) {

            case FOOD:
                builder.append((((FoodCargo) cargo).getExpirationDate())).append("#");
                builder.append(((FoodCargo) cargo).getStoreTemperature());
                break;

            case CLOTHES:
                builder.append(((ClothersCargo) cargo).getSize()).append("#");
                builder.append(((ClothersCargo) cargo).getMaterial());
                break;

        }
        return builder.toString();
    }

    private String fromCarrierToString(Carrier carrier) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(carrier.getId()).append("#");
        stringBuilder.append(carrier.getName()).append("#");
        stringBuilder.append(carrier.getAddress()).append("#");
        stringBuilder.append(carrier.getCarrierType().name()).append("#");

        return stringBuilder.toString();
    }

    private String fromTransportationToString(Transportation transportation) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(transportation.getId()).append("#");
        stringBuilder.append(transportation.getCargo().getId()).append("#");
        stringBuilder.append(transportation.getCarrier().getId()).append("#");
        stringBuilder.append(transportation.getDescription()).append("#");
        stringBuilder.append(transportation.getBillTo()).append("#");
        stringBuilder.append(transportation.getTransportationBeginDate()).append("#");

        return stringBuilder.toString();
    }

    private List<String> fromTransportationsToStringList(List<Transportation> transportations) {
        List<String> list = new ArrayList<>();
        for (Transportation transportation : transportations) {
            list.add(fromTransportationToString(transportation));
        }
        return list;
    }

    public static void main(String[] args) {
        WriterIntoFile writerIntoFile = new WriterIntoFile();
        writerIntoFile.printStorage();
    }
}
