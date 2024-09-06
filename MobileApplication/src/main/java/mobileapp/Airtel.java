package mobileapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Airtel")
public class Airtel extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("select");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		try {
		Connection con=JDBC.getcon();
		PreparedStatement ps=con.prepareStatement("select * from airtel");
		ResultSet rs=ps.executeQuery();
		pw.print("<html><body>");
		pw.print("<table border=1 height=20% width=70% align=center>");
		pw.print("<tr bgcolor=red><th>Current Price(Rs)</th><th>Validity</th><th>New Price(Rs)</th><th>Benifits</th></tr>");
		while(rs.next())
		{
			pw.println("<tr align=center>");
			pw.println("<td><b>"+rs.getInt(1)+"</b></td><td>"+rs.getString(2)+"</td><td id=newprice>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td>");
			pw.println("</tr>");
			HttpSession session=request.getSession();
			String mynumber=(String)session.getAttribute("recharge_no");
			pw.print(mynumber);
		}
		ps.close();
		pw.print("</table>");
		pw.print("</body></html>");
		}
		catch(Exception e)
		{
			pw.print(e);
		}
		}

}
