
public class TextUI implements WeatherStationUI {

    public TextUI() {

    }

    @Override
    public void update(int reading) {
        for (MeasurementUnit unit : MeasurementUnit.values()) {
            double temperature = unit.get(reading);

            System.out.printf("%s: %6.2f\n", unit.name(), temperature);
        }
    }

}