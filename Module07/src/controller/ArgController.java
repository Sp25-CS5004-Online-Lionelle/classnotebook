package controller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import model.BookModel;
import model.Formatter.Format;

public class ArgController implements Controller {
    private static final String DEFAULT_OUTPUT_LOCATION = "console";
    private static final String DEFAULT_INPUT_FILE = "books.xml";
    private static final String OUTPUT_FLAG = "-o";
    private static final String OUTPUT_FLAG_LONG = "--output";
    private static final String INPUT_FLAG = "-i";
    private static final String INPUT_FLAG_LONG = "--input";
    private static final String ALL = "all";
    private static final String OUT_FORMAT_FLAG_LONG = "--outformat";
    private static final String OUT_FORMAT_FLAG = "-f";

    private String outputLocation = DEFAULT_OUTPUT_LOCATION;
    private Format outputFormat = null;
    private String inputFile = DEFAULT_INPUT_FILE;
    private BookModel model = null;
    private String filter = ALL;
   
    public void parseArgs(String[] args) {
        List<String> argList = new ArrayList<>(Arrays.asList(args));
        parseHelpFlag(argList);
        parseOutputFlag(argList);
        parseInputFlag(argList);
        parseOutformatFlag(argList);
        if (argList.size() > 0) {
            filter = argList.get(0); // last thing in the args list
        }
    }

    private String check_and_get_next(String flag, List<String> argList) {
        if (argList.indexOf(flag) + 1 >= argList.size() || 
            argList.get(argList.indexOf(flag) + 1).startsWith("-")) {
            throw new IllegalArgumentException("Invalid format");
        }
        return argList.get(argList.indexOf(flag) + 1);
    }
    
    private void parseOutformatFlag(List<String> argList) {
        if (argList.contains(OUT_FORMAT_FLAG)) {
            String format = check_and_get_next(OUT_FORMAT_FLAG, argList);
            outputFormat = Format.valueOf(format.toUpperCase());
            argList.remove(OUT_FORMAT_FLAG);
            argList.remove(format);
        } else if (argList.contains(OUT_FORMAT_FLAG_LONG)) {
            String format = check_and_get_next(OUT_FORMAT_FLAG_LONG, argList);
            outputFormat = Format.valueOf(format.toUpperCase());
            argList.remove(OUT_FORMAT_FLAG_LONG);
            argList.remove(format);
        }
    }

    private void parseHelpFlag(List<String> argList) {
        if (argList.contains("--help") || argList.contains("-h")) {
            System.out.println("Usage: java -jar FileConverter.jar [options] [filter]");
            System.out.println("Options:");
            System.out.println("  -i, --input <file>    Read from <file> instead of the default books.csv");
            System.out.println("  -o, --output <file>   Write to <file> instead of the console");
            System.out.println("  -f, --outformat <fmt> Write output in the given format (pretty, xml, json, csv, text)");
            System.out.println("  filter                Filter the output by the given key, if it exists");
            System.out.println("  --help                Print this help message");
            System.exit(0);
        }
    }

    private void parseOutputFlag(List<String> argList) {
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

    private void parseInputFlag(List<String> argList) {
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
        return outputFormat;
    }

    public OutputStream getOutputStream() {
        if (DEFAULT_OUTPUT_LOCATION.equalsIgnoreCase(outputLocation)) {
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

    public String getInputFile() {
        return inputFile;
    }

    @Override
    public void setModel(BookModel model) {
       this.model = model;
    }

    @Override
    public void run() {
        if (model == null) {
            throw new IllegalArgumentException("Model not set");
        }

        if (getOutputFormat() == null) {
            outputFormat = determineFormatFromFile(outputLocation);
        } 
        if (filter.equalsIgnoreCase(ALL)) {
            BookModel.write(model.getBooks(), getOutputStream(), outputFormat);
        } else {
            BookModel.write(List.of(model.getBook(filter)), getOutputStream(), outputFormat);
        }


        // model 
        // output file
        // output format
        // filter - maybe
    }

    // public Format getInputFormat() {
    //     return determineFormatFromFile(inputFile);
    // }



}
