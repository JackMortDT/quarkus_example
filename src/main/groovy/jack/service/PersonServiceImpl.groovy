package jack.service

import jack.command.PersonCommand
import jack.domain.Person
import jack.repository.PersonRepository

import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton
class PersonServiceImpl implements PersonService {

  @Inject
  PersonRepository personRepository

  @Override
  @Transactional
  List<PersonCommand> getPeople() {
    List<Person> people = personRepository.list()
    people.collect() { PersonCommand.toPersonCommand(it) }
  }

  @Override
  @Transactional
  PersonCommand getPersonByName(String name) {
    Person person = personRepository.findByName(name)
    person ? PersonCommand.toPersonCommand(person) : null
  }

  @Override
  @Transactional
  List<PersonCommand> getPeopleByName(String name) {
    List<Person> people = personRepository.listByName(name)
    people.collect() { PersonCommand.toPersonCommand(it) }
  }

  @Override
  @Transactional
  PersonCommand saveNewDeveloper(Person person) {
    personRepository.persist(person)
  }

}
