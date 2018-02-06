package seedu.addressbook.data.person.address;

/**
 * Represents the block detail of the whole address
 */
public class Block {
    public String block;

    /**
     * Initialises block with empty string
     */
    public Block() {
        this.block = "";
    }

    /**
     * Returns the block of the address
     */
    public String getBlock() {
        return block;
    }

    /**
     * Assigns string block with the block of the address
     *
     * @param block from the address
     */
    public void inputBlock(String block) {
        this.block = block;
    }
}
