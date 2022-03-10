package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.BookDao;
import dao.BorrowDao;
import model.BooksModel;
import model.BorrowModel;

@Controller
public class BookController {
	
	private BorrowDao borrowDao;
	private BookDao bookDao;
	public BookController() {
        super();
        borrowDao = new BorrowDao();
        bookDao = new BookDao();
    }
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public ModelAndView book(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException	{
		
		ArrayList<BooksModel> book = new ArrayList<BooksModel>();
		try {
			book = bookDao.getBooks();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("book", book);
		response.setContentType("text/html;charset=UTF-8");
		
		ModelAndView mv = new ModelAndView();
        mv.setViewName("Book.jsp");
        mv.addObject("result",
                     "");
        return mv;
	}
	
	@RequestMapping(value = "/booksubmit", method = RequestMethod.POST)
	public ModelAndView bookSubmit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException	{
		
		if (request.getParameter("issue") != null) {
    		String book_id = request.getParameter("bookId");
    		int bookId = Integer.parseInt(book_id);
    		String member_id = request.getParameter("memberId");
    		int memberId = Integer.parseInt(member_id);
    		String author = request.getParameter("author");
    		String price = request.getParameter("price");
    		String available = request.getParameter("available");
    		String title = request.getParameter("titile");
    		String dueDate = request.getParameter("dueDate");
    		

    		BorrowModel borrow = new BorrowModel();
    		borrow.setBook_id(bookId);
    		borrow.setMember_id(memberId);
    		Date date = new Date();
    	    SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");
    	    String issueDate = formatter.format(date);
    		borrow.setIssue_date(issueDate);
    		borrow.setDue_date(dueDate);
    		borrow.setReturn_date(dueDate);

    		try {
    			borrowDao.issue(borrow);
    		} catch (Exception e)
    		{
    			System.out.print(e.getMessage());
    			e.printStackTrace();
    		}
    		return book(request, response);
    		
        }
        else if (request.getParameter("update") != null) {
        	String book_id = request.getParameter("bookId");
    		int bookId = Integer.parseInt(book_id);
    		String author = request.getParameter("author");
    		String price = request.getParameter("price");
    		boolean available = Boolean.parseBoolean(request.getParameter("available"));
    		String title = request.getParameter("titile");
    		
    		BooksModel book = new BooksModel();
    		book.setBook_id(bookId);
    		book.setAuthor(author);
    		book.setAvailable(available);
    		book.setTitle(title);
    		book.setPrice(bookId);
    		
    		try {
				bookDao.update(book);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		return book(request, response);
        }
        else if(request.getParameter("delete") != null){
        	String book_id = request.getParameter("bookId");
    		int bookId = Integer.parseInt(book_id);
    		
    		BooksModel book = new BooksModel();
    		book.setBook_id(bookId);
    		
    		try {
				bookDao.delete(book);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		return book(request, response);
        }
        else {
        	return book(request, response);
        }
	}

}
