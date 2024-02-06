import java.util.EnumMap;

public class TextUI implements WeatherStationUI {

    private EnumMap<TemperatureUnit, Double> temperatureMap;

    public TextUI() {
        temperatureMap = new EnumMap<>(TemperatureUnit.class);
    }

    @Override
    public void update(int reading) {
        for (TemperatureUnit unit : TemperatureUnit.values()) {
            double temperature = unit.get(reading);
            temperatureMap.put(unit, temperature);
            System.out.printf("%s: %6.2f\n", unit.name(), temperature);
        }
    }
}