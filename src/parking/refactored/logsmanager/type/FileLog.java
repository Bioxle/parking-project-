package parking.refactored.logsmanager.type;

import parking.refactored.logsmanager.ReceiptLog;

import java.io.FileWriter;
import java.io.IOException;

public class FileLog implements ReceiptLog {

    private final String filename;

    public FileLog(String filename) {
        this.filename = filename;
    }

    public void log(String line) throws IOException {
        try (FileWriter fw = new FileWriter(filename, true)) {   // append
            fw.write(line + System.lineSeparator());
        }
    }

}
