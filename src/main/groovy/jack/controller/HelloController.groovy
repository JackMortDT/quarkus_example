package jack.controller

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class HelloController {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  String hello() {
    "Hello Controller"
  }

}
