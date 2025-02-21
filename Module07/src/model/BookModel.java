package model;

import java.io.OutputStream;
import java.util.Collection;


import model.Formatter.DataFormatter;
import model.Formatter.Format;

public interface BookModel {
    

    Collection<BookRecord> getBooks();

    BookRecord getBook(String id);

    static BookModel getInstance() {
        return getInstance("books.xml");
    }

    static BookModel getInstance(String filename) {
        return  new Library(filename);
    }

    static void write(Collection<BookRecord> books, OutputStream out, Format format) {
        DataFormatter.write(books, out, format);
    }

}
