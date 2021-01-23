package jack.controller

import jack.command.PersonCommand
import jack.service.PersonService

import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/people")
class PeopleController {

  @Inject
  PersonService personService

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  List<PersonCommand> getPeople() {
    personService.getPeople()
  }
}
