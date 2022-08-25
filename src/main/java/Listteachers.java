import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Students;
import classes.Teachers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Servlet implementation class ListTeachers
 */
@WebServlet("/listteachers")
public class Listteachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listteachers() {
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

		try {
			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata md=new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory sf=md.getSessionFactoryBuilder().build();
			Session s= sf.openSession();
			Transaction t= s.beginTransaction();
			// 3. read Customers
			List<Teachers> teachers = s.createQuery("from Teachers").list();

			//show data as table.
			
			out.print("<table >");
			out.print("<tr>");
				out.print("<th> Teacher Id</th>");
				out.print("<th> Teacher Name</th>");
				out.print("<th> Teacher Email</th>");
				out.print("<th> Teacher Address</th>");
				out.print("<th> Teacher Subject </th>");

			out.print("</tr>");

			for(Teachers p : teachers) {
				out.print("<tr>");
				out.print("<td>"+p.getId()+"</td>");
				out.print("<td>"+p.getName()+"</td>");
				out.print("<td>"+p.getEmail()+"</td>");
				out.print("<td>"+p.getAddress()+"</td>");
				out.print("<td>"+p.getSubject()+"</td>");

				out.print("</tr>");
			}
			out.print("</table><br><br>");
			t.commit();
			out.print("<h3><a href='addteacher.html'>Back </a></h3>");
			// 3. close session
			s.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}