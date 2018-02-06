package seedu.addressbook.data.person.address;

/**
 * Represents the unit detail of the address
 */
public class Unit {
    public String unit;

    /**
     * Initialises the unit with an empty string
     */
    public Unit() {
        this.unit = "";
    }

    /**
     * Returns the unit of the address
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Assigns string unit with the unit of the address
     * @param unit from the address
     */
    public void inputUnit(String unit) {
        this.unit = unit;
    }
}
