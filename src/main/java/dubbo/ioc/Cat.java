package dubbo.ioc;

import com.alibaba.dubbo.common.URL;

public class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("I am a cat");
    }

    @Override
    public void speak(URL url) {
        System.out.println("I am cat cat cat");
    }
}
