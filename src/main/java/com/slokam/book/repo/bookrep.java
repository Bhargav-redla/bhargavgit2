package com.slokam.book.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slokam.book.Author;
import com.slokam.book.Book;
@Repository
public interface bookrep extends JpaRepository<Book, Integer> {
	@Query("select b.author from Book b where b.bid=?1")
	public Author getanamebybookid(Integer id);
	
	@Query("select b from  Book b join b.author a where a.id=?1")
	public List<Book> getbooksbyaid(Integer id);
	
	
	//-----------------------------------------------------------
	@Query("from Book  b where b.bname=?1")
	public List<Book> getbyname(String name);
	public abstract List<Book>  findByBname(String name);
	
	@Query("from Book b where b.bname=?1 and b.bcost=?2")
	public List<Book> getbynameandcost(String name,Double cost);
	public abstract List<Book>  findByBnameAndBcost(String name,Double cost);
	
	@Query("from Book b where b.bname like ?1")
	public List<Book> getbynamelike(String name);
	public abstract List<Book> findByBnameLike(String name);
	
	@Query("from Book b where b.bname like ?1")
	public List<Book> getbynamestaringwith(String name);
    public abstract List<Book> findByBnameStartingWith(String name);
    
    @Query("from Book b where b.bcost between ?1 and ?2 ")
    public List<Book> getbycostbetween(Double star ,Double end);
	public abstract List<Book> findByBcostBetween(Double star,Double end);
	
	@Query("from Book b where b.bcost <=?1")
	public List<Book> lessthanorequalcost(Double cost);
    public abstract List<Book> findByBcostLessThan(Double cost);
    
   
    public abstract List<Book> findByPublishedate(Date date);
    
    @Query("from Book b where b.publishedate<?1 ")
    public List<Book> publisheddatebefor(Date date);
    public abstract List<Book> findByPublishedateBefore(Date start);
    public abstract List<Book> findByPublishedateAfter(Date start);
    public abstract List<Book> findByPublishedateBetween(Date start ,Date end);
}
