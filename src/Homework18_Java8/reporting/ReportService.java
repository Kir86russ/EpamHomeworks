package Homework18_Java8.reporting;

import Homework18_Java8.common.business.exception.checked.ReportException;

public interface ReportService {
    void exportData() throws ReportException;
}
