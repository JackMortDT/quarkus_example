package jack.controller

import jack.domain.Person
import jack.service.PersonService

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/people")
class PeopleController {

  PersonService personService

  PeopleController(PersonService personService) {
    this.personService = personService
  }

  @GET
  @Path("/developers")
  @Produces(MediaType.APPLICATION_JSON)
  List<Person> getPeople() {
    personService.getPeople()
  }

  @GET
  @Path("/developers/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  List<Person> getPeopleByName(@PathParam("name") String name) {
    personService.getPeopleByName(name)
  }

  @GET
  @Path("/developers_greater_than")
  @Produces(MediaType.APPLICATION_JSON)
  List<Person> getPeopleByAgeGreaterThan(@QueryParam("age") Integer age) {
    personService.findAllByAgeGreaterThan(age)
  }

}
