/**
 * 
 */
package com.snlabs.aarogyatelangana.account.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.codec.Base64;

/**
 * @author nbattula
 *
 */
public class CTokenUtils {
	
	public static final String KEY = "__ctoken";
	
	public static void createToken(HttpSession session){
		String token = session.getId() + ":" + System.currentTimeMillis();
		byte[] bytes = Base64.encode(token.getBytes());
		token = new String(bytes);
		
		session.setAttribute(KEY, token);
	}
	
	public static boolean isValidToken(HttpSession session, HttpServletRequest request){
		/*String token = request.getParameter(KEY);
		if(session == null || token == null){
			return false;
		}
		return token.equals(session.getAttribute(KEY));*/
		
		String requestSessionId = request.getRequestedSessionId();
		
		if(session == null || requestSessionId == null){
			return false;
		}
		return requestSessionId.equals(session.getId());
	}
	
	public static String getToken(HttpSession session){
		if(session == null){
			return null;
		}
		
		Object value = session.getAttribute(KEY);
		if(value != null){
			return value.toString();
		}
		
		return null;
	}
}
