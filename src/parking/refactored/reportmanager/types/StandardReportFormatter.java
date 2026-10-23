package parking.refactored.reportmanager.types;

import parking.refactored.reportmanager.ReportFormatter;

import java.util.List;

public class StandardReportFormatter implements ReportFormatter {
    @Override
    public String format(List<String> receipts, double total) {
        StringBuilder sb = new StringBuilder("=== Daily report ===\n");
        for (String receipt : receipts) {
            sb.append(receipt).append("\n");
        }
        sb.append("Total: ").append(total).append(" MAD");
        return sb.toString();
    }
}
