package parking.refactored.reportmanager;

import java.util.List;

public interface ReportFormatter {

    String format(List<String> receipts, double total);
}
