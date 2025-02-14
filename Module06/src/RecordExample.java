public class RecordExample {

    public static void main(String[] args) {
        IBook.BookRecord bookRecord = new IBook.BookRecord("Java Programming", "John Doe", 2021, "Programming", 5, 500, 20);
        System.out.println(bookRecord);


        Book book = new Book(1, "Java Programming", "John Doe", "Programming", 2021, 500, 20, 5);

        book.setTitle("Java Programming V2");

        System.out.println(book);

        IBook.BookRecord bookRecord2 = book.toRecord();

        System.out.println(bookRecord2);

        System.out.println(bookRecord2.title());

    }
    
}
