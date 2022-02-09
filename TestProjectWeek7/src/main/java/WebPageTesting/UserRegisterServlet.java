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
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
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
        String CustomerName = request.getParameter("CustomerName");
        String DOB = request.getParameter("DOB");
        String IdentficationType = request.getParameter("IdentficationType");
        String IdentificationNumber = request.getParameter("IdentificationNumber");
        String Address = request.getParameter("Address");
        String MobileNumber = request.getParameter("MobileNumber");
        String EmailID = request.getParameter("EmailID");
        String Occupation = request.getParameter("Occupation");
        String AccountType = request.getParameter("AccountType");
        String AccountNumber = request.getParameter("AccountNumber");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankdb", "root", "");
 
            PreparedStatement ps = con
                    .prepareStatement("insert into UsersRegistration values(?,?,?,?,?,?,?,?,?,?)");
 
            ps.setString(1, CustomerName);
            ps.setString(2, DOB);
            ps.setString(3, IdentificationNumber);
            ps.setString(4, Address);
            ps.setString(5, MobileNumber);
            ps.setString(6, EmailID);
            ps.setString(7, Occupation);
            ps.setString(8, AccountType);
            ps.setString(9, AccountNumber);
            ps.setString(10, IdentficationType);
            
            int i = ps.executeUpdate();
            if (i > 0)
                out.print("  Customer Registeration Done Successfully...");
 
        } catch (Exception e2) {
            System.out.println(e2);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("SuccessfulMsgPage.jsp");
        dispatcher.forward(request, response);
        out.close();
	}

}
