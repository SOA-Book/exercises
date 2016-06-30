package au.edu.unsw.soacourse.books.client;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

public class BookServiceClient {
	
	static final String REST_URI = "http://localhost:8080/RestfulBookService";
	
	public static void main(String[] args) {
		
		
		WebClient bookClient = WebClient.create(REST_URI);
		String s = "";

		// Try various methods for testing the service using this client.

		// Get all books
		bookClient.path("/books").accept(MediaType.APPLICATION_XML);
		s = bookClient.get(String.class);
		System.out.println("Get all books --");
        System.out.println(s);
        		
		//Get books/1 (current path is /books, go to /books/1)
		bookClient.path("/1").accept(MediaType.APPLICATION_XML);
		s = bookClient.get(String.class);
		System.out.println("Get books/1 --");
        System.out.println(s);
        
		// Create a Book with FORM 
        bookClient.back(true); // go to the base URI
		Form form = new Form();
		form.param("id", "4");
		form.param("title", "Programming Collective Intelligence");
		form.param("detail", "Details of Programming Collective Intelligence");
		
		bookClient.path("/books").type(MediaType.APPLICATION_FORM_URLENCODED);
		bookClient.post(form);
		System.out.println("POSTed books/4 now --");
        
		
		//Get books/4 (to see if the previous post worked)
		bookClient.path("/4").accept(MediaType.APPLICATION_XML);
		s = bookClient.get(String.class);
		System.out.println("Get books/4 --");
        System.out.println(s);
		
        
		// Delete books/1
        bookClient.back(true); // go to the base URI
		bookClient.path("/books/1").delete();
		System.out.println("DELETed books/1 now --");
		
		//Get all - to see if book 1 is gone ... (this time, ask for JSON)
		bookClient.reset(); //Resets the headers and response state if any
		bookClient.path("/books").accept(MediaType.APPLICATION_JSON);
		s = bookClient.get(String.class);
		System.out.println("Get all books again --");
	    System.out.println(s);

	}

}
