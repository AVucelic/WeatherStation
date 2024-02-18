import java.util.EnumMap;

/**
 * Class for a simple computer based weather station that reports the current
 * temperature (in Celsius) every second. The station is attached to a sensor
 * that reports the temperature as a 16-bit number (0 to 65535) representing the
 * Kelvin temperature to the nearest 1/100th of a degree.
 *
 * This class is implements Runnable so that it can be embedded in a Thread
 * which runs the periodic sensing.
 *
 * @author Michael J. Lutz
 * @author Kristina Marasovic
 * @version 1
 */
public class WeatherStation extends Subject implements Runnable {

    private final long PERIOD = 1000; // 1 sec = 1000 ms.

    private EnumMap<SensorType, Sensor> sensorMap = new EnumMap<>(SensorType.class);

    private EnumMap<MeasurementUnit, Double> readingMap = new EnumMap<>(MeasurementUnit.class);

    /*
     * When a WeatherStation object is created, it in turn creates the sensor
     * object it will use.
     */
    public WeatherStation() {

        for (SensorType sensorType : SensorType.values()) {
            Sensor sensor;
            switch (sensorType) {
                case TEMPERATURE:
                    sensor = new TemperatureSensor();
                    break;
                case PRESSURE:
                    sensor = new PressureSensor();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported sensor type: " + sensorType);
            }
            sensorMap.put(sensorType, sensor);
        }
    }

    /*
     * The "run" method called by the enclosing Thread object when started.
     * Repeatedly sleeps a second, acquires the current temperature from
     * its sensor, and reports this as a formatted output string.
     */
    public void run() {

        while (true) {
            this.getSensorReadings();
            super.notifyObservers();

            /*
             * System.out.printf prints formatted data on the output screen.
             *
             * Most characters print as themselves.
             *
             * % introduces a format command that usually applies to the
             * next argument of printf:
             * * %6.2f formats the "celsius" (2nd) argument in a field
             * at least 6 characters wide with 2 fractional digits.
             * * The %n at the end of the string forces a new line
             * of output.
             * * %% represents a literal percent character.
             *
             * See docs.oracle.com/javase/tutorial/java/data/numberformat.html
             * for more information on formatting output.
             */
            // System.out.printf("Reading is%6.2f degrees C and %6.2f degrees K%n",
            // TemperatureUnit.CELSIUS.get(reading),
            // TemperatureUnit.KELVIN.get(reading));
            try {
                Thread.sleep(PERIOD);
            } catch (Exception e) {
            }
        }
    }

    private void getSensorReadings() {
        Sensor sensor = null;
        int reading = 0;
        for (SensorType type : SensorType.values()) {
            sensor = sensorMap.get(type);
            reading = sensor.read();
            for (MeasurementUnit unit : MeasurementUnit.valuesOf(type)) {
                readingMap.put(unit, unit.get(reading));
            }
        }
    }

    public double getReading(MeasurementUnit mu) {
        return readingMap.get(mu);
    }
}
