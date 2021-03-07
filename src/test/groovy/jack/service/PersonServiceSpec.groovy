package jack.service

import io.quarkus.test.junit.QuarkusTest
import jack.command.PersonCommand
import jack.domain.Person
import jack.repository.PersonRepository
import spock.lang.Specification

@QuarkusTest
class PersonServiceSpec extends Specification {

  PersonService personService

  def setup() {
    personService = new PersonServiceImpl()
  }

  Void "Test get people method"() {
    given:
      def personRepository = Mock(PersonRepository)
      personService.personRepository = personRepository
    when: "the method is executed"
      List<PersonCommand> result = personService.getPeople()
    then:
      1 * personRepository.list() >> people()
      assert result.size() == 4
  }

  List<Person> people() {
    [
        new Person(id: 1, name: "Jack", lastName: "Mort", age: 10),
        new Person(id: 1, name: "Luis", lastName: "Sastré", age: 24),
        new Person(id: 1, name: "José", lastName: "Cruz", age: 25),
        new Person(id: 1, name: "Jack", lastName: "Mort", age: 25)
    ]
  }

}
