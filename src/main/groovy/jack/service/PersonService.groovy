package jack.service

import jack.command.PersonCommand
import jack.domain.Person

interface PersonService {

  List<PersonCommand> getPeople()
  PersonCommand getPersonByName(String name)
  PersonCommand saveNewDeveloper(Person person)

}
