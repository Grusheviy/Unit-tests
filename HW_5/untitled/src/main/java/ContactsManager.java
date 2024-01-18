import java.util.List;

public class ContactsManager {

    private List<Contact> contacts;

    public ContactsManager(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(String name, String phoneNumber, String email) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя контакта не может быть пустым");
        }

        if (phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер телефона не может быть пустым");
        }
        if(email.isEmpty()) {
            throw new IllegalArgumentException("Поле email не может быть пустым");
        }
        Contact newContact = new Contact(name, phoneNumber, email);
        contacts.add(newContact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void editContact(int contactIndex, String newName, String newPhoneNumber, String newEmail) {
        if (contactIndex < 0 || contactIndex >= contacts.size()) {
            throw new IllegalArgumentException("Неверный ID контакта");
        }
        if (newName.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (newPhoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Номер телефона не может быть пустым");
        }
        if (newEmail.isEmpty()) {
            throw new IllegalArgumentException("Email не может быть пустым");
        }

        Contact contact = contacts.get(contactIndex);
        contact.setName(newName);
        contact.setPhoneNumber(newPhoneNumber);
        contact.setEmail(newEmail);
    }

    public void deleteContact(int contactId) {
        if (contactId >= 0 && contactId < contacts.size()) {
            contacts.remove(contactId);
        } else {
            throw new IllegalArgumentException("Неверный ID контакта");
        }
    }
}
