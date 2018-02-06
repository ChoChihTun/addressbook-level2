package seedu.addressbook.data.person.address;

/**
 * Represents the unit detail of the address
 */
public class Unit {
    public String unit;

    public Unit() {
        this.unit = "";
    }

    public String getUnit() {
        return unit;
    }

    public void inputUnit(String unit) {
        this.unit = unit;
    }
}
