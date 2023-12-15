package iterator;

public class BookContainerIterator implements Iterator {
    private BookContainer bookContainer;
    private int index;

    public BookContainerIterator(BookContainer bookContainer) {
        this.bookContainer = bookContainer;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if(index < bookContainer.getLength()){
            return  true;
        }
        return false;
    }

    @Override
    public Object next() {
        Book book = bookContainer.getBook(index);
        index++;
        return book;
    }
}
