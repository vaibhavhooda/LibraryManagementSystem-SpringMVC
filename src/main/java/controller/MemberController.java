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

import dao.MemberDao;
import model.MemberModel;

@Controller
public class MemberController {
	
	private MemberDao mdao;
	
	public MemberController() {
        super();
        mdao = new MemberDao();
    }
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public ModelAndView member(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException	{
		
		ArrayList<MemberModel> memberList = new ArrayList<MemberModel>();
		try {
			memberList = mdao.getMembers();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("memberList", memberList);
		response.setContentType("text/html;charset=UTF-8");
		
		ModelAndView mv = new ModelAndView();
        mv.setViewName("Member.jsp");
        mv.addObject("result",
                     "");
        return mv;
	}
	
	@RequestMapping(value = "/membersubmit", method = RequestMethod.POST)
	public ModelAndView memberSubmit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException	{
		
		if (request.getParameter("register") != null) {
        	String memName = request.getParameter("memName");
    		String memid = request.getParameter("memId");
    		int memId = Integer.parseInt(memid);
    		String memAddress = request.getParameter("memAddress");
    		String memType = request.getParameter("memType");
    		String memStartdate = request.getParameter("memStartdate");
    		String memExpirydate = request.getParameter("memExpirydate");

    		MemberModel mem = new MemberModel();

    		mem.setMem_name(memName);
    		mem.setMem_id(memId);
    		mem.setMem_address(memAddress);
    		mem.setMem_type(memType);
    		mem.setMem_date(memStartdate);
    		mem.setExpiry_date(memExpirydate);
    		

    		try {
    			mdao.register(mem);
    		} catch (Exception e)
    		{
    			System.out.print(e.getMessage());
    			e.printStackTrace();
    		}
    		return member(request, response);
            
        }
        else if (request.getParameter("update") != null) {
        	String memName = request.getParameter("memName");
    		String memid = request.getParameter("memId");
    		int memId = Integer.parseInt(memid);
    		String memAddress = request.getParameter("memAddress");
    		String memType = request.getParameter("memType");
    		String memStartdate = request.getParameter("memStartdate");
    		String memExpirydate = request.getParameter("memExpirydate");

    		MemberModel mem = new MemberModel();

    		mem.setMem_name(memName);
    		mem.setMem_id(memId);
    		mem.setMem_address(memAddress);
    		mem.setMem_type(memType);
    		mem.setMem_date(memStartdate);
    		mem.setExpiry_date(memExpirydate);
    		

    		try {
    			mdao.update(mem);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return member(request, response);
        }
        
        else {
        	return member(request, response);
        	 
        }
	}

}
