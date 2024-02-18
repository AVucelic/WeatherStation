public class StatisticsDisplay implements Observer {

    private final WeatherStation station;

    public StatisticsDisplay(WeatherStation station) {
        this.station = station;
        this.station.attach(this);
    }

    // todo method
    @Override
    public void update() {

    }

}