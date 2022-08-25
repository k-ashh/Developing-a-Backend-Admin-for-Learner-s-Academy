import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Subjects;
import classes.Teachers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Servlet implementation class AddTeacher
 */
@WebServlet("/addteacher")
public class Addteacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addteacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("addteacher.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		
		try {
			String TeacherName = request.getParameter("name");
			String teacherEmail=request.getParameter("email");
			String teacherAddress = request.getParameter("address");
			String teachersubject=request.getParameter("subject");
			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata md=new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory sf=md.getSessionFactoryBuilder().build();
			Session s= sf.openSession();
			Transaction t= s.beginTransaction();
			Teachers tea = new Teachers();
			tea.setName(TeacherName);
			tea.setEmail(teacherEmail);
			tea.setAddress(teacherAddress);
			tea.setSubject(teachersubject);
			

			if(tea != null ) 
			{
				s.save(tea);
				t.commit();
				out.print(" Teacher is Added sucessfully");
			}

			// 3. close session
			s.close();
		}catch(Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
		}
	}

}