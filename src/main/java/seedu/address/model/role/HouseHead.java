package seedu.address.model.role;

import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Group;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.privilege.Privilege;
import seedu.address.model.tag.Tag;

/**
 * HouseHead for FOP.
 */
public class HouseHead extends Participant {


    /**
     * Every field must be present and not null.
     *
     * @param name
     * @param phone
     * @param email
     * @param address
     * @param group
     * @param tags
     */
    public HouseHead(Name name, Phone phone, Email email, Address address, Group group, Set<Tag> tags) {
        super(name, phone, email, address, group, tags);
        super.setPrivilege(Privilege.HOUSE_HEAD);
    }
}