package IteratorsAndComparators.Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Book implements Comparable<Book>, Comparator<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        if (authors.length > 0) {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(Book o) {
        return this.getTitle().compareTo(o.getTitle()) == 0 ?
                o.getYear() - this.getYear() :
                this.getTitle().compareTo(o.getTitle());
    }

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle()) == 0 ?
                o2.getYear() - o1.getYear() :
                o1.getTitle().compareTo(o2.getTitle());
    }
}
