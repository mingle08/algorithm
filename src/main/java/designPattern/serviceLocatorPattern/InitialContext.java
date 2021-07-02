package designPattern.serviceLocatorPattern;

public class InitialContext {
    public Object lookup(String jndiName){
        if(jndiName.equalsIgnoreCase("ASERVICE")){
            System.out.println("Looking up and creating a new AService object");
            return new AService();
        }else if (jndiName.equalsIgnoreCase("BSERVICE")){
            System.out.println("Looking up and creating a new BService object");
            return new BService();
        }
        return null;
    }
}
