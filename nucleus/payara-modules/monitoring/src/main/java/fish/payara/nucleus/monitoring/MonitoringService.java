package fish.payara.nucleus.monitoring;

import jakarta.inject.Inject;
import org.glassfish.api.StartupRunLevel;
import org.glassfish.api.event.EventListener;
import org.glassfish.api.event.EventTypes;
import org.glassfish.hk2.runlevel.RunLevel;
import org.glassfish.internal.deployment.Deployment;
import org.jvnet.hk2.annotations.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Stian Sigvarten
 */
@Service(name = "monitoring-service")
@RunLevel(StartupRunLevel.VAL)
public class MonitoringService implements EventListener {

    @Override
    public void event(Event<?> event) {
        if (event.is(EventTypes.SERVER_STARTUP)) {
            logger.log(Level.SEVERE, "Monitoring service starting...");
        } else if (event.is(EventTypes.SERVER_SHUTDOWN)) {
            logger.log(Level.SEVERE, "Monitoring service stopping...");
        }
    }

    @Inject
    private Logger logger;
}
