package seedu.addressbook.data.person;


public class Contact {

    /**
     * Returns true if the given string is a valid person property.
     */
    public static boolean isValidProperty(String test, String PROPERTY_VALIDATION_REGEX) {
        return test.matches(PROPERTY_VALIDATION_REGEX);
    }

    public String toString(String value) {
        return value;
    }

    public boolean equals(Object other, String value) {
        return other == this // short circuit if same object
                || (other instanceof Phone // instanceof handles nulls
                && value.equals(((Phone) other).value)); // state check
    }

    public int hashCode(String value) {
        return value.hashCode();
    }

    public boolean isPrivate(boolean isPrivate) {
        return isPrivate;
    }
}
