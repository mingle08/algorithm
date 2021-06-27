package jdk.javaSpi;

public class PrintServiceImpl implements PrintService {
    @Override
    public void printInfo() {
        System.out.println("hello world");
    }
}
