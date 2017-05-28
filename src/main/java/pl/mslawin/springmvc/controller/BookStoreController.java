package pl.mslawin.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.mslawin.springmvc.dao.BookStoreDao;
import pl.mslawin.springmvc.model.Author;
import pl.mslawin.springmvc.model.Book;

import javax.validation.Valid;

@Controller
public class BookStoreController {

    private final BookStoreDao bookStoreDao;

    @Autowired
    public BookStoreController(BookStoreDao bookStoreDao) {
        this.bookStoreDao = bookStoreDao;
    }

    @RequestMapping("/")
    public ModelAndView listBooks() {
        return prepareHomePageAttributes(new Author(), new Book());
    }

    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
    public ModelAndView addAuthor(@Valid @ModelAttribute("author") Author author, BindingResult bindingResult) {
        Book book = new Book();
        if (!bindingResult.hasErrors()) {
            bookStoreDao.addAuthor(author);
            return prepareHomePageAttributes(author, book);
        }
        return prepareHomePageAttributes(author, book);
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ModelAndView addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, @RequestParam("authorId") String authorId) {
        Author author = new Author();
        if (!bindingResult.hasErrors()) {
            bookStoreDao.addBook(book, authorId);
            return prepareHomePageAttributes(author, new Book());
        }
        return prepareHomePageAttributes(author, book);
    }

    private ModelAndView prepareHomePageAttributes(Author author, Book book) {
        return new ModelAndView("home")
                .addObject("books", bookStoreDao.getAllBooks())
                .addObject("authors", bookStoreDao.getAllAuthors())
                .addObject("author", author)
                .addObject("book", book);
    }
}