import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import classes.*;
/**
 * Servlet implementation class ListClasses
 */
@WebServlet("/listclasses")
public class Listclasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listclasses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=md.getSessionFactoryBuilder().build();
		Session s= sf.openSession();
		Transaction t= s.beginTransaction();
		List<Classes> cls= s.createQuery("from Classes").list();
		out.print("<table>");
		out.print("<tr>");
		out.print("<th> Class Id</th>");
		out.print("<th>  ClassName</th>");
		out.print("<th>  ClassRoom</th>");
		out.print("<th>  ClassSection</th>");
		out.print("</tr>");
		for(Classes p : cls) 
		{
			out.print("<tr>");
			out.print("<td>"+p.getId()+"</td>");
			out.print("<td>"+p.getClassname()+"</td>");
			out.print("<td>"+p.getRoomno()+"</td>");
			out.print("<td>"+p.getSection()+"</td>");

			out.print("</tr>");
		}
		out.print("</table><br><br>");
		t.commit();
		out.print("<h3><a href='addclasses.html'>Back </a></h3>");
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