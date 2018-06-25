package org.cherry.sample.web;

import java.util.ArrayList;
import java.util.List;

import org.cherry.sample.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

	@RequestMapping("list")
	public String listBooks(Model model) {
		List<Book> books = new ArrayList<>();
		books.add(new Book("The Mist", "Stephen King", "", "ISBN1234", 1999));
		books.add(new Book("Gone with the Wind", "Margaret Mitchell", "", "ISBN5678", 1964));
		books.add(new Book("Lord of the Rings", "J.R.R.Tolkien", "", "ISBN9900", 1965));
		
		model.addAttribute("books", books);
		return "list";
	}
	
}
