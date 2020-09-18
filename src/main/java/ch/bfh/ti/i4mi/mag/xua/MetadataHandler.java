package ch.bfh.ti.i4mi.mag.xua;

import java.io.PrintWriter;
import java.security.cert.CertificateEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.camel.Header;

import com.onelogin.saml2.Auth;
import com.onelogin.saml2.exception.SettingsException;
import com.onelogin.saml2.settings.Saml2Settings;

public class MetadataHandler {

	public void handle(@Header("CamelHttpServletRequest") HttpServletRequest request, @Header("CamelHttpServletResponse") HttpServletResponse response) {
		try {
			Auth auth = new Auth("saml.properties");
			Saml2Settings settings = auth.getSettings();
			settings.setSPValidationOnly(true);
			String metadata = settings.getSPMetadata();
			List<String> errors = Saml2Settings.validateMetadata(metadata);
			response.setContentType("text/xml");
			PrintWriter out = new PrintWriter(response.getWriter());
			if (errors.isEmpty()) {
				out.println(metadata);
				out.close();
			} else {
				response.setContentType("text/html; charset=UTF-8");
	
				for (String error : errors) {
				    out.println(error);
				}
			}	
		
		} catch (SettingsException e) {
						
		} catch (com.onelogin.saml2.exception.Error e2) {
			
		} catch (CertificateEncodingException e) {
			
		} catch (Exception e) {
					
		}
	}
}
