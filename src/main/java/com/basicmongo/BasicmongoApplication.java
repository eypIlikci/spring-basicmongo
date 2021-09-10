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
	}
}
