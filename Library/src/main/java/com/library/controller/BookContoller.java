package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Book;
import com.library.service.BookService;

@RestController
public class BookContoller {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book")	
	public List<Book> getAllBooks() {
		return bookService.listAll();		
	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable(value = "id") Long bid) {
		return bookService.get(bid);
	}
	
	@PostMapping("/book")
	public Book addBook(@Validated @RequestBody Book book) {
		return bookService.save(book);
		
	}
	
	  @PutMapping("/book/{id}") 
	  public Book updateBook(@PathVariable(value = "id")Book bid,@RequestBody Book book) {
	  Book books =  bookService.updateBook(bid);				 //Book books =  bookService.save(bid);
	  books.setBookname(book.getBookname());
	  books.setAuthors(book.getAuthors());
	  books.setPublishdate(book.getPublishdate());
	  books.setPrice(book.getPrice());
	  Book updateBook = bookService.updateBook(bid);			 //Book updateBook = bookService.save(books);
	  return updateBook;  
	  }	  
	  
	  @DeleteMapping("/book/{id}") 
	  public void  deleteBooks(@PathVariable(value = "id") Long bid) {		
		bookService.delete(bookService.get(bid));	
	  
	  }
	  
	 }
