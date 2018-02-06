package seedu.addressbook.data.person.address;

/**
 * Represents the postal code detail of the address
 */
public class PostalCode {
    public String postalCode;

    public PostalCode() {
        this.postalCode = "";

    }

    public String getPostalCode() {
        return postalCode;
    }

    public void inputPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
