package seedu.addressbook.data.person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import seedu.addressbook.common.Utils;
import seedu.addressbook.data.exception.DuplicateDataException;
import seedu.addressbook.data.exception.IllegalValueException;


/**
 * A list of persons. Does not allow null elements or duplicates.
 *
 * @see Person#equals(Object)
 * @see Utils#elementsAreUnique(Collection)
 */
public class UniquePersonList implements Iterable<Person> {

    /**
     * Signals that an operation would have violated the 'no duplicates' property of the list.
     */
    public static class DuplicatePersonException extends DuplicateDataException {
        protected DuplicatePersonException() {
            super("Operation would result in duplicate persons");
        }
    }

    /**
     * Signals that an operation targeting a specified person in the list would fail because
     * there is no such matching person in the list.
     */
    public static class PersonNotFoundException extends Exception {}

    private final List<Person> internalList = new ArrayList<>();

    private static final String PERSON_DETAIL_NAME = "name";
    private static final String PERSON_DETAIL_EMAIL = "email";
    private static final String PERSON_DETAIL_PHONE = "phone";
    private static final String PERSON_DETAIL_ADDRESS = "address";

    /**
     * Constructs empty person list.
     */
    public UniquePersonList() {}

    /**
     * Constructs a person list with the given persons.
     */
    public UniquePersonList(Person... persons) throws DuplicatePersonException {
        final List<Person> initialTags = Arrays.asList(persons);
        if (!Utils.elementsAreUnique(initialTags)) {
            throw new DuplicatePersonException();
        }
        internalList.addAll(initialTags);
    }

    /**
     * Constructs a list from the items in the given collection.
     * @param persons a collection of persons
     * @throws DuplicatePersonException if the {@code persons} contains duplicate persons
     */
    public UniquePersonList(Collection<Person> persons) throws DuplicatePersonException {
        if (!Utils.elementsAreUnique(persons)) {
            throw new DuplicatePersonException();
        }
        internalList.addAll(persons);
    }

    /**
     * Constructs a shallow copy of the list.
     */
    public UniquePersonList(UniquePersonList source) {
        internalList.addAll(source.internalList);
    }

    /**
     * Returns an unmodifiable java List view with elements cast as immutable {@link ReadOnlyPerson}s.
     * For use with other methods/libraries.
     * Any changes to the internal list/elements are immediately visible in the returned list.
     */
    public List<ReadOnlyPerson> immutableListView() {
        return Collections.unmodifiableList(internalList);
    }


    /**
     * Checks if the list contains an equivalent person as the given argument.
     * The {@link ReadOnlyPerson#isSamePerson} method is used for this comparison, which
     * defines a weaker notion of equality.
     */
    public boolean contains(ReadOnlyPerson toCheck) {
        for (Person p : internalList) {
            if (p.isSamePerson(toCheck)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a person to the list.
     *
     * @throws DuplicatePersonException if the person to add is a duplicate of an existing person in the list.
     *    The @link{ReadOnlyPerson#isSamePerson} method is used for this comparison,
     *    which defines a weaker notion of equality.
     */
    public void add(Person toAdd) throws DuplicatePersonException {
        if (contains(toAdd)) {
            throw new DuplicatePersonException();
        }
        internalList.add(toAdd);
    }

    /**
     * Removes the equivalent person from the list.
     *
     * @throws PersonNotFoundException if no such person could be found in the list.
     */
    public void remove(ReadOnlyPerson toRemove) throws PersonNotFoundException {
        final boolean personFoundAndDeleted = internalList.remove(toRemove);
        if (!personFoundAndDeleted) {
            throw new PersonNotFoundException();
        }
    }

    /**
     * Replaces a person's target detail with the new detail.
     *
     * @param toEdit person whose detail is to be edited
     * @param detail to be replaced
     * @param newDetail replaces the current detail
     *
     * @throws PersonNotFoundException if no such person could be found in the list.
     * @throws IllegalValueException if new detail string provided is invalid.
     */
    public void edit(Person toEdit, String detail, String newDetail)
            throws PersonNotFoundException, IllegalValueException {
        if (!internalList.contains(toEdit)) {
            throw new PersonNotFoundException();
        }
        switch (detail) {
            case PERSON_DETAIL_NAME:
                toEdit.setName(newDetail);
                break;
            case PERSON_DETAIL_EMAIL:
                toEdit.setEmail(newDetail);
                break;
            case PERSON_DETAIL_PHONE:
                toEdit.setPhone(newDetail);
                break;
            case PERSON_DETAIL_ADDRESS:
                toEdit.setAddress(newDetail);
                break;
        }
    }

    /**
     * Clears all persons in list.
     */
    public void clear() {
        internalList.clear();
    }

    @Override
    public Iterator<Person> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniquePersonList // instanceof handles nulls
                        && this.internalList.equals(((UniquePersonList) other).internalList));
    }
}
