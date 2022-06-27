/**
 * A class that represents a measurement in feet and inches. The measurement
 * should be _well-formed_, that is, the number of inches should not be >= 12.
 */
public class Measurement {
    private int feet;
    private int inches;

    /**
     * Constructor: initialize this object to be a measurement of 0 feet, 0
     * inches
     */
    public Measurement() {

    }

    /**
     * Constructor: takes a number of feet as its single argument, using 0 as
     * the number of inches
     */
    public Measurement(int feet) {
        this.feet = feet;
    }

    /**
     * Constructor: takes the number of feet in the measurement and the number
     * of inches as arguments (in that order), and does the appropriate
     * initialization
     */
    public Measurement(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

    /**
     * Returns the number of feet in this Measurement. For example, if the
     * Measurement has 1 foot and 6 inches, this method should return 1.
     */
    public int getFeet() {
//        return 0; // provided to allow the file to compile
        return feet;
    }

    /**
     * Returns the number of inches in this Measurement. For example, if the
     * Measurement has 1 foot and 6 inches, this method should return 6.
     */
    public int getInches() {
//        return 0; // provided to allow the file to compile
        return inches;
    }

    /**
     * Adds the argument m2 to the current measurement.
     *
     * @param m2 - Measurement to add. Should not change.
     * @return a new Measurement containing the sum of this and m2.
     */
    public Measurement plus(Measurement m2) {
        this.feet = this.feet + m2.getFeet();
        this.inches = this.inches + m2.getInches();
        for (int i = 0; this.inches >= 12; i++) {
            this.feet ++;
            this.inches = this.inches - 12;
        }
        Measurement newMeasure = new Measurement(this.feet, this.inches);
        return newMeasure; // provided to allow the file to compile
    }

    /**
     * Subtracts the argument m2 from the current measurement. You may assume
     * that m2 will always be smaller than the current measurement.
     *
     * @param m2 - Measurement to subtract. Should not change.
     * @return a new Measurement containing the difference of this and m2.
     */
    public Measurement minus(Measurement m2) {
        int x = this.feet * 12;
        int y = this.inches + x;
        int x2 = m2.getFeet() * 12;
        int y2 = m2.getInches() + x2;
        y = y - y2;
        this.feet = 0;
        this.inches = 0;
        for (int i = 0; y >= 12; i++) {
            this.feet ++;
            this.inches = y - 12;
            y = this.inches;
        }
        this.inches = y;

        Measurement minusMeasure = new Measurement(this.feet, this.inches);
        return minusMeasure; // provided to allow the file to compile
    }

    /**
     * Returns a new Measurement that is the current measurement multiplied by
     * n. For example, if this object represents a measurement of 7 inches,
     * this.multiple(3) should return an object that represents 1 foot,
     * 9 inches (which totals to 21 inches).
     *
     * The current measurement should not change.
     *
     * @param multipleAmount
     * @return a new Measurement containing this times multipleAmount
     */
    public Measurement multiple(int multipleAmount) {
        int tempinch = 0;
        tempinch = this.feet * 12 + this.inches;
        this.inches = multipleAmount * tempinch;
        this.feet = 0;
        for (int i = 0; this.inches >= 12; i++) {
            this.feet ++;
            this.inches = this.inches - 12;
        }
        return new Measurement(this.feet, this.inches); // provided to allow the file to compile
    }

    /**
     * Returns the String representation of this object in the form:
     *      f'i"
     * In other words, th number of feet followed by a single quote followed
     * by the number of inches less than 12 followed by a double quote (with no
     * blanks).
     *
     * For example, 0 foot 2 inches is formatted as 0'2"
     */
    @Override
    public String toString() {
//        return ""; // provided to allow the file to compile
        return this.feet + "\'" +  this.inches + "\"";
    }

}