package com.example;

/*
	Saleh Qaseer 1981576
	Homework 4
*/


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.example.Quote;
import com.example.QuoteService;


/**
 * Root resource (exposed at "quotes" path)
 */
@Path("quotes")
public class QuoteResource {

   
	// getting the QuoteService instance  
    QuoteService quoteService = QuoteService.getServiceInstance();
	
	// Method handling HTTP Get pagenation Requests the returned object will be sent as JSON
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Quote>getQuote(@QueryParam("per_page") int start,@QueryParam("page") int size) {
		if(start > 0 && size > 0)
			return quoteService.getQuotesPage(start, size);
		return quoteService.getAllQuotes();
	}
	
	// Method handling HTTP Get by ID Requests the returned object will be sent as JSON
	@GET
	@Path("/{qId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Quote getQuoteById(@PathParam("qId") long qId){		
		return quoteService.getQuote(qId);
	}
	
	// Method handling HTTP POST Requests to add new quote object, the consumed objects are JSON
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Quote addQuote(Quote quote) {
		
		return quoteService.addQuote(quote);
	}
	
	// Method handling HTTP PUT Requests to update a particular quote object, the consumed objects are JSON
	@PUT
	@Path("/{qId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Quote updateQuote(@PathParam("qId") long qId , Quote newQuote) {
		newQuote.setId(qId);
		return quoteService.updateQuote(newQuote);
	} 

	// Method handling HTTP DELETE Requests to delete a particular quote object, the consumed objects are JSON
	@DELETE
	@Path("/{qId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteQuote(@PathParam("qId") long qId)
	{
		quoteService.removeQuote(qId);
	}
}
