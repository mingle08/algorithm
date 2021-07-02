package designPattern.serviceLocatorPattern;

import java.util.ArrayList;
import java.util.List;

public class JndiCache {

    private List<JndiService> services;

    public JndiCache() {
        services = new ArrayList<JndiService>();
    }

    public JndiService getService(String serviceName) {
        for (JndiService jndiService : services) {
            if (jndiService.getName().equalsIgnoreCase(serviceName)) {
                System.out.println("Returning cached  " + serviceName + " object");
                return jndiService;
            }
        }
        return null;
    }

    public void addService(JndiService newService) {
        boolean exists = false;
        for (JndiService jndiService : services) {
            if (jndiService.getName().equalsIgnoreCase(newService.getName())) {
                exists = true;
            }
        }
        if (!exists) {
            services.add(newService);
        }
    }
}
