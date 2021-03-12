package jack.service

import jack.command.PersonCommand
import jack.domain.Person
import jack.repository.PersonRepository
import org.jboss.logging.Logger

import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
class PersonServiceImpl implements PersonService {

  PersonRepository personRepository

  @Inject
  Logger log

  PersonServiceImpl(PersonRepository personRepository) {
    this.personRepository = personRepository
  }

  @Override
  @Transactional
  Person getPersonByName(String name) {
    personRepository.findByName(name)
  }

  @Override
  @Transactional
  List<Person> getPeople() {
    personRepository.list()
  }

  @Override
  @Transactional
  List<Person> getPeopleByName(String name) {
    personRepository.listByName(name)
  }

  @Override
  @Transactional
  List<Person> findAllByAgeGreaterThan(Integer age) {
    log.info("Edad: ${age}")
    println age
    personRepository.findAllByAgeGreaterThan(age)
  }

  @Override
  @Transactional
  Void saveNewDeveloper(PersonCommand person) {
    personRepository.persist(PersonCommand.toPerson(person))
  }

}
