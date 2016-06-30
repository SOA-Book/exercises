package au.edu.unsw.soacourse.topdownclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.edu.unsw.soacourse.marketservice.ImportMarketDataRequest;
import au.edu.unsw.soacourse.marketservice.ImportMarketDataResponse;
import au.edu.unsw.soacourse.marketservice.ImportMarketFaultMsg;
import au.edu.unsw.soacourse.marketservice.ObjectFactory;
import au.edu.unsw.soacourse.marketservice.TopDownSimpleService;
import au.edu.unsw.soacourse.marketservice.TopDownSimpleServiceImplService;

/**
 * Servlet implementation class TopDownServiceClient
 */
public class TopDownServiceClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TopDownServiceClient() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			TopDownSimpleServiceImplService service = new TopDownSimpleServiceImplService(new URL(
					"http://localhost:8080/TopDownSimpleService/topdownfault?wsdl"));
			TopDownSimpleService port = service.getTopDownSimpleServiceImplPort();
			ImportMarketDataRequest req = new ObjectFactory().createImportMarketDataRequest();
			req.setSec("ABC");
			req.setStartDate("01-DEC-2014");	  
			req.setEndDate("01-DEC-2014");	
			req.setDataSource("http://www.example.org.ss/marketfile");
			  
			ImportMarketDataResponse resp = port.importMarketData(req);
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<HTML>");
			out.println("<BODY>");
			out.println("<HEAD>");
			out.println("<TITLE>TopDownSimpleService Client Page</TITLE>");
			out.println("</HEAD>");
			out.println("<body>");
			out.println("<CENTER>");
			out.print(resp.getReturnData());
			out.println("</CENTER>");
			out.println("</BODY>");
			out.println("</HTML>");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ImportMarketFaultMsg e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
