import java.util.List;

public class ContactsManager {

    private List<Contact> contacts;

    public ContactsManager(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(String name, String phoneNumber, String email) {
        Contact newContact = new Contact(name, phoneNumber, email);
        contacts.add(newContact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void editContact(int contactId, String newName) {
        if (contactId >= 0 && contactId < contacts.size()) {
            Contact contactToEdit = contacts.get(contactId);
            contactToEdit.setName(newName);
        } else {
            throw new IllegalArgumentException("Неверный ID контакта");
        }
    }

    public void deleteContact(int contactId) {
        if (contactId >= 0 && contactId < contacts.size()) {
            contacts.remove(contactId);
        } else {
            throw new IllegalArgumentException("Неверный ID контакта");
        }
    }
}
