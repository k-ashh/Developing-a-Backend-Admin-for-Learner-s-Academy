

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Classes;
import classes.Students;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/addstudent")
public class Addstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addstudent() {
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
		//request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("addstudent.html").include(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			String Name = request.getParameter("name");
			String Rollno = request.getParameter("rollno");
			String Add = request.getParameter("ad");
			String Cl=request.getParameter("cl");
			String Gender=request.getParameter("gender");
			String Dob=request.getParameter("dob");
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=md.getSessionFactoryBuilder().build();
		Session s= sf.openSession();
		Students product = new Students();
		product.setName(Name);
		product.setRollno(Rollno);
		product.setAddress(Add);
		product.setCl(Cl);
		product.setGender(Gender);
		product.setDob(Dob);
		
		Transaction t= s.beginTransaction();
		

		// 6. commit transaction
		

		if(product != null ) {
			s.save(product);
			t.commit();
			out.print(" Student is Added sucessfully");
		}

		// 3. close session
		s.close();
	}catch(Exception e) {
		out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
	}
	}
}