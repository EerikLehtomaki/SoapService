package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clientWS.Finder;

/**
 * Servlet implementation class IP2Geo_Servlet
 */
@WebServlet("/IP2Geo_Servlet")
public class IP2Geo_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IP2Geo_Servlet() {
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
		// doGet(request, response);
		Finder client = new Finder();

		String value = request.getParameter("value").toString();
		String type = request.getParameter("type").toString();
		PrintWriter out = response.getWriter();
		if(value.equals("")){
			out.write("error: Please, provide a value!");  
		}else{
			String result = "";
			if(type.equals("number")) {
				result = client.convert2word(value);
			}else{
				String city = client.findGeo(value);
				result = city;
			}
			out.write(result); 			
		}
					 
		out.flush();
	    out.close();
	}

}
