package com.MotorbikeStore.controller.web.showDetailsOnPageController;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MotorbikeStore.model.commentModel;
import com.MotorbikeStore.service.ICommentService;

@WebServlet("/review")
public class reviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ICommentService commentService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = null;
		String aMotorIdstr = request.getParameter("aMotorId");
		//check login
		if (session.getAttribute("name") != null && session.getAttribute("role") == "user") {

			// save discussion
			String message = request.getParameter("message");

			String userIdstr = request.getParameter("userId");
			commentModel model = new commentModel();
			if (message != null) {
				model.setCmtDecs(message);
			}

			if (aMotorIdstr != null) {
				model.setaMotorId(Integer.parseInt(aMotorIdstr));
			}
			if (userIdstr != null) {
				model.setUserId(Integer.parseInt(userIdstr));
			}
			if (message != null) {
				int commentId = commentService.save(model);
			}

			// show view again
			response.sendRedirect("notaddshopDetail?id=" + Integer.parseInt(aMotorIdstr) + "");

		} else {

			if (aMotorIdstr != null) {
				response.sendRedirect("login?id1=10&id2=" + Integer.parseInt(aMotorIdstr) + "");
			}

		}

	}

}
