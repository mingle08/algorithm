package IOCDemo1;

import org.junit.Test;

public class EasyIOCTest {
    @Test
    public void getBean() throws Exception {
        String location = EasyIOC.class.getClassLoader().getResource("ioc.xml").getFile();
        EasyIOC bf = new EasyIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println("wheel brand: " + wheel.getBrand());
        Car car = (Car) bf.getBean("car");
        System.out.println("car name:" + car.getName());
    }
}
