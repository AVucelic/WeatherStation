import java.util.EnumMap;

public class TextUI implements WeatherStationUI {

   

    public TextUI() {

    }

    @Override
    public void update(int reading) {
        for (TemperatureUnit unit : TemperatureUnit.values()) {
            double temperature = unit.get(reading);

            System.out.printf("%s: %6.2f\n", unit.name(), temperature);
        }
    }

}