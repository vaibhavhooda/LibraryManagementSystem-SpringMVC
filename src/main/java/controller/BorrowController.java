package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.BorrowDao;
import dao.MemberDao;
import model.BorrowModel;

@Controller
public class BorrowController {
	
	private BorrowDao bdao;
	public BorrowController() {
        super();
        bdao = new BorrowDao();
    }
	
	@RequestMapping(value = "/borrow", method = RequestMethod.GET)
	public ModelAndView borrow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException	{
		
		ArrayList<BorrowModel> borrow = new ArrayList<BorrowModel>();
		try {
			borrow = bdao.getBorrowDetails();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("borrow", borrow);
		response.setContentType("text/html;charset=UTF-8");

		ModelAndView mv = new ModelAndView();
        mv.setViewName("Borrow.jsp");
        mv.addObject("result",
                     "");
        return mv;
	}

}
