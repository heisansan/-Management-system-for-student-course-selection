package  ser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import  dao.DaoStu;
import  dao.DaoTea;
import  user.Student;
import  user.Teacher;

@SuppressWarnings("serial")
public class serDoLogin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public serDoLogin() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		//response.setCharacterEncoding("utf-8");
		//response.setHeader("content-type","text/html;charset=utf-8");
		try{
			int username = Integer.parseInt(request.getParameter("username"));
			String password = request.getParameter("password");
			String type  = null;
			if(request.getParameter("type")!=null)
				type = request.getParameter("type");
			if(type.equals("tea")){//�ж��Ƿ�Ϊ��ʦ
				Teacher tea = new Teacher(username,null,password);
				DaoTea logint = new DaoTea();
				tea = logint.loginTea(tea);
				if(tea!=null){
					session.setAttribute("teacher", tea);
					response.sendRedirect("/Ten/tea/teacher.jsp");
				}else{
					out.println("T�û��������벻��ȷ����˶Ժ�����!!");
					response.setHeader("refresh","2;url=/Ten/tea/teaLogin.jsp");
				}
			}else if(type.equals("stu")){	//�ж��Ƿ�Ϊѧ��
				Student stu = new Student(username,null,password,null,null,0);
				out.println(stu.getSname()+"::"+stu.getSpassword()+"<br>");
				out.println(stu.getSname()+"::"+stu.getSpassword()+"<br>");
				DaoStu logins  = new DaoStu();
				stu = logins.loginStu(stu);
				if(stu!=null){
					session.setAttribute("student", stu);
					response.sendRedirect("/Ten/stu/student.jsp");
				}else{
					out.println("S�û��������벻��ȷ����˶Ժ�����!!");
					response.setHeader("refresh","2;url=/Ten/Login.jsp");
				}
			}else{
				out.println("�������¼��");
				response.setHeader("refresh","2;url=/Ten/Login.jsp");
			}
		}catch(Exception e){ e.printStackTrace();response.sendRedirect("/Ten/Login.jsp");}
		out.flush();
		out.close();
		}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
