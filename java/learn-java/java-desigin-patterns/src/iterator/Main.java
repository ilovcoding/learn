package iterator;

public class Main {
    public static void main(String[] args) {
        BookContainer bookContainer = new BookContainer(2);
        bookContainer.appendBook(new Book("西游记"));
        bookContainer.appendBook(new Book("石头记"));
        Iterator bookIt = bookContainer.iterator();
        while (bookIt.hasNext()){
            Book book = (Book) bookIt.next();
            System.out.println(book.getName());
        }
    }
}
