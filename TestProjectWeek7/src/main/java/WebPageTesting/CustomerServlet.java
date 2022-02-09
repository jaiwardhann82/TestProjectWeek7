package WebPageTesting;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/CustomerServlet")
	public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3306/bankdb";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";



	//private static final String INSERT_USERS_SQL = "INSERT INTO users" + " (CustomerName,DOB,IdentficationType,Address,MobileNumber,EmailID) VALUES " + " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select CustomerName,DOB,IdentficationType,Address,MobileNumber,EmailID from usersregistration where CustomerName =?";
	//private static final String SELECT_ALL_USERS = "select * from usersregistration";
	private static final String SELECT_ALL_USERS = "select CustomerName,DOB,IdentficationType,Address,MobileNumber,EmailID from usersregistration";
	private static final String DELETE_USERS_SQL = "delete from usersregistration where CustomerName = ?;";
	private static final String UPDATE_USERS_SQL = "update usersregistration set CustomerName = ?,DOB= ?, IdentficationType =?,Address =? ,MobileNumber =?,EmailID =? where CustomerName = ?;";



	protected Connection getConnection() {
	Connection connection = null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	}
	catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	return connection;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();

		 

        try {

            switch (action) {

                case "/new":

                    break;
                case "CustomerServlet/list":
                	listUser(request, response);
                	break;

                case "/insert":

                    break;

                case "/CustomerServlet/delete": 

                    deleteUser(request, response); 

                    break; 

                case "/CustomerServlet/edit": 

                    showEditForm(request, response); 

                    break; 

                case "/CustomerServlet/update": 

                    updateUser(request, response); 

                    break; 

                default:

                    listUser(request, response);

                    break;

            }

        } catch (SQLException ex) {

            throw new ServletException(ex);

        }
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
			{
			List < Customers > users = new ArrayList < > ();

			try (Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);)
			{
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
			String CustomerName = rs.getString("CustomerName");
			String DOB = rs.getString("DOB");
			String IdentficationType = rs.getString("IdentficationType");
			String Address = rs.getString("Address");
			String MobileNumber = rs.getString("MobileNumber");
			String EmailID = rs.getString("EmailID");
			
		//line 168 and 223
		//	users.add(new User(name, dob, identification, address, mobile, email));
			users.add(new Customers(CustomerName, DOB, IdentficationType, Address, MobileNumber, EmailID));
			System.out.println(CustomerName);
			}
			} catch (SQLException e) {
			printSQLException(e);
			}
			//List < User > listUser = databaseOperations.selectAllUsers();

			System.out.println("total user is: " + users.size());
			request.setAttribute("listUser", users);
			RequestDispatcher dispatcher = request.getRequestDispatcher("../customerManagement.jsp");
			dispatcher.forward(request, response);
			
			}
	
	
	//method to get parameter, query database for existing user data and redirect to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, ServletException, IOException
	{
	System.out.println("comes to showEditForm");
	//get parameter passed in the URL



	String CustomerName = request.getParameter("CustomerName");
	Customers existingUser = new Customers();



	//database operation, get data for existing user
	// Step 1: Establishing a Connection
	try (Connection connection = getConnection();



	// Step 2:Create a statement using connection object
	PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
	preparedStatement.setString(1, CustomerName);
	System.out.println(preparedStatement);

	// Step 3: Execute the query or update query
	ResultSet rs = preparedStatement.executeQuery();

	// Step 4: Process the ResultSet object.
	while (rs.next()) {
	
	CustomerName = rs.getString("CustomerName");
	String DOB = rs.getString("DOB");
	String IdentficationType = rs.getString("IdentficationType");
	String Address = rs.getString("Address");
	String MobileNumber = rs.getString("MobileNumber");
	String EmailID = rs.getString("EmailID");
	
	//existingUser = new Customers(name, dob, identification, address);
	//existingUser = new Customers(name,dob,identification, address,mobile,email);
	existingUser = new Customers(CustomerName,DOB,IdentficationType, Address,MobileNumber,EmailID);
	}
	} catch (SQLException e) {
	printSQLException(e);
	}
	//Serve up the user-form.jsp
	request.setAttribute("user", existingUser);
	request.getRequestDispatcher("/customerEdit.jsp").forward(request, response);
	}

	//method to update the user data
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException
	{
	System.out.println("comes to updateUser");




	//get values from the request
	String oriName = request.getParameter("oriName");
	String CustomerName = request.getParameter("CustomerName");
	String DOB = request.getParameter("DOB");
	String IdentficationType = request.getParameter("IdentficationType");
	String Address = request.getParameter("Address");
	String MobileNumber = request.getParameter("MobileNumber");
	String EmailID = request.getParameter("EmailID");

	System.out.println(CustomerName);
	System.out.println(DOB);
	System.out.println(IdentficationType);
	System.out.println(Address);
	System.out.println(MobileNumber);
	System.out.println(EmailID);

	//database operation
	try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
	statement.setString(1, CustomerName);
	statement.setString(2, DOB);
	statement.setString(3, IdentficationType);
	statement.setString(4, Address);
	statement.setString(5, MobileNumber);
	statement.setString(6, EmailID);
	statement.setString(7, oriName);



	int i = statement.executeUpdate();
	}

	//redirect us back to UserServlet !note: do change the url to your project name
	response.sendRedirect("http://localhost:8089/TestProjectWeek5/CustomerServlet/list");
	}

	//method to delete user
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException
	{
	System.out.println("comes to deleteUser");



	String CustomerName = request.getParameter("CustomerName");
	try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);)
	{
	statement.setString(1, CustomerName);
	int i = statement.executeUpdate();
	}

	//redirect us back to UserServlet !note: do change the url to your project name
	response.sendRedirect("http://localhost:8089/TestProjectWeek5/CustomerServlet/list");
	}

			private void printSQLException(SQLException ex) {
			for (Throwable e: ex) {
			if (e instanceof SQLException) {
			e.printStackTrace(System.err);
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());
			System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
			System.err.println("Message: " + e.getMessage());
			Throwable t = ex.getCause();
			while (t != null) {
			System.out.println("Cause: " + t);
			t = t.getCause();
			}
			}
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
