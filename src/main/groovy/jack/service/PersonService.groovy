package jack.service

import jack.command.PersonCommand
import jack.domain.Person

interface PersonService {

  Person getPersonByName(String name)

  List<Person> getPeople()
  List<Person> getPeopleByName(String name)
  List<Person> findAllByAgeGreaterThan(Integer age)

  Void saveNewDeveloper(PersonCommand person)


}