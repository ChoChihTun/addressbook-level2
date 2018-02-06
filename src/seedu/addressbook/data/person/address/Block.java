package seedu.addressbook.data.person.address;

/**
 * Represents the block detail of the whole address
 */
public class Block {
    public String block;

    public Block() {
        this.block = "";
    }

    public String getBlock() {
        return block;
    }

    public void inputBlock(String block) {
        this.block = block;
    }
}
