package com.ip.wePro.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/books/all", method = RequestMethod.GET)
    List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    Book getAllBooks(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @RequestMapping(value = "/books/update", method = RequestMethod.PUT)
    void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }

    @RequestMapping(value = "/books/delete/{id}", method = RequestMethod.DELETE)
    void updateBook(@PathVariable int id){
        bookService.deleteBook(id);
    }
}
