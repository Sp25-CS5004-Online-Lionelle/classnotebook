import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class ArgParser {


    private Format outputFormat;
    private String outputLocation;
    private String inputFile;
    private Format inputFormat;
    private String outputFile;

    public void parseArgs(String[] args) {
        Map<String, String> argMap = new HashMap<>();
        for (String arg : args) {
            if (arg.startsWith("-o") || arg.startsWith("--output")) {
                this.outputFile = arg.split(" ")[1];
            } else if (arg.startsWith("-i") || arg.startsWith("--input")) {
                this.inputFile = arg.split(" ")[1];
            }
        }
        this.outputFormat = determineFormat(argMap.getOrDefault("outputFormat", "PRETTY"));
        this.outputLocation = argMap.getOrDefault("outputLocation", "console");
        this.inputFile = argMap.getOrDefault("inputFile", this.inputFile != null ? this.inputFile : "books.csv");
        this.inputFormat = determineFormatFromFile(this.inputFile);
    }

    private Format determineFormat(String format) {
        try {
            return Format.valueOf(format.toUpperCase());
        } catch (IllegalArgumentException e) {
            return Format.UNKNOWN;
        }
    }

    private Format determineFormatFromFile(String fileName) {
        if (fileName.endsWith(".xml")) {
            return Format.XML;
        } else if (fileName.endsWith(".json")) {
            return Format.JSON;
        } else if (fileName.endsWith(".csv")) {
            return Format.CSV;
        } else if (fileName.endsWith(".txt")) {
            return Format.TEXT;
        } else {
            return Format.UNKNOWN;
        }
    }

    public Format getOutputFormat() {
        return outputFormat;
    }

    public OutputStream getOutputStream() {
        if ("console".equalsIgnoreCase(outputLocation)) {
            return System.out;
        } else {
            try {
                return new FileOutputStream(outputLocation);
            } catch (IOException e) {
                throw new IllegalArgumentException("Could not write to file: " + outputLocation, e);
            }

        }
    }

    public InputStream getInputStream() {
        try {
            return new FileInputStream(inputFile);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not open file: " + inputFile, e);
        }
    }

    public Format getInputFormat() {
        return inputFormat;
    }

    public String getOutputFile() {
        return outputFile;
    }
}
