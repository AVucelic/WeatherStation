/*
 * Initial Author
 *      Michael J. Lutz
 *
 * Other Contributers
 *
 * Acknowledgements
 */

/*
 * AWT UI class used for displaying the information from the
 * associated weather station object.
 * This is an extension of JFrame, the outermost container in
 * a AWT application.
 */

import java.awt.*;
import java.awt.event.*;
import java.util.EnumMap;

public class AWTUI extends Frame {
    private Label celsiusField; // put current celsius reading here
    private Label kelvinField; // put current kelvin reading here
    public Panel panel;
    
    //store label values in this map
    private EnumMap<TemperatureUnit, Label> labelMap;

    /**
     * Returns the value of celsius readings
     * 
     * @return celsiusField
     */
    public Label getCelsiusField() {
        return celsiusField;
    }

    
    /**
     * Method that sets celsiusField to a new value
     * 
     * @param celsiusField
     */
    public void setCelsiusField(Label celsiusField) {
        this.celsiusField = celsiusField;
    }

    /**
     * Returns the value of kelvin readings
     * 
     * @return kelvinField
     */
    public Label getKelvinField() {
        return kelvinField;
    }

        /**
     * Method that sets kelvinField to a new value
     * 
     * @param kelvinField
     */
    public void setKelvinField(Label kelvinField) {
        this.kelvinField = kelvinField;
    }

    /*
     * A Font object contains information on the font to be used to
     * render text.
     */
    private static Font labelFont = new Font(Font.SERIF, Font.PLAIN, 72);

    /*
     * Create and populate the AWTUI JFrame with panels and labels to
     * show the temperatures.
     */
    public AWTUI() {
        super("Weather Station");
        //initializes map
        labelMap = new EnumMap<>(TemperatureUnit.class);

        /*
         * WeatherStation frame is a grid of 1 row by an indefinite number
         * of columns.
         */
        setLayout(new GridLayout(1, 0));

        /*
         * There are two panels, one each for Kelvin and Celsius, added to the
         * frame. Each Panel is a 2 row by 1 column grid, with the temperature
         * name in the first row and the temperature itself in the second row.
         */

        /*
         * Loop through the units on TemperatureUnit & Set up Kelvin & Celsius display.
         */
        for (TemperatureUnit unit : TemperatureUnit.values()) {
            panel = createPanel(unit);
            this.add(panel);
        }

        /*
         * Set up the window's default close operation and pack its elements.
         */
        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent windowEvent) {
                        System.exit(0);
                    }
                });

        /*
         * Pack the components in this frame and make the frame visible.
         */
        pack();
        setVisible(true);
    }

    /**
     * Sets the labels
     * @param unit
     * @param value
     */
    private void setLabelValues(TemperatureUnit unit, double value) {
        labelMap.get(unit).setText(String.format("%6.2f", value));
    }

    /***
     * Creates a Panel/ sets the label and
     * 
     * @param {TemperatureUnit} unit - The Type of Unit used for to show temperature
     * @return The panel that will be added to the view
     */
    public Panel createPanel(TemperatureUnit unit) {
        Panel panel = new Panel(new GridLayout(2, 1));
        setLabel(" " + unit + " ", panel);
        return panel;
    }

    /*
     * Create a Label with the initial value <title>, place it in
     * the specified <panel>, and return a reference to the Label
     * in case the caller wants to remember it.
     */
    private Label setLabel(String title, Panel panel) {
        Label label = new Label(title);

        label.setAlignment(Label.CENTER);
        label.setFont(labelFont);
        panel.add(label);

        return label;
    }

    public static void main(String[] args) {
        AWTUI a = new AWTUI();
    }
}
