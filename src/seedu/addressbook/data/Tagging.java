package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

/**
 * Represents the event whereby a person has a tag being added or subtracted from him
 */
public class Tagging {

    private static final String ADD_SYMBOL = "+";
    private static final String SUBTRACT_SYMBOL = "-";

    private Person person;
    private Tag tag;
    private String operation;

    public Tagging(Person person, Tag tag, String operation) {
        this.person = person;
        this.tag = tag;
        this.operation = operation;
    }

    @Override
    public String toString() {
        String result = "";
        switch(operation) {
            case ADD_SYMBOL:
                result = ADD_SYMBOL + " " + person.getName().toString() + " " + tag.toString();
                break;
            case SUBTRACT_SYMBOL:
                result = SUBTRACT_SYMBOL + " " + person.getName().toString() + " " + tag.toString();
                break;
        }
        return result;
    }

}
