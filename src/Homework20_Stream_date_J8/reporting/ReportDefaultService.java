package Homework20_Stream_date_J8.reporting;

import Homework20_Stream_date_J8.cargo.domain.Cargo;
import Homework20_Stream_date_J8.cargo.service.CargoService;
import Homework20_Stream_date_J8.carrier.domain.Carrier;
import Homework20_Stream_date_J8.carrier.service.CarrierService;
import Homework20_Stream_date_J8.common.business.exception.checked.ReportException;
import Homework20_Stream_date_J8.transportation.domain.Transportation;
import Homework20_Stream_date_J8.transportation.service.TransportationService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Homework20_Stream_date_J8.common.solutions.utils.CollectionUtils.isNotEmpty;

public class ReportDefaultService implements ReportService {

  private final CargoService cargoService;
  private final CarrierService carrierService;
  private final TransportationService transportationService;

  public ReportDefaultService(
      CargoService cargoService,
      CarrierService carrierService,
      TransportationService transportationService) {
    this.cargoService = cargoService;
    this.carrierService = carrierService;
    this.transportationService = transportationService;
  }

  @Override
  public void exportData() throws ReportException {
    List<String> reportData = new ArrayList<>();
    reportData.addAll(getCargosReportData());
    reportData.addAll(getCarriersReportData());
    reportData.addAll(getTransportationsReportData());

    if (isNotEmpty(reportData)) {
      try {
        exportDataToFile(reportData);
      } catch (Exception e) {
        throw new ReportException(e.getMessage());
      }
    }
  }

  private void exportDataToFile(List<String> data) throws IOException {
    Path tempFile = null;
    try {
      tempFile = Files.createTempFile("report", "all-data");
      Files.write(tempFile, data);

      List<String> fileContent = Files.readAllLines(tempFile);
      System.out.println("File content");
      for (String line : fileContent) {
        System.out.println(line);
      }
    } finally {
      if (tempFile != null) {
        Files.delete(tempFile);
      }
    }
  }

  private List<String> getCargosReportData() {
    List<Cargo> cargos = cargoService.getAll();

    List<String> result = Collections.emptyList();
    if (isNotEmpty(cargos)) {
      result = new ArrayList<>();

      for (Cargo cargo : cargos) {
        if (cargo != null) {
          result.add(cargoAsString(cargo));
        }
      }
    }

    return result;
  }

  private String cargoAsString(Cargo cargo) {
    return "id:" + cargo.getId() + "| " + "Name:" + cargo.getName() + "| weight:" + cargo
        .getWeight() + "| type: " + cargo.getCargoType();
  }

  private List<String> getCarriersReportData() {
    List<Carrier> carriers = carrierService.getAll();

    List<String> result = Collections.emptyList();
    if (isNotEmpty(carriers)) {
      result = new ArrayList<>();

      for (Carrier carrier : carriers) {
        if (carrier != null) {
          result.add(carrierAsString(carrier));
        }
      }
    }

    return result;
  }


  private String carrierAsString(Carrier carrier) {
    return "id:" + carrier.getId() + " |name:" + carrier.getName() + "| address:" + carrier
        .getAddress();
  }


  private List<String> getTransportationsReportData() {
    List<Transportation> transportations = transportationService.getAll();

    List<String> result = Collections.emptyList();
    if (isNotEmpty(transportations)) {
      result = new ArrayList<>();

      for (Transportation transportation : transportations) {
        if (transportation != null) {
          result.add(transportationAsString(transportation));
        }
      }
    }

    return result;
  }

  private String transportationAsString(Transportation transportation) {
    return "id:" + transportation.getId() + "| description: " + transportation.getDescription()
        + "| cargoRef: " + transportation.getCargo().getId() + " carrierRef: " + transportation
        .getCarrier().getId();
  }


}
