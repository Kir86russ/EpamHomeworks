package Homework16_cancurrency.reporting;

import Homework16_cancurrency.common.business.exception.checked.ReportException;

public interface ReportService {
    void exportData() throws ReportException;
}
