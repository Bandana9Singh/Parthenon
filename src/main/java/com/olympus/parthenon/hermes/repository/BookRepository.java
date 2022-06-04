package com.olympus.parthenon.hermes.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.olympus.parthenon.hermes.beans.Book;

public interface BookRepository  extends MongoRepository<Book, String> {
	
	@Query("{name: '?0'}")
	Book findBookByName(String name);
	
	@Query(value="{genre: '?0'}", fields="'name': 1, 'quantity': 1")
	List<Book> findAll(String genre);
	
	public long count();
}
