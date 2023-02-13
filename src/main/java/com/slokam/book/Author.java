package com.slokam.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Author {
	@Id
	@GeneratedValue
private Integer id;
private String aname;
private long phone;

@Override
public String toString() {
	return "id=" + id + ", aname=" + aname + ", phone=" + phone;
}

}
