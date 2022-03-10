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
import dao.PublisherDao;
import model.PublisherModel;

@Controller
public class PublisherController {
	
	private PublisherDao pdao;
	public PublisherController() {
        super();
        pdao = new PublisherDao();
    }
	
	@RequestMapping(value = "/pub", method = RequestMethod.GET)
	public ModelAndView publisher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException	{
		
		ArrayList<PublisherModel> publisher = new ArrayList<PublisherModel>();
		try {
			publisher = pdao.getPublishers();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("publisher", publisher);
		response.setContentType("text/html;charset=UTF-8");
		
		ModelAndView mv = new ModelAndView();
        mv.setViewName("publisher.jsp");
        mv.addObject("result",
                     "");
        return mv;
	}
	
	@RequestMapping(value = "/pubsubmit", method = RequestMethod.POST)
	public ModelAndView publisherSubmit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException	{
		if (request.getParameter("register") != null) {
			String pubName = request.getParameter("pubName");
			String pubAddress = request.getParameter("pubAddress");

			PublisherModel pub = new PublisherModel();

			pub.setPub_name(pubName);
			pub.setPub_address(pubAddress);

			try {
				pdao.register(pub);
			} catch (Exception e) {
				System.out.print(e.getMessage());
				e.printStackTrace();
			}
			return publisher(request, response);
		} else if (request.getParameter("update") != null) {
			String pubName = request.getParameter("pubName");
			String pub_Id = request.getParameter("pubId");
			int pubId = Integer.parseInt(pub_Id);
			String pubAddress = request.getParameter("pubAddress");

			PublisherModel pub = new PublisherModel();

			pub.setPub_name(pubName);
			pub.setPub_id(pubId);
			pub.setPub_address(pubAddress);

			try {
				pdao.update(pub);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return publisher(request, response);
		}

		else {
			ModelAndView mv = new ModelAndView();
	        mv.setViewName("publisher.jsp");
	        mv.addObject("result",
	                     "");
	        return publisher(request, response);
		}
	}

}
