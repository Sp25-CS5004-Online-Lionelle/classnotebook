import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.LinkedList;

public class ArgParser {
    private static final String DEFAULT_OUTPUT_LOCATION = "console";
    private static final String DEFAULT_INPUT_FILE = "books.csv";
    private static final String OUTPUT_FLAG = "-o";
    private static final String OUTPUT_FLAG_LONG = "--output";
    private static final String INPUT_FLAG = "-i";
    private static final String INPUT_FLAG_LONG = "--input";
    private static final String FILTER = "all";

    private String outputLocation = DEFAULT_OUTPUT_LOCATION;
    private String inputFile = DEFAULT_INPUT_FILE;
    private String filter = FILTER;
   
    public void parseArgs(String[] args) {
        LinkedList<String> argList = new LinkedList<>(Arrays.asList(args));
        parseHelpFlag(argList);
        parseOutputFlag(argList);
        parseInputFlag(argList);
        if (argList.size() > 0) {
            filter = argList.get(0); // last thing in the args list
        }
    }

    private String check_and_get_next(String flag, LinkedList<String> argList) {
        if (argList.indexOf(flag) + 1 >= argList.size() || 
            argList.get(argList.indexOf(flag) + 1).startsWith("-")) {
            throw new IllegalArgumentException("Invalid format");
        }
        return argList.get(argList.indexOf(flag) + 1);
    }

    private void parseHelpFlag(LinkedList<String> argList) {
        if (argList.contains("--help") || argList.contains("-h")) {
            System.out.println("Usage: java -jar FileConverter.jar [options] [filter]");
            System.out.println("Options:");
            System.out.println("  -i, --input <file>    Read from <file> instead of the default books.csv");
            System.out.println("  -o, --output <file>   Write to <file> instead of the console");
            System.out.println("  filter                Filter the output by the given key, if it exists");
            System.out.println("  --help                Print this help message");
            System.exit(0);
        }
    }

    private void parseOutputFlag(LinkedList<String> argList) {
        if (argList.contains(OUTPUT_FLAG)) {
            outputLocation = check_and_get_next(OUTPUT_FLAG, argList);
            argList.remove(OUTPUT_FLAG);
            argList.remove(outputLocation);
        } else if (argList.contains(OUTPUT_FLAG_LONG)) {
            outputLocation = check_and_get_next(INPUT_FLAG, argList);
            argList.remove(OUTPUT_FLAG_LONG);
            argList.remove(outputLocation);
        }
    }

    private void parseInputFlag(LinkedList<String> argList) {
        if (argList.contains(INPUT_FLAG)) {
            inputFile = check_and_get_next(INPUT_FLAG, argList);
            argList.remove(INPUT_FLAG);
            argList.remove(inputFile);
        } else if (argList.contains(INPUT_FLAG_LONG)) {
            inputFile = check_and_get_next(INPUT_FLAG_LONG, argList);
            argList.remove(INPUT_FLAG_LONG);
            argList.remove(inputFile);
        }
    }

    private Format determineFormatFromFile(String fileName) {
        if (fileName == "console") {
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
        return determineFormatFromFile(outputLocation);
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



}
