package jack.endpoint

import jack.command.Film
import jack.command.Hero
import jack.service.GalaxyService
import org.eclipse.microprofile.graphql.DefaultValue
import org.eclipse.microprofile.graphql.Description
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Mutation
import org.eclipse.microprofile.graphql.Name
import org.eclipse.microprofile.graphql.Query
import org.eclipse.microprofile.graphql.Source

@GraphQLApi
class FilmEndpoint {

  GalaxyService galaxyService

  FilmEndpoint(GalaxyService galaxyService) {
    this.galaxyService = galaxyService
  }

  @Query("allFilms")
  @Description("Get all Films from a galaxy far far away")
  List<Film> getAllFilms() {
    galaxyService.getAllFilms()
  }

  @Query
  @Description("Get a film from a galaxy far far away")
  Film getFilm(@Name("filmId") Integer id) {
    galaxyService.getFilm(id)
  }

  List<Hero> heroes(@Source Film film) {
    galaxyService.getHeroesByFilm(film)
  }

  @Mutation
  Hero createHero(Hero hero) {
    galaxyService.addHero(hero)
  }

  @Mutation
  Hero deleteHero(Integer id) {
    galaxyService.deleteHero(id)
  }

  @Query
  List<Hero> getHeroesWithSurname(@DefaultValue("Skywalker") String surname) {
    galaxyService.getHeroesBySurname(surname)
  }

}
