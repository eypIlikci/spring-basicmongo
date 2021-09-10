package com.basicmongo.domain.model.convert;

import com.basicmongo.domain.Author;
import com.basicmongo.domain.Book;
import com.basicmongo.domain.Magazine;
import com.basicmongo.domain.Publisher;
import com.basicmongo.domain.model.request.BookCreateRequest;
import com.basicmongo.domain.model.request.BookUpdateRequest;
import com.basicmongo.domain.model.request.MagazineCreateRequest;
import com.basicmongo.domain.model.request.MagazineUpdateRequest;
import com.basicmongo.domain.model.response.BookResponse;
import com.basicmongo.domain.model.response.MagazineResponse;
import org.springframework.stereotype.Component;

@Component
public class Convertor {
    public Magazine convert(MagazineCreateRequest request){
       return Magazine.builder()
                .name(request.getName())
                .price(request.getPrice())
                .createDate(request.getCreateDate())
                .author(createAuthor(request.getAuthorId()))
                .publisher(createPublisher(request.getPublisherId()))
                .build();
    }
    public Magazine convert(MagazineUpdateRequest request){
        return Magazine.builder()
                .id(request.getId())
                .name(request.getName())
                .price(request.getPrice())
                .createDate(request.getCreateDate())
                .author(createAuthor(request.getAuthorId()))
                .publisher(createPublisher(request.getPublisherId()))
                .build();
    }
    public MagazineResponse convert(Magazine magazine){
        return MagazineResponse.builder()
                .name(magazine.getName())
                .price(magazine.getPrice())
                .createDate(magazine.getCreateDate())
                .authorId(magazine.getAuthor()!=null ?magazine.getAuthor().getId():null)
                .publisherId(magazine.getPublisher()!=null ?magazine.getPublisher().getId():null)
                .build();
    }
    public Book convert(BookCreateRequest request){
        return Book.builder()
                .name(request.getName())
                .price(request.getPrice())
                .createDate(request.getCreateDate())
                .author(createAuthor(request.getAuthorId()))
                .publisher(createPublisher(request.getPublisherId()))
                .build();
    }
    public Book convert(BookUpdateRequest request){
        return Book.builder()
                .id(request.getId())
                .name(request.getName())
                .price(request.getPrice())
                .createDate(request.getCreateDate())
                .author(createAuthor(request.getAuthorId()))
                .publisher(createPublisher(request.getPublisherId()))
                .build();
    }
    public BookResponse convert(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .price(book.getPrice())
                .createDate(book.getCreateDate())
                .authorId(book.getAuthor()!=null ?book.getAuthor().getId():null)
                .publisherId(book.getPublisher()!=null ?book.getPublisher().getId():null)
                .build();
    }

    private Author createAuthor(String id){
        return Author.builder().id(id).build();
    }
    private Publisher createPublisher(String id){
        return Publisher.builder().id(id).build();
    }
}
