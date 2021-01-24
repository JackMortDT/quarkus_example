package jack.command

import jack.domain.Person

class PersonCommand {

  Long id
  String name
  String lastName
  Integer age

  static PersonCommand toPersonCommand(Person person) {
    new PersonCommand(
        id: person.id,
        name: person.name,
        lastName: person.lastName,
        age: person.age
    )
  }

}
