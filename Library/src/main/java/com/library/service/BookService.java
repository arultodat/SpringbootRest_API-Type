package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.entity.Book;
import com.library.repository.BookRepository;

@Service
@Transactional
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> listAll()
	{
		return bookRepository.findAll();
	}
	
	public Book save(Book book)
	{
		return bookRepository.save(book);
	}
	
	public Book get(Long id)
	{
		return bookRepository.findById(id).get();
	}
	
	public Book updateBook(Book book) {
		
			return bookRepository.save(book);
	}

	public void delete(Book book) {
		bookRepository.delete(book);
		
	}
	
	
	
}
