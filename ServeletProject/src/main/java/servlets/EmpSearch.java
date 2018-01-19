package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Employee.EmpNormal.Normal.Employee;
import com.Employee.EmpNormal.Normal.EmployeeDBOperations;

import javax.servlet.RequestDispatcher;

public class EmpSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("pages/EnterID.jsp");
		rd.forward(request, response);
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String userId = request.getParameter("EmpID");
   EmployeeDBOperations empDBO = new EmployeeDBOperations(); 
   Employee emp = new Employee();	
try {
		 emp =empDBO.findEmployee(userId);
		

		 }
	catch(SQLException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	if(emp !=null)
	{
		request.setAttribute("message", emp);
		doGet(request, response);
		
	}
	else
		request.setAttribute("error", "id not found!!");
	doGet(request, response);
}
}