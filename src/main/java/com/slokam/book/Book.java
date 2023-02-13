package com.slokam.book;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;

@Entity
@Data
public class Book {
	@Id
	@GeneratedValue
private int bid;
private String bname;
private double bcost;
@Temporal(TemporalType.TIMESTAMP)
private Date publishedate;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="aid")
private Author author;
@Override
public String toString() {
	return "bid=" + bid + ", bname=" + bname + ", bcost=" + bcost;
}


}
