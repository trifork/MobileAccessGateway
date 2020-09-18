package ch.bfh.ti.i4mi.mag.xua;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class LoginRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
									
		from("servlet://login?matchOnUriPrefix=true").routeId("loginTest")			
	    .bean(LoginRequestHandler.class);
	}

}
