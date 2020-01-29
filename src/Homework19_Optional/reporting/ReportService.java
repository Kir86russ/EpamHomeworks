package Homework19_Optional.reporting;

import Homework19_Optional.common.business.exception.checked.ReportException;

public interface ReportService {
    void exportData() throws ReportException;
}
