package com.yiibai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		// retrieving data from ServletContext object
		ServletContext ctx = getServletContext();
		int t = (Integer) ctx.getAttribute("totalusers");
		int c = (Integer) ctx.getAttribute("currentusers");
		out.print("<br>用户总数： " + t);
		out.print("<br>当前用户数： " + c);
		out.print("<br><a href='logout'>注销</a>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("username");
		String password = request.getParameter("password");
		// 假设输入密码为：123456时，此用户登录成功
		if (password == null) {
			password = "";
		}
		if (password.equals("123456")) {
			out.print("您好, " + n);
			HttpSession session = request.getSession();
			session.setAttribute("uname", n);
		} else {
			out.print("登陆失败 ~");
		}
		// retrieving data from ServletContext object
		ServletContext ctx = getServletContext();
		int t = (Integer) ctx.getAttribute("totalusers");
		int c = (Integer) ctx.getAttribute("currentusers");
		out.print("<br>用户总数： " + t);
		out.print("<br>当前用户数： " + c);
		out.print("<br><a href='logout'>注销</a>");
		out.close();
	}

}
