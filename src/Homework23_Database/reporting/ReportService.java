package Homework23_Database.reporting;

import Homework23_Database.common.business.exception.checked.ReportException;

public interface ReportService {
    void exportData() throws ReportException;
}
