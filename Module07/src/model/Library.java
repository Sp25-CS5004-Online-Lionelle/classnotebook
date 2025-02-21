package model;


import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import model.Formatter.InputReader;
import model.Formatter.Format;

public class Library implements BookModel {

    private final HashMap<String, BookRecord> books = new HashMap<String, BookRecord>();

    public Library(String database) {
        try {
            loadBooks(new FileInputStream(database), Format.XML);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadBooks(InputStream in, Format format) {
        books.putAll(
            InputReader.readBooks(in, format).stream().collect(Collectors.toMap(book -> book.id(), book -> book)));
    }

    @Override
    public Collection<BookRecord> getBooks() {
        return books.values();
    }

    @Override
    public BookRecord getBook(String id) {
        // BookRecord tmp = books.get(id);
        // if(tmp == null) {
        //     // grab from online the network id, add the book to the collection, save out the collection
        // }
        return books.get(id);
    }
    

    public static void main(String[] args) {
        //Library model = new Library("books_converted.csv");
        BookModel model = BookModel.getInstance();
        System.out.println(model.getBooks());
        System.out.println(model.getBook("the-lord-of-the-rings"));
    }
}
