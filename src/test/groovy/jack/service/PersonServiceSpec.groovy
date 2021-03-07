package jack.service

import jack.command.PersonCommand
import jack.repository.PersonRepository
import spock.lang.Specification

class PersonServiceSpec extends Specification {

  PersonService personService
  PersonRepository personRepository

  def setup() {
    personService = new PersonServiceImpl()
    personRepository = new PersonRepository()
    personService.personRepository = personRepository
  }

  Void "Test get people method"() {
    when: "the method is executed"
      List<PersonCommand> result = personService.getPeople()
    then:
      assert result.size() == 4
  }

}
