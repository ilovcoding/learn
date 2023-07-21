package iterator;

public class BookContainer implements Aggregate {
    private Book[]  books;
    private int last = 0;
    public BookContainer(int maxsize){
        this.books = new Book[maxsize];
    }
    public Book getBook(int index){
        return books[index];
    }
    public void appendBook(Book book){
        this.books[last] = book;
        last++;
    }
    public int getLength(){
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookContainerIterator(this);
    }
}
