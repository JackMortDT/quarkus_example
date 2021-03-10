package jack.command

import jack.domain.Person

class PersonCommand {

  String name
  String lastName
  Integer age

  static Person toPerson(PersonCommand person) {
    new Person(
        name: person.name,
        lastName: person.lastName,
        age: person.age
    )
  }

}
