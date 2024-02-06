/*
 * Initial Author
 *      Michael J. Lutz
 *
 * Other Contributers
 *
 * Acknowledgements
 */

/*
 * Swing UI class used for displaying the information from the
 * associated weather station object.
 * This is an extension of JFrame, the outermost container in
 * a Swing application.
 */

import java.awt.Font;
import java.awt.GridLayout;
import java.util.EnumMap;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import java.text.DecimalFormat ;

public class SwingUI extends JFrame implements WeatherStationUI{
    TemperatureSensor sensor = new TemperatureSensor();
    private EnumMap<TemperatureUnit, JLabel> jLabelMap;

    /*
     * A Font object contains information on the font to be used to
     * render text.
     */
    private static Font labelFont = new Font(Font.SERIF, Font.PLAIN, 72);

    /*
     * Create and populate the SwingUI JFrame with panels and labels to
     * show the temperatures.
     */
    public SwingUI() {
        super("Weather Station");

        // Initialize the EnumMap
        jLabelMap = new EnumMap<>(TemperatureUnit.class);

        /*
         * WeatherStation frame is a grid of 1 row by an indefinite
         * number of columns.
         */
        this.setLayout(new GridLayout(1, 0));

        /*
         * There are two panels, one each for Kelvin and Celsius, added to the
         * frame. Each Panel is a 2 row by 1 column grid, with the temperature
         * name in the first row and the temperature itself in the second row.
         */
        // JPanel panel;

        /*
         * Set up Kelvin display.
         */
        // panel = new JPanel(new GridLayout(2, 1));
        // this.add(panel);
        // createLabel(" Kelvin ", panel);
        // kelvinField = createLabel("", panel);

        // /*
        // * Set up Celsius display.
        // */
        // panel = new JPanel(new GridLayout(2, 1));
        // this.add(panel);
        // createLabel(" Celsius ", panel);
        // celsiusField = createLabel("", panel);

        /**
         * For loop to iterate through all units and values of units, in a way that it
         * is not hardcoded
         */
        JPanel panel = null;
        JLabel label = null;
        TemperatureSensor sensor = new TemperatureSensor();

       /* for (TemperatureUnit unit : TemperatureUnit.values()) {
            double value = unit.get(sensor.read());
            panel = createPanel(unit);
            label = createLabel(unit.name(), panel);
            jLabelMap.put(unit, label);
            setJLabel(unit, unit.get(value));
            label.setFont(new Font(Font.SERIF, Font.PLAIN, 72));
            this.add(panel, label);
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    double temperatue = sensor.read();
                    for (TemperatureUnit unit : TemperatureUnit.values()) {
                        double value = unit.get(temperatue);
                        setJLabel(unit, value);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
        /*
         * Set up the frame's default close operation pack its elements,
         * and make the frame visible.
         */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    } 

    /*
     * Set the label holding the Kelvin temperature.
     */
    // public void setKelvinJLabel(double temperature) {
    // kelvinField.setText(String.format("%6.2f", temperature));
    // }

    // // /*
    // // * Set the label holding the Celsius temperature.
    // // */
    // public void setCelsiusJLabel(double temperature) {
    // celsiusField.setText(String.format("%6.2f", temperature));
    // }

    /**
     * Method to add a label
     * 
     * @param unit  - temperature unit
     * @param value - temperatue unit value
     */
    private void setJLabel(TemperatureUnit unit, double value) {
        jLabelMap.get(unit).setText(String.format("%6.2f", value));
    }

    /**
     * Method to create panels without hard-coding
     * 
     * @param unit - gets the kind of a unit
     * @return panel
     */
    private JPanel createPanel(TemperatureUnit unit) {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        createLabel(unit.name(), panel);
        return panel;
    }

    /*
     * Create a Label with the initial value <title>, place it in
     * the specified <panel>, and return a reference to the Label
     * in case the caller wants to remember it.
     */
    private JLabel createLabel(String title, JPanel panel) {
        JLabel label = new JLabel(title);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setFont(labelFont);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(label);
        return label;
    }

        /**
     * Update values for the AWTUI interface
     * 
     * @param reading - the value for the sensor that is currently reading
     */
    @Override
    public void update(int reading) {
        for (TemperatureUnit unit : TemperatureUnit.values()) {
            setJLabel( unit, unit.get(reading));
        }
    }

    public static void main(String[] args) {
        SwingUI swing = new SwingUI();

    }
}
