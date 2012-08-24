package org.tsk.mng.frontend.filters;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


/**TODO fix auth filter
 * Servlet Filter implementation class AuthenticationFilter
 */
//@WebFilter("/services/*")
public class AuthenticationFilter implements Filter {

	/**
	 * Default constructor. 
	 */
	public AuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
/*		System.out.println("before " + request.getContentType());
		HttpServletRequest httpRequest = (HttpServletRequest)request;

		StringBuilder content =new StringBuilder();
		String line = null;
		try {
			System.out.println("after1 " + httpRequest.getContentType());
			ServletInputStream reader = httpRequest.getInputStream();
			System.out.println("after2 " + httpRequest.getContentType());

			do {
				byte[] arrB = new byte[1024];
				reader.read(arrB);
				System.out.println(arrB.toString());	
			} while (reader.available() > 0);

			

			reader.close();
			System.out.println("after3 " + httpRequest.getContentType());

		}  catch (Exception e) {
			e.printStackTrace();*/
		//}//report an error

		/*try {
		    JSONObject jsonObject = JSONObject.fromObject(jb.toString());
		  } catch (ParseException e) {
		    // crash and burn
		    throw new IOException("Error parsing JSON request string");
		  }*/

		// pass the request along the filter chain
	//	chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
