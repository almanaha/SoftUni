package IteratorsAndComparators.Library;

import java.util.Iterator;

public class Library implements Iterable<Book>{

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        //inner class
        return new LibIterator();
    }

    private class LibIterator implements Iterator<Book> {
        private int counter;
        LibIterator() {
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
           return counter < books.length;
        }

        @Override
        public Book next() {
            return books[this.counter++];
        }
    }
}
