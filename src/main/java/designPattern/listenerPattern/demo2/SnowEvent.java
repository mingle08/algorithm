package designPattern.listenerPattern.demo2;

public class SnowEvent implements WeatherEvent{
    @Override
    public String getWeather() {
        return "Snow";
    }
}
