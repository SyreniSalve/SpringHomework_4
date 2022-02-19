package com.example.SpringHomework_4.exercise10.mysolution.controller;


import com.example.SpringHomework_4.exercise10.mysolution.module.Book;
import com.example.SpringHomework_4.exercise10.mysolution.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;

    @GetMapping()
    public ResponseEntity<List<Book>> findAllBooks(){
        List<Book> bookList = booksService.findAllBooks();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<Book>> findBooksByTitle(@PathVariable("title") String title){
        List<Book> allBooksWithTheSameTitle = booksService.findAllByTitle(title);
        return new ResponseEntity<>(allBooksWithTheSameTitle, HttpStatus.OK);

    }

    @GetMapping("/after-isbn={isbn}")
    public ResponseEntity<List<Book>> findBookByIsbnIsAfter(@PathVariable("isbn") String isbn){
        List<Book> bookIsbnIsAfter = booksService.findBookByIsbnIsAfter(isbn);
        return new ResponseEntity<>(bookIsbnIsAfter, HttpStatus.OK);
    }

    @GetMapping("/author={author}/isbn={isbn}")
    public ResponseEntity<Book> findBookByAuthorAndIsbn(@PathVariable("author") String author,
                                                        @PathVariable ("isbn") String isbn){
        Book book = booksService.findBookByAuthorAndIsbn(author, isbn);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/minimum-pages={minimumPages}/maximum-pages={maximumPages}")
    public ResponseEntity<List<Book>> findBooksByPagesNumBetween(@PathVariable("minimumPages") Integer minimumPages,
                                                                 @PathVariable ("maximumPages") Integer maximumPages){
        List<Book> bookList = booksService.findBooksByPagesNumBetween(minimumPages, maximumPages);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/authors-three-books={author}")
    public ResponseEntity<List<Book>> findThreeBooksByAuthorOrderByPagesNumDesc(@PathVariable("author") String author){
        List<Book> bookList = booksService.findThreeBooksByAuthorOrderByPagesNumDesc(author);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/first-letter={firstLetter}")
    public ResponseEntity<List<Book>> findBooksByTitleIsStartingWith(@PathVariable("firstLetter") String firstLetter){
        List<Book> bookList = booksService.findBookByTitleIsStartingWith(firstLetter);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        Book newBook = booksService.addBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> findBookById(@PathVariable("id") Long id, @RequestBody Book book){
        booksService.updateBook(id, book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") Long id){
        booksService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
