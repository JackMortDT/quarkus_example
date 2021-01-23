package jack.service

import jack.command.PersonCommand
import spock.lang.Specification

class PersonServiceSpec extends Specification {

  PersonService personService
  def setup() { personService = new PersonServiceImpl() }

  Void "Test get people method"() {
    when: "the method is executed"
      List<PersonCommand> result = personService.getPeople()
    then:
      assert result.size() == 4
  }

}
