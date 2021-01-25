package jack.controller

import jack.command.PersonCommand
import jack.domain.Person
import jack.service.PersonService

import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/people")
class PeopleController {

  @Inject
  PersonService personService
  @Inject

  @GET
  @Path("/developers")
  @Produces(MediaType.APPLICATION_JSON)
  List<PersonCommand> getPeople() {
    personService.getPeople()
  }

  @GET
  @Path("/developers/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  List<PersonCommand> getPeopleByName(@PathParam("name") String name) {
    personService.getPeopleByName(name)
  }

  @POST
  @Path("/developers")
  @Consumes(MediaType.APPLICATION_JSON)
  Response saveNewDeveloper(Person person) {
    personService.saveNewDeveloper(person)
    Response.ok().build()
  }

}
