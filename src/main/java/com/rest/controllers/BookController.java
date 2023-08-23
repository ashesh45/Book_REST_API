package com.rest.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.Book;
import com.rest.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	//get all books
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		return this.bookService.getAllBooks();
	}
	
	//get single book
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id)
	{
		return bookService.getBookById(id);
	}
	
	
	//add new book
	@PostMapping("/books")
    public Book addBook(@RequestBody Book book)
    
    {
    	Book b=this.bookService.addBook(book);
    	return b;
    }
	
	//delete book
	@DeleteMapping("/boooks/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId)
	{
		this .bookService.deleteBook(bookId);
	}
	
	
}
