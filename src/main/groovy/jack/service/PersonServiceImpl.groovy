package jack.service

import jack.command.PersonCommand
import javax.inject.Singleton

@Singleton
class PersonServiceImpl implements PersonService{

  List<PersonCommand> getPeople() {
    [new PersonCommand(name: "Luis", lastName: "Sastré", age: 24),
     new PersonCommand(name: "José", lastName: "Cruz", age: 25),
     new PersonCommand(name: "Eduardo", lastName: "Peralta", age: 24),
     new PersonCommand(name: "Rodrigo", lastName: "Martínez", age: 34)]
  }

}
