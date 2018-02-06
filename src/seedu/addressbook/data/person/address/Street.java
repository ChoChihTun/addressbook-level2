package seedu.addressbook.data.person.address;

/**
 * Represents the street detail of the address
 */
public class Street {
    public String street;

    /**
     * Initialises street with an empty string
     */
    public Street() {
        this.street = "";
    }

    /**
     * Returns the street of the address
     */
    public String getStreet() {
        return street;
    }

    /**
     * Assigns string street with the street of the address
     * @param street from the address
     */
    public void inputStreet(String street) {
        this.street = street;
    }
}
