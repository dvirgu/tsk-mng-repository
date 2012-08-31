package org.tsk.mng.frontend.filters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.xerces.parsers.DOMParser;
import org.tsk.mng.common.config.Consts;
import org.tsk.mng.common.infra.SpringInitializer;
import org.tsk.mng.dal.dao.interfaces.UserDao;
import org.tsk.mng.dal.model.UserDT;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


/**TODO fix auth filter
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/services/*")
public class AuthenticationFilter implements Filter {

	private static final String userNameNode 	= "<soap:userName>";
	private static final String endUserNameNode = "</soap:userName>";
	private static final String passNameNode 	= "<soap:password>";
	private static final String endPassNameNode = "</soap:password>";
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
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		BufferedRequestWrapper bufferedRequest = new BufferedRequestWrapper(httpRequest);
		
		InputStream inStream=bufferedRequest.getInputStream(); 
		InputStreamReader reader = new InputStreamReader(inStream); 
		BufferedReader bReader = new BufferedReader(reader); 
		
		String soapBody = bReader.readLine(); 
		String userName = null;
		while(soapBody != null){
			int firstIndex = soapBody.lastIndexOf(userNameNode) + userNameNode.length();
			int lastIndex = soapBody.indexOf(endUserNameNode);
			if(firstIndex != -1 && lastIndex != -1){
				userName = soapBody.substring(firstIndex, lastIndex);
				if(userName != null & !userName.isEmpty()){
					break;
				}
			}
			soapBody = bReader.readLine(); 
		}
		
		String password = null;
		while(soapBody != null){
			//soapBody = soapBody.trim();
			int firstIndex = soapBody.lastIndexOf(passNameNode) + passNameNode.length();
			int lastIndex = soapBody.indexOf(endPassNameNode);
			if(firstIndex != -1 && lastIndex != -1){
				password = soapBody.substring(firstIndex, lastIndex);
				if(password != null & !password.isEmpty()){
					break;
				}
			}
			soapBody = bReader.readLine(); 
		}
		if(userName != null && !userName.isEmpty() && password != null && !password.isEmpty()){
			UserDao userDao = SpringInitializer.getBeanFactory().getBean(Consts.USER_DAO_BEAN_ID, UserDao.class);
			boolean isAllowed = userDao.authenticate(userName ,password);
			if(isAllowed){
				chain.doFilter(bufferedRequest, response);
			}
		} else {
			PrintWriter out = response.getWriter();
			out.println("<b>Filter Received Your Message Successfully:</b>");
		}
		
		//String personId = getMessageValue("personId",soapBody); 
		
//		StringBuilder content =new StringBuilder();
//		String line = null;
//		try {
//			System.out.println("after1 " + httpRequest.getContentType());
//			ServletInputStream reader = httpRequest.getInputStream();
//			System.out.println("after2 " + httpRequest.getContentType());
//
//			do {
//				byte[] arrB = new byte[1024];
//				reader.read(arrB);
//				System.out.println(arrB.toString());	
//			} while (reader.available() > 0);
//
//			
//
//			reader.close();
//			System.out.println("after3 " + httpRequest.getContentType());
//
//		}  catch (Exception e) {
//			e.printStackTrace();
//		}//report an error
//
//		try {
//		    JSONObject jsonObject = JSONObject.fromObject(jb.toString());
//		  } catch (ParseException e) {
//		    // crash and burn
//		    throw new IOException("Error parsing JSON request string");
//		  }

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
