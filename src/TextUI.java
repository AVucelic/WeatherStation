
public class TextUI implements Observer {

    private final WeatherStation station;

    public TextUI(WeatherStation station) {
        this.station = station;
        this.station.attach(this);
    }

    @Override
    public void update() {
        for (MeasurementUnit unit : MeasurementUnit.values()) {
            double reading = station.getReading(unit);
            System.out.printf("%s: %6.2f\n", unit.name(), reading);
        }
    }

}