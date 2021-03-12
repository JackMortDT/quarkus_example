package jack.config

import io.quarkus.runtime.ShutdownEvent
import io.quarkus.runtime.StartupEvent
import org.jboss.logging.Logger

import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes
import javax.inject.Inject

@ApplicationScoped
class ApplicationLifeCycle {

  @Inject
  Logger log

  void onStart(@Observes StartupEvent event) {
    log.info("*****************************")
    log.info("Powered by Quarkus")
  }

  void onStop(@Observes ShutdownEvent event) {
    log.info("The application is stopping 🦎")
  }

}
