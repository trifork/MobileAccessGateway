package ch.bfh.ti.i4mi.mag.xua;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.camel.Header;

import com.onelogin.saml2.Auth;
import com.onelogin.saml2.exception.SettingsException;

public class LoginRequestHandler {

	public void handle(@Header("CamelHttpServletRequest") HttpServletRequest request, @Header("CamelHttpServletResponse") HttpServletResponse response) {
		try {
		   Auth auth = new Auth("saml.properties", request, response);		
		   auth.login();
	    } catch (SettingsException e) {
					
	    } catch (com.onelogin.saml2.exception.Error e2) {
		
	    } catch (IOException e3) {
	    	
	    }
	}
}
