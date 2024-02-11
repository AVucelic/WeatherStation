import java.util.EnumMap;

public class TextUI implements WeatherStationUI {

    public TextUI() {

    }

    @Override
    public void update(EnumMap<MeasurementUnit, Double> enumMap) {
        for (MeasurementUnit unit : MeasurementUnit.values()) {
            double reading = enumMap.get(unit);

            System.out.printf("%s: %6.2f\n", unit.name(), reading);
        }
    }

}