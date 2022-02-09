package WebPageTesting;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserFeedBackServlet
 */
@WebServlet("/UserFeedBackServlet")
public class UserFeedBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFeedBackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String Name = request.getParameter("Name");
        String Mobile = request.getParameter("Mobile");
        String Email = request.getParameter("Email");
        String CustomerServiceHelpful = request.getParameter("CustomerServiceHelpful");
        String CustomerServiceKnowledge = request.getParameter("CustomerServiceKnowledge");
        String CommunicationOfServiceOffered = request.getParameter("CommunicationOfServiceOffered");
        String ProblemResolution = request.getParameter("ProblemResolution");
        String Remarks = request.getParameter("Remarks");
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankdb", "root", "");
 
            PreparedStatement ps = con
                    .prepareStatement("insert into usersfeedback values(?,?,?,?,?,?,?,?)");
 
            ps.setString(1, Name);
            ps.setString(2, Mobile);
            ps.setString(3, Email);
            ps.setString(4, CustomerServiceHelpful);
            ps.setString(5, CustomerServiceKnowledge);
            ps.setString(6, CommunicationOfServiceOffered);
            ps.setString(7, ProblemResolution);
            ps.setString(8, Remarks);
                    
            int i = ps.executeUpdate();
            if (i > 0)
                out.print(" Thanks for your feedback...");
           
           
			
 
        } catch (Exception e2) {
            System.out.println(e2);
        }
       
       RequestDispatcher dispatcher = request.getRequestDispatcher("SuccessfulMsgPage.jsp");
       dispatcher.forward(request, response);
		
        out.close();
       
       
    
	}
	
}
