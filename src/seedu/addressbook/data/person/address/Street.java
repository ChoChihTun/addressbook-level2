package seedu.addressbook.data.person.address;

/**
 * Represents the street detail of the address
 */
public class Street {
    public String street;

    public Street() {
        this.street = "";
    }

    public String getStreet() {
        return street;
    }

    public void inputStreet(String street) {
        this.street = street;
    }
}
