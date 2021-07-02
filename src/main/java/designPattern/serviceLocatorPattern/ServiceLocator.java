package designPattern.serviceLocatorPattern;

public class ServiceLocator {

    private static JndiCache cache;

    static {
        cache = new JndiCache();
    }

    public static JndiService getService(String jndiName){

        JndiService service = cache.getService(jndiName);

        if(service != null){
            return service;
        }

        InitialContext context = new InitialContext();
        service = (JndiService)context.lookup(jndiName);
        cache.addService(service);
        return service;
    }
}
