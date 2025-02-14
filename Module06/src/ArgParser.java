import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class ArgParser {


    private Format outputFormat;
    private String outputLocation = "console";
    private String inputFile = "books.csv";
   
    public void parseArgs(String[] args) {
        for(int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.startsWith("-o") || arg.startsWith("--output")) {
                if(i+1 < args.length && args[i + 1] != null && !args[i+1].startsWith("-")) {
                    this.outputLocation = args[i + 1];
                    
                    i++;
                }
            }else if (arg.startsWith("-i") || arg.startsWith("--input")) {
                this.inputFile = args[i+1];
                i++;
            }
        }
        this.outputFormat = determineFormatFromFile(this.outputLocation);
   
    }


    private Format determineFormatFromFile(String fileName) {
        if (fileName == null) {
            return Format.PRETTY;
        } 
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
        return determineFormatFromFile(inputFile);
    }

    public Format getOuFormat() {
        return determineFormatFromFile(outputLocation);
    }


}
