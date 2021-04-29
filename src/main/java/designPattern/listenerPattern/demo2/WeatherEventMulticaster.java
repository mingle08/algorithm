package designPattern.listenerPattern.demo2;

import org.springframework.stereotype.Component;

@Component
public class WeatherEventMulticaster extends AbstractEventMulticaster{
    @Override
    void doStart() {
        System.out.println("广播开始");
    }

    @Override
    void doEnd() {
        System.out.println("广播结束");
    }
}
