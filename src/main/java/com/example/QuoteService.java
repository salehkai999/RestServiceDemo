package com.example;

/*
	Saleh Qaseer 1981576
	Homework 4
*/


import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QuoteService {
    private static Map<Long,Quote> allQuotes = new HashMap<>(); // HashMap to store quotes with ID
    private static  QuoteService quoteService; 
    
    private QuoteService() { // private constructor since I'm using the singelton design pattern
		init(); 
	}
    
    private void init() { // initalization method to preseed the quotes map with quotes objects
		allQuotes.put(1L, new Quote(1,"The Ones who are crazy enough to think they can change the world are the ones who do","Steve Jobs"));
		allQuotes.put(2L, new Quote(2,"The best way to predict the future is to create it","Peter Drucker"));
		allQuotes.put(3L, new Quote(3,"For every minute you are angry you lose sixty seconds of happiness","Ralph Waldo Emerson"));
		allQuotes.put(4L, new Quote(4,"To give anything less than your best, is to sacrifice the gift","Steve Prefontaine"));
		allQuotes.put(5L, new Quote(5,"Life is really simple, but we insist on making it complicated","Confucius"));
		allQuotes.put(6L, new Quote(6,"Everybody lies. No exceptions","Chloe Price"));
    }
	
	// using the singelton design pattern, since we will only need one object to be inilialized at a time, THOUGH it's not a thread safe because moslty it's for one client testing purposes
    public static QuoteService getServiceInstance() {
    	if(quoteService==null)
    		quoteService=new QuoteService();
    	return quoteService; 
    }
	
	// returning the values of hashmap
	public List<Quote> getAllQuotes() {
		return new ArrayList<Quote>(allQuotes.values());
	}
	
	// the pagenation logic 
	public List<Quote> getQuotesPage(int start, int size){
		ArrayList<Quote> pageList = new ArrayList<>();
		for(Quote q : allQuotes.values())
		{
			if(q.getId()>start)
				pageList.add(q);
		}
		if((start+size) > allQuotes.size()) return new ArrayList<Quote>();
		
		for(Quote q : pageList)
			System.out.println(q.toString());
		return pageList;
	}
	
	// getting a particular quote from the map via ID
	public Quote getQuote(long id) {
		return allQuotes.get(id);
	}
	
	// adding new quote to the hashmap
	public Quote addQuote(Quote quote) {
		quote.setId(allQuotes.size()+1);
		allQuotes.put(quote.getId(),quote );
		return quote;
	}
	
	// updating a particular quote using its ID
	public Quote updateQuote(Quote newQuote) {
		if(newQuote.getId() <= 0)
			return null;		
		allQuotes.put(newQuote.getId(),newQuote);
		return allQuotes.get(newQuote.getId());
	}

	// removing a particular quotes using its ID
	public void removeQuote(long id) {	
		allQuotes.remove(id, allQuotes.get(id));

    }
	
	

}