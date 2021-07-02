package designPattern.serviceLocatorPattern;

public class BService implements JndiService {
    @Override
    public String getName() {
        return "BService";
    }

    @Override
    public void execute() {
        System.out.println("Executing BService");
    }
}
