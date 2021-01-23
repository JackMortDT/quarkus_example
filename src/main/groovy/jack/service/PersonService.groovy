package jack.service

import jack.command.PersonCommand

interface PersonService {

  List<PersonCommand> getPeople()

}
