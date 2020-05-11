package com.mbsystems.demotdd.bookstoread;

import com.mbsystems.demotdd.exceptions.TTException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookShelf {

    private final List<String> bookList = new ArrayList<>();

    public List<String> getBooks() {
        return this.bookList;
    }

    public void addABook( String... name ) {
        bookList.addAll( Arrays.asList( name ) );
    }

    public void callTTe() {
        throw  new TTException( "TTException - this is due Basil" );
    }
}
