package ch.bfh.ti.i4mi.mag.xua;

import org.apache.camel.builder.RouteBuilder;
/*import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;*/

//@Component
//@Configuration
public class TestRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
									
		//from("cxfrs://test?providers=redirectGetFilter").routeId("test");			
	   
	}
	
	//@Bean("redirectGetFilter")
	/*public org.apache.cxf.rs.security.saml.sso.SamlRedirectBindingFilter redirectGetFilter() {
		org.apache.cxf.rs.security.saml.sso.SamlRedirectBindingFilter result = new org.apache.cxf.rs.security.saml.sso.SamlRedirectBindingFilter();
		result.setIdpServiceAddress("https://ehealthsuisse.ihe-europe.net:4443/idp/profile/SAML2");///Redirect/SSO");
		result.setAssertionConsumerServiceAddress("/Redirect/SSO");
		//<property name="stateProvider" ref="stateManager"/>	
		return result;		
	}*/
    


/*<bean id="stateManager" class="org.apache.cxf.rs.security.saml.sso.state.EHCacheSPStateManager">
  <constructor-arg ref="cxf"/>
</bean>*/

}