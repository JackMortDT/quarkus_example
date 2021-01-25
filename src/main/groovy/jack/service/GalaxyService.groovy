package jack.service

import jack.command.Film
import jack.command.Hero
import jack.enumerable.LightSaber

import javax.enterprise.context.ApplicationScoped
import java.time.LocalDate
import java.time.Month
import java.util.stream.Collectors

@ApplicationScoped
class GalaxyService {

  private List<Hero> heroes = []

  private List<Film> films = []

  GalaxyService() {

    Film aNewHope = new Film()
    aNewHope.title = "A New Hope"
    aNewHope.releaseDate = LocalDate.of(1977, Month.MAY, 25)
    aNewHope.episodeID = 4
    aNewHope.director = "George Lucas"

    Film theEmpireStrikesBack = new Film()
    theEmpireStrikesBack.title = "The Empire Strikes Back"
    theEmpireStrikesBack.releaseDate = LocalDate.of(1980, Month.MAY, 21)
    theEmpireStrikesBack.episodeID = 5
    theEmpireStrikesBack.director = "George Lucas"

    Film returnOfTheJedi = new Film()
    returnOfTheJedi.title = "Return Of The Jedi"
    returnOfTheJedi.releaseDate = LocalDate.of(1983, Month.MAY, 25)
    returnOfTheJedi.episodeID = 6
    returnOfTheJedi.director = "George Lucas"

    films << aNewHope
    films << theEmpireStrikesBack
    films << returnOfTheJedi

    Hero luke = new Hero()
    luke.name = "Luke"
    luke.surname = "Skywalker"
    luke.height = 1.7
    luke.mass = 73
    luke.lightSaber = LightSaber.GREEN
    luke.darkSide = false
    luke.episodeIds = [4, 5, 6]

    Hero leia = new Hero()
    leia.name = "Leia"
    leia.surname = "Organa"
    leia.height = 1.5
    leia.mass = 51
    leia.darkSide = false
    leia.episodeIds = [4, 5, 6]

    Hero vader = new Hero()
    vader.name = "Darth"
    vader.surname = "Vader"
    vader.height = 1.9
    vader.mass = 89
    vader.darkSide = true
    vader.lightSaber = LightSaber.RED
    vader.episodeIds = [4, 5, 6]

    heroes << luke
    heroes << leia
    heroes << vader

  }

  List<Film> getAllFilms() {
    return films;
  }

  Film getFilm(Integer id) {
    return films.get(id)
  }

  List<Hero> getHeroesByFilm(Film film) {
    return heroes.stream()
        .filter(hero -> hero.getEpisodeIds().contains(film.getEpisodeID()))
        .collect(Collectors.toList())
  }

  void addHero(Hero hero) {
    heroes.add(hero)
  }

  Hero deleteHero(Integer id) {
    return heroes.remove(id)
  }

  List<Hero> getHeroesBySurname(String surname) {
    return heroes.stream()
        .filter(hero -> hero.getSurname().equals(surname))
        .collect(Collectors.toList())
  }

}