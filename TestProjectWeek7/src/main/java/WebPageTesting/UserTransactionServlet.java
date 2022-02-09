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
 * Servlet implementation class UserTransactionServlet
 */
@WebServlet("/UserTransactionServlet")
public class UserTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserTransactionServlet() {
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
        String AccountNumber = request.getParameter("AccountNumber");
        String TransactionType = request.getParameter("TransactionType");
        String TransactionMode = request.getParameter("TransactionMode");
        String TransactionAmount = request.getParameter("TransactionAmount");
        String Remarks = request.getParameter("Remarks");
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankdb", "root", "");
 
            PreparedStatement ps = con
                    .prepareStatement("insert into UsersTransaction values(?,?,?,?,?)");
 
            ps.setString(1, AccountNumber);
            ps.setString(2, TransactionType);
            ps.setString(3, TransactionMode);
            ps.setString(4, TransactionAmount);
            ps.setString(5, Remarks);
                    
            int i = ps.executeUpdate();
            if (i > 0)
                out.print("  Transaction Done Successfully...");
            	
 
        } catch (Exception e2) {
            System.out.println(e2);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("SuccessfulMsgPage.jsp");
        dispatcher.forward(request, response);
        out.close();
       
	}

}
