package jack.controller

import jack.command.PersonCommand
import jack.domain.Person
import jack.service.PersonService

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class PersonController {

  PersonService personService

  PersonController(PersonService personService) {
    this.personService = personService
  }

  @GET
  @Path("/developer_by_name/{name}")
  Person getPersonByName(@PathParam("name") String name) {
    personService.getPersonByName(name)
  }

  @POST
  @Path("/developers")
  @Consumes(MediaType.APPLICATION_JSON)
  Response saveNewDeveloper(PersonCommand person) {
    personService.saveNewDeveloper(person)
    Response.ok().build()
  }

}
