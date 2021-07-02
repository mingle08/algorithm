package designPattern.serviceLocatorPattern;

public class AService implements JndiService {
    @Override
    public String getName() {
        return "AService";
    }

    @Override
    public void execute() {
        System.out.println("Executing AService");
    }
}
