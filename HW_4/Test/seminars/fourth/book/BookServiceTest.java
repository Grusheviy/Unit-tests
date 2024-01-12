package seminars.fourth.book;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seminars.fourth.book.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class BookServiceTest {
    static BookRepository bookRepositoryMock;
    static BookService bookService;

    //Создаем мокированные объекты
    @BeforeAll
    static void setUpMock(){
        bookRepositoryMock = mock(BookRepository.class);
        bookService = new BookService(bookRepositoryMock);
    }

    @Test
    void testFindBookById() {
        //Описываем поведение
        when(bookRepositoryMock.findById("1")).thenReturn(new Book("1", "Book1", "Author1"));

        //Вызываем проверяемые метод
        Book actualBook = bookService.findBookById("1");

        //Проверяем ответы и количество вызовов данного метода
        assertNotNull(actualBook);
        assertEquals("1", actualBook.getId());
        assertEquals("Book1", actualBook.getTitle());
        assertEquals("Author1",actualBook.getAuthor());
        verify(bookRepositoryMock, times(1)).findById("1");

    }

    @Test
    void testFindAll(){
        //Описывапем поведение
        List<Book> expectedBooks = Arrays.asList(
                new Book("1", "Book1", "Author1"),
                new Book("2", "Book2", "Author2")
        );
        when(bookRepositoryMock.findAll()).thenReturn(expectedBooks);

        //Вызываем метод
        List<Book> actualBooks = bookService.findAllBooks();

        //Проверяем что ответы соответствуют ожиданиям и кол-во вызовов данного метода
        assertNotNull(actualBooks);
        assertEquals(expectedBooks, actualBooks);
        verify(bookRepositoryMock, times(1)).findAll();
    }
}