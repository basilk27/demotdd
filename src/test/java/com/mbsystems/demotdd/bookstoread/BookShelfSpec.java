package com.mbsystems.demotdd.bookstoread;

import com.mbsystems.demotdd.exceptions.TTException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName( "<= BookShelf Specification =>" )
public class BookShelfSpec {

    @Test
    @DisplayName( "Is empty when no book is added to the shelf." )
    void shelEmptyWhenNoBooksAdded() {
        BookShelf shelf = new BookShelf();

        List<String> stringList = shelf.getBooks();

        assertThat( stringList ).isEmpty();
    }

    @DisplayName( "BookShelf contains two books when two books are are added" )
    @Test
    void bookoshel_contains_two_books_when_added() {
        BookShelf shelf = new BookShelf();

        shelf.addABook("Effective Java", "Code Complete");

        List<String> bookList = shelf.getBooks();

        assertEquals( 2, bookList.size(), () -> "BookShelf should have two books" );
    }

    @DisplayName( "BookShelf - call addABook should return empty " )
    @Test
    void call_add_a_book_without_content() {
        BookShelf shelf = new BookShelf();

        shelf.addABook();

        List<String> bookList = shelf.getBooks();

        assertEquals( 0, bookList.size(), () -> "BookShelf should have zero books" );
    }

    @DisplayName( "Test out that TTException is thrown when callTTe is invoked" )
    @Test
    void call_TTe_throws_TTException() {
        //given
        BookShelf shelf = new BookShelf();

        //when
        TTException throwsException = assertThrows( TTException.class, () -> shelf.callTTe() );

        //Then
        assertThat( throwsException.getMessage() ).isEqualTo( "TTException - this is due Basil" );
    }

    @Test
    void should_check_for_even_numbers() {
        int number = new Random().nextInt();

        assertTrue( () -> number % 2 == 0, number + "number is not even" );

        BiFunction<Integer, Integer, Boolean> divisible = (x, y) -> x % y == 0;
        Function<Integer, Boolean> multipleOf2 = x -> divisible.apply( x, 2 );
        Function<Integer, Boolean> multipleOf3 = x -> divisible.apply( x, 3 );
        Function<Integer, Boolean> multipleOf5 = x -> divisible.apply( x, 5 );

        assertTrue( () -> multipleOf2.apply( number ), () -> "2 is not a factor of " + number );

    }

    @Test
    void functionPower() {
        BiFunction<Integer, Integer, Boolean> divisible = (x, y) -> x % y == 0;
        Function<Integer, Boolean> multiple3 = x -> divisible.apply( x, 3 );
        Function<Integer, Boolean> multiple5 = x -> divisible.apply( x, 5 );

        //Predicate<Integer> multipleOf3and5 = multiple3.
    }

    @Test
    void composeFunctionTest() {
        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add      = (value) -> value + 3;

        Function<Integer, Integer> addThenMultiply = multiply.compose(add);

        Integer result1 = addThenMultiply.apply(3);
        System.out.println(result1);
    }
}
