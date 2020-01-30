package Homework20_Stream_date_J8.reporting;

import Homework20_Stream_date_J8.common.business.exception.checked.ReportException;

public interface ReportService {
    void exportData() throws ReportException;
}
