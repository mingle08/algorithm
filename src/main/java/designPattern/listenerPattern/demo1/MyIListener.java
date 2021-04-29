package designPattern.listenerPattern.demo1;

public class MyIListener implements IListener {
    @Override
    public void onChange(Event event) {
        switch(event.getType()){
            case Event.INSTALLED:
                System.out.println("do install...");
                break;
            case Event.STARTED :
                System.out.println("do started...");
                break;
            case Event.RESOLVED :
                System.out.println("do resolved...");
                break;
            case Event.STOPPED :
                System.out.println("do stopped...");
                break;
            case Event.UNRESOLVED :
                System.out.println("do unresolved...");
                break;
            case Event.UNINSTALLED :
                System.out.println("do uninstalled...");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
