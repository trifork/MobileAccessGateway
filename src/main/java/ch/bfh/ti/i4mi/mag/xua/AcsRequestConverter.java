package ch.bfh.ti.i4mi.mag.xua;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.camel.Header;

import com.onelogin.saml2.Auth;
import com.onelogin.saml2.exception.SettingsException;

public class AcsRequestConverter {

	public String handle(@Header("CamelHttpServletRequest") HttpServletRequest request, @Header("CamelHttpServletResponse") HttpServletResponse response) {
		try {
			Auth auth = new Auth("saml.properties", request, response);
			auth.processResponse();
			
			boolean isAuth = auth.isAuthenticated();
			
			return auth.getLastResponseXML();			
		} catch (SettingsException e) {
		
		} catch (com.onelogin.saml2.exception.Error e2) {
	
		} catch (Exception e3) {
    	
		}
		return "error";
	}
}
