package seedu.addressbook.data.person.address;

/**
 * Represents the postal code detail of the address
 */
public class PostalCode {
    public String postalCode;

    /**
     * Initialises postalCode with empty string
     */
    public PostalCode() {
        this.postalCode = "";
    }

    /**
     * Returns the postal code of the address
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Assigns string postalCode with the postal code of the address
     * @param postalCode from the address
     */
    public void inputPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
