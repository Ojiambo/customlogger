package com.apps.springmvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apps.springmvc.form.Book;
import com.apps.springmvc.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/index")
	public String listBooks(Map<String, Object> map) {
		map.put("book", new Book());
		map.put("bookList", bookService.listBooks());
		return "book";
		
	}

	@RequestMapping(value = "/book/add", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") Book book,
			BindingResult result) {
		//boolean error = false;
		if (null == book.getId()) {
//			if (null == book.getBookName() || null == book.getAuthor()
//					|| 0 == book.getPrice()) {
//				result.rejectValue("bookName", "error.validation");
//				result.rejectValue("author", "error.validation");
//				result.rejectValue("price", "error.validation");
//				error = true;
//				return "book";
//			} else {
				bookService.addBook(book);
			//}
		} else {
			bookService.updateBook(book);
		}
		return "redirect:/index";
	}

	@RequestMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") Integer bookId) {
		bookService.removeBook(bookId);
		return "redirect:/index";
	}

	@RequestMapping("/edit/{bookId}")
	public String editBook(@PathVariable("bookId") Integer bookId,
			Map<String, Object> map) {
		map.put("book", bookService.getBookById(bookId));
		map.put("bookList", bookService.listBooks());
		return "book";
	}
}

// http://localhost:8080/SpringMVC-Hibernate/index