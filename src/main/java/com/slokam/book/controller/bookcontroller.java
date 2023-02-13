package com.slokam.book.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.book.Book;
import com.slokam.book.aspectlogging.Loggingaspect;
import com.slokam.book.repo.bookrep;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class bookcontroller {
	private final static Logger LOGGER=LoggerFactory.getLogger(bookcontroller.class);
	@Autowired
	private bookrep bookrep;

	@PostMapping("save")
	@Operation( description = "This is Save method",
	requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "Requires id, name, price, author"))
public ResponseEntity <Book> savebook(@RequestBody Book book) {
		//book.setPublishedate(new Date());
	bookrep.save(book);
	System.out.println(book);
	ResponseEntity<Book> re=new ResponseEntity(book,HttpStatus.OK);
	return re;
}
	@PostMapping("books")
	
	public ResponseEntity<List<Book>> saveall(@RequestBody List<Book> books){
		 bookrep.saveAll(books);
		 System.out.println(books);
		 ResponseEntity<List<Book>>re=new ResponseEntity<>(books,HttpStatus.OK);
		return re;
		
	}
	@GetMapping("getbyid/{id}")
	                     
	public ResponseEntity<Book> getbyid(@PathVariable(name="id")Integer id) throws NotFoundException{
		System.out.println("id::"+id);
		ResponseEntity<Book> re;
		Optional<Book> opt= bookrep.findById(id);

		if(opt.isPresent()) {
			 System.out.println("books="+opt.get());
		re=	 new ResponseEntity<>(opt.get(),HttpStatus.OK);
			 return re;
		}else {
			System.out.println("no book found");
			re=	 new ResponseEntity<>(opt.get(),HttpStatus.NOT_FOUND);
			return re;
			
		}
			
	}
	@GetMapping("getalldata")
	public ResponseEntity<List<Book>>getall(){
		 List<Book> all=	bookrep.findAll();
		
		 LOGGER.info("getall="+all);
		ResponseEntity<List<Book>> re=new ResponseEntity(all,HttpStatus.OK);
		 return re;
	}
	@DeleteMapping("dlete")
	public ResponseEntity<List<Book>> delete(@RequestBody Book book) {
		bookrep.delete(book);
		System.out.println(book);
		ResponseEntity<List<Book>> re=new ResponseEntity<>(HttpStatus.OK);
		return re;
	}
	@GetMapping("getbyname/{name}")
	public ResponseEntity<List<Book>>  getbyName(@PathVariable (name="name") String  name){
		 LOGGER.trace("getbyname");
		 LOGGER.debug("getbyname");
		 LOGGER.info("getbyname");
		 LOGGER.warn("getbyname");
		 LOGGER.error("getbyname");
		List<Book> al=bookrep.findByBname(name);
		ResponseEntity<List<Book>> re=new ResponseEntity<>(al,HttpStatus.OK);
		return re;
		
	}
	@GetMapping("getbynameandcost/{name}/{cost}")
	public ResponseEntity<List<Book>> getByNameandCost(@PathVariable (name="name") String  name ,@PathVariable (name="cost") Double cost){
		List<Book> al=bookrep.findByBnameAndBcost(name, cost);
		ResponseEntity<List<Book>> re=new ResponseEntity<>(al,HttpStatus.OK);
		return re;
	}
@GetMapping("likename/{partialname}")
public  ResponseEntity<List<Book>> getbylikename(@PathVariable (name="partialname") String name){
	List<Book> books=	bookrep.findByBnameLike("%"+name+"%");
	System.out.println(books);
	ResponseEntity<List<Book>> re=new ResponseEntity<>(books,HttpStatus.OK);
	return re;
	
}
@GetMapping("startwith/{partialname}")
public   ResponseEntity<List<Book>> startswith(@PathVariable (name="partialname") String name){
	List<Book> books=	bookrep.findByBnameStartingWith(name);
	System.out.println(books);
	
	ResponseEntity<List<Book>> re=new ResponseEntity<>(books,HttpStatus.OK);
	return re;
	
}

@GetMapping("findbycostbetween/{start}/{end}")
public  ResponseEntity<List<Book>> findbycostbetween(@PathVariable (name="start") Double cost,@PathVariable (name="end") Double cost1){
	List<Book> books=	bookrep.findByBcostBetween(cost, cost1);
	System.out.println(books);
	ResponseEntity<List<Book>> re=new ResponseEntity<>(books,HttpStatus.OK);
	return re;
	
}

@GetMapping("findcostlessthan/{start}")
public  ResponseEntity<List<Book>> findbycostlessthan(@PathVariable (name="start") Double cost){
	List<Book> books=	bookrep.findByBcostLessThan(cost);
	System.out.println(books);
	ResponseEntity<List<Book>> re=new ResponseEntity<>(books,HttpStatus.OK);
	return re;
	
}

@GetMapping("findbydate/{date}")
public  ResponseEntity<List<Book>> findbydate(@PathVariable (name="date") String date) throws Exception{
	SimpleDateFormat da=new SimpleDateFormat("yyyy-MM-dd");
	Date date1=da.parse(date);
	List<Book> books=	bookrep.findByPublishedate(date1);
	System.out.println(books);
	ResponseEntity<List<Book>> re=new ResponseEntity<>(books,HttpStatus.OK);
	return re;
	
}
@GetMapping("findbydatebybefore/{start}")
public  ResponseEntity<List<Book>>findbydatebefore(@PathVariable (name="start") String date) throws Exception{
	SimpleDateFormat da=new SimpleDateFormat("yyyy-MM-dd");
	Date d=da.parse(date);
	List<Book> books=	bookrep.findByPublishedateBefore(d);
	System.out.println(books);
	ResponseEntity<List<Book>> re=new ResponseEntity<>(books,HttpStatus.OK);
	return re;
	
}

@GetMapping("findbydateafter/{start}")
public ResponseEntity<List<Book>>findbydateafter(@PathVariable (name="start") String date) throws Exception{
	SimpleDateFormat da=new SimpleDateFormat("yyyy-MM-dd");
	Date d=da.parse(date);

	List<Book> books=	bookrep.findByPublishedateAfter(d);
	System.out.println(books);
	ResponseEntity<List<Book>> re=new ResponseEntity<>(books,HttpStatus.OK);
	return re;
	
}
@GetMapping("findbydatebetween/{start}/{end}")
public ResponseEntity<List<Book>> findbydateafter(@PathVariable (name="start") String date,@PathVariable (name="end") String date1) throws Exception{
	SimpleDateFormat da=new SimpleDateFormat("yyyy-MM-dd");
	Date d=da.parse(date);
	Date d1=da.parse(date1);
	List<Book> books=	bookrep.findByPublishedateBetween(d, d1);
	System.out.println(books);
	ResponseEntity<List<Book>> re=new ResponseEntity<>(books,HttpStatus.OK);
	return re;
	
}
	
}
