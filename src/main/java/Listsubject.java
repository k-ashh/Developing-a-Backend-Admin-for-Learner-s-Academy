import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Classes;
import classes.Subjects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Servlet implementation class ListSubject
 */
@WebServlet("/listsubject")
public class Listsubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listsubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=md.getSessionFactoryBuilder().build();
		Session s= sf.openSession();
		Transaction t= s.beginTransaction();
		List<Subjects> subj= s.createQuery("from Subjects").list();
		
		out.print("<table >");
		out.print("<tr>");
			out.print("<th> Subject Id</th>");
			out.print("<th> SubjectName</th>");
			out.print("<th> SubjectCode</th>");


		out.print("</tr>");

		for(Subjects p : subj) {
			out.print("<tr>");
			out.print("<td>"+p.getId()+"</td>");
			out.print("<td>"+p.getSubname()+"</td>");
			out.print("<td>"+p.getSubcode()+"</td>");
			//out.print("<td>"+p.getSection()+"</td>");

			out.print("</tr>");
		}
		out.print("</table><br><br>");
		t.commit();
		out.print("<h3><a href='addsubject.html'>Back </a></h3>");
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