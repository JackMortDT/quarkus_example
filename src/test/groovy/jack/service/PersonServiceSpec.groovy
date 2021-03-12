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
      List<Person> people = personService.getPeople()
    then:
      1 * personRepository.list() >> getPeople()
      assert people.size() == 4
  }

  static List<Person> getPeople() {
    [
        new Person(id: 1, name: "Jack", lastName: "Mort", age: 10),
        new Person(id: 2, name: "Luis", lastName: "Sastré", age: 24),
        new Person(id: 3, name: "José", lastName: "Cruz", age: 25),
        new Person(id: 4, name: "Jack", lastName: "Mort", age: 25)
    ]
  }

}
