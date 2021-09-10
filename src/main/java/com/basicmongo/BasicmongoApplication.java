package com.basicmongo;

import com.basicmongo.domain.Book;
import com.basicmongo.domain.model.search.Search;
import com.basicmongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication//(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableMongoRepositories
public class BasicmongoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BasicmongoApplication.class, args);
	}
	@Autowired
	private BookRepository bookRepository;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("-----------------");
		Book book1=new Book();
		book1.setId("A");
		book1.setName("A");
		bookRepository.save(book1);
		Book book2=new Book();
		book2.setName("B");
		book2.setName("B");
		bookRepository.save(book2);
		Search search=new Search();
		search.setName("A");
		search.setId("A");
		bookRepository.search(search).stream().forEach(book -> System.out.println(book.getName()));
	}
}
