package com.example.herokudemo.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/students")
@Api(value = "API to search Student from a Student Repository by different search parameters",
		description = "This API provides the capability to search Student from a Student Repository", produces = "application/json")
public class BookController {

//	@Autowired
//	BookRepository bookRepository;
//
//	@Autowired
//	BookManager bookManager;
//
//	@ApiOperation(value = "Get All Student", produces = "application/json")
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String welcome() {
//		return "Welcome to project about management of book!";
//	}
//
//	// Find All
//	@GetMapping("/books")
//	List<Book> findAll() {
//		return bookRepository.findAll();
//	}
//
//	// Find All
//	@GetMapping("/delete-all")
//	String deleteaaaAA() {
//		bookRepository.deleteAll();
//		return "Success";
//	}
//
//	// Find All
//	@GetMapping("/abc")
//	String deleteaaaAAB() {
//		bookRepository.deleteAll();
//		return "Success";
//	}
//
//	// Find One
//	@GetMapping("/books/{id}")
//	Book findOne(@PathVariable Long id) {
//		return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
//	}
//
//	// Borrow
//	@GetMapping("/books/borrow/{id}")
//	String borrow(@PathVariable Long id) {
//		bookManager.borrow(id);
//		return "success";
//	}
//
//	// Save
//	@PostMapping("/books")
//	@ResponseStatus(HttpStatus.CREATED)
//	Book creatBook(@RequestBody Book newBook) {
//		return bookRepository.save(newBook);
//	}
//
//	// Save or Update
//	@PutMapping("books/{id}")
//	Book updateBook(@RequestBody Book book, @PathVariable Long id) {
//		return bookRepository.findById(id).map(x -> {
//			x.setName(book.getName());
//			x.setAuthor(book.getAuthor());
//			x.setPrice(book.getPrice());
//			return bookRepository.save(x);
//		}).orElseGet(() -> {
//			book.setId(id);
//			return bookRepository.save(book);
//		});
//	}
//
//	//	 Update only author
//	@PatchMapping("books/{id}")
//	Book patchBook(@RequestBody Book book, @PathVariable Long id) {
//		return bookRepository.findById(id).map(x -> {
//			x.setAuthor(book.getAuthor());
//			return bookRepository.save(x);
//		}).orElseGet(() -> {
//			throw new BookUnSupportedFieldPatchException();
//		});
//
//	}
//
//	// Delete book by id
//	@DeleteMapping("/books/{id}")
//	void deleteBook(@PathVariable Long id) {
//		bookRepository.deleteById(id);
//	}
}
