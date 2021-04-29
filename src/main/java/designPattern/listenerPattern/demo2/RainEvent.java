package designPattern.listenerPattern.demo2;

public class RainEvent implements WeatherEvent {
    @Override
    public String getWeather() {
        return "Rain";
    }
}
