package ch.bfh.ti.i4mi.mag.xua;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class AcsRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
									
		from("servlet://acs?matchOnUriPrefix=true").routeId("slsTest")			
	    .bean(AcsRequestConverter.class);
	}

}
