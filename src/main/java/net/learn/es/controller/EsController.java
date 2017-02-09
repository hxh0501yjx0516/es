package net.learn.es.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.elasticsearch.client.transport.TransportClient;

import net.learn.es.pojo.Book;
import net.learn.es.repository.BookRepository;

/**
 * Created by yemengying on 16/1/10.
 */
@Controller
@RequestMapping("/es")
public class EsController {

    Logger logger = LoggerFactory.getLogger(EsController.class);

    @Autowired
    private BookRepository bookRepository;

    /**
     * 根据名字获取书
     *
     * @return
     */
    @RequestMapping(value = "/book", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Book> getBookByName( @RequestParam(required=false)String name) {
        logger.info("根据名字:{}查找书", name);
        return bookRepository.findByName(name);
    }




    /**
     * 根据价格获取书
     *
     * @return
     */
    @RequestMapping(value = "/book/search_price", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Book> getBookByPrice( String price) {
        logger.info("根据价格:{}查找书", price);
        return bookRepository.findByPrice(price);
    }



    /**
     * 新增书
     *
     * @return
     */
    @RequestMapping(value = "/book", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Book indexBook(@RequestBody  Book book) {
        return bookRepository.save(book);
    }



}
