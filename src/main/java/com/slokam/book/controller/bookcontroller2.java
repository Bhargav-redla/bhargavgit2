package com.slokam.book.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.book.Author;
import com.slokam.book.Book;
import com.slokam.book.repo.bookrep;
@RestController
public class bookcontroller2 {
	@Autowired
	private bookrep bookrep;
	@GetMapping("getbyname2/{name}")
    public List<Book> getbyname(@PathVariable("name") String name){
	List<Book> book=bookrep.getbyname(name);
	System.out.println(book);
	return book;
}
	@GetMapping("getbynameandcost2/{name}/{cost}")
	public List<Book> getbynameandcost(@PathVariable("name") String name,@PathVariable ("cost") Double cost){
		List<Book> book=bookrep.getbynameandcost(name, cost);
		System.out.println(book);
		return book;
	}
	@GetMapping("getbynamelike2/{name}")
	public List<Book> getbynamelike(@PathVariable("name") String name){
	List<Book>	book=bookrep.getbynamelike("%"+name+"%");
	System.out.println(book);
		return book;
	}
	@GetMapping("getbybetweencost/{start}/{end}")
	public List<Book> getbycostbetween(@PathVariable ("start") Double cost,@PathVariable ("end") Double cost1){
		List<Book> book=bookrep.getbycostbetween(cost, cost1);
		System.out.println(book);
		return book;
		
	}
	@GetMapping("less than value/{start}")
	public List<Book> lessthancost(@PathVariable ("start") Double cost){
		List<Book> book=bookrep.lessthanorequalcost(cost);
		System.out.println(book);
		return book;	
	}
	@GetMapping("beforedate2/{date}")
	public List<Book> beforedate(@PathVariable("date") String sdate) throws ParseException{
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		Date d=s.parse(sdate);
		List<Book> books =bookrep.publisheddatebefor(d);
		System.out.println();
		return books;
		}
	@GetMapping("getanamebybybid/{id}")
	public Author getanamebybybid(@PathVariable Integer id) {
		System.out.println("id::"+id);
	Author atr=	bookrep.getanamebybookid(id);
	System.out.println(atr);
		return atr;
	}
		
		@GetMapping("getebooksbyaid/{id}")
		public List<Book> getbooksbyaid(@PathVariable(name="id")Integer id){
		System.out.println("id::"+id);
		List<Book> book=	bookrep.getbooksbyaid(id);
		System.out.println(book);
		return book;
		}
	

}

