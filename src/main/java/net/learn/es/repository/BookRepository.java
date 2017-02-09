package net.learn.es.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.learn.es.pojo.Book;

/**
 * Created by yemengying on 16/1/10.
 */
//public interface BookRepository extends CrudRepository<Book, String> {
public interface BookRepository extends  CrudRepository<Book, String> {

    List<Book> findByName(String name);

    List<Book> findByPrice(String price);

}
