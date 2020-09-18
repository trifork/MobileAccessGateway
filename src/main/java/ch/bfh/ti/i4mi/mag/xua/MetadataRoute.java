package ch.bfh.ti.i4mi.mag.xua;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MetadataRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
									
		from("servlet://metadata?matchOnUriPrefix=true").routeId("metadataTest")			
	    .bean(MetadataHandler.class);
	}

}
