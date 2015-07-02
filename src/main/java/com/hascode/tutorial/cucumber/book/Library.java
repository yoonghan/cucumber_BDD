package com.hascode.tutorial.cucumber.book;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library {
	private final List<Book> store = new ArrayList<Book>();
	
	public void addBook(final Book book){
		store.add(book);
	}
	
	public List<Book> findBooks(final Date from, final Date to){
		Calendar end = Calendar.getInstance();
		end.setTime(to);
		end.roll(Calendar.YEAR, 1);
		
		ArrayList<Book> newList = new ArrayList<Book>(10);
		
		for(int i=0; i< store.size(); i++){
			Book book = store.get(i);
			if(from.before(book.getPublished()) && end.getTime().after(book.getPublished()) ){
				newList.add(book);
			}
		}
		Collections.sort(newList, new LexicographicComparator());
		Collections.reverse(newList);
		
		return newList; 
	}
	
}

class LexicographicComparator implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
        return (a.getPublished()).compareTo(b.getPublished());
    }
}
