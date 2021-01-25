package jack.repository

import io.quarkus.hibernate.orm.panache.PanacheRepository
import jack.domain.Person

import javax.inject.Singleton

@Singleton
class PersonRepository implements PanacheRepository<Person> {

  Person findByName(String name) {
    find("name", name).firstResult()
  }

  List<Person> listByName(String name) {
    list("name", name)
  }

  List<Person> list() {
    listAll()
  }
}
