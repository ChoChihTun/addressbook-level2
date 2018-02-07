package seedu.addressbook.ui;

import seedu.addressbook.commands.CommandResult;

import java.util.List;

import static seedu.addressbook.common.Messages.*;

public class Formatter {

    /**
     * A decorative prefix added to the beginning of lines printed by AddressBook
     */
    private static final String LINE_PREFIX = "|| ";

    /**
     * A platform independent line separator.
     */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /**
     * Format of indexed list item
     */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /**
     * A message prompting the user to input command
     */
    private static final String MESSAGE_PROMPT_COMMAND = LINE_PREFIX + "Enter command: ";

    /**
     * A message displaying the command entered by user
     */
    private static final String MESSAGE_COMMAND_ENTERED = "[Command entered:%1$s]";


    /**
     * Offset required to convert between 1-indexing and 0-indexing.
     */
    public static final int DISPLAYED_INDEX_OFFSET = 1;


    public static String getFeedbackToUser(CommandResult result) {
        return result.feedbackToUser + "\n" + DIVIDER;
    }

    public static String getWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        String message = DIVIDER + "\n"
                + DIVIDER + "\n"
                + MESSAGE_WELCOME +"\n"
                + version + "\n"
                + MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE + "\n"
                + storageFileInfo + "\n"
                + DIVIDER;
        return message;
    }

    public static String getInitFailedMessage() {
        String message = MESSAGE_INIT_FAILED + "\n" + DIVIDER + "\n" + DIVIDER;
        return message;
    }

    public static String getGoodbyeMessage() {
        String message = MESSAGE_GOODBYE + "\n" + DIVIDER + "\n" + DIVIDER;
        return message;
    }

    public static String getCommandPrompt() {
        return MESSAGE_PROMPT_COMMAND;
    }

    public static String getCommandEnteredMessage(String fullInputLine) {
        return String.format(MESSAGE_COMMAND_ENTERED, fullInputLine);
    }

    public static String getOutputMessage(String message) {
        String outputMessage = LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
        return outputMessage;
    }

    /**
     * Formats a list of strings as a viewable indexed list.
     */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}

