import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ContactsManagerTest {

    /*
    Проверка добавления контакта
    Тип: Юнит-тест
    Описание: Этот тест проверяет функцию добавления нового контакта в записную книжку.
    Входные данные включают имя, номер телефона и электронную почту.
    Тест проверяет, что контакт успешно добавлен и корректно отображается в приложении.
     */
    @Test
    public void testAddContact() {
        List<Contact> contact = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contact);

        contactsManager.addContact("Test name", "123456789", "TestMail@example.com");

        assertEquals(contact.size(), 1);
        assertEquals(contact.get(0).getName(), "Test name");
        assertEquals(contact.get(0).getPhoneNumber(), "123456789");
        assertEquals(contact.get(0).getEmail(), "TestMail@example.com");
    }

    /*
    Проверка редактирования контакта
    Тип: Юнит-тест
    Описание: Этот тест проверяет функцию редактирования существующего контакта.
    Задача включает изменение имени контакта и проверку, что изменения сохраняются и отображаются правильно.
     */
    @Test
    void testEditContact() {
        List<Contact> contact = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contact);

        // Добавляем тестовый контакт
        Contact testContact = new Contact("Test Name", "123456789", "TestMail@example.com");
        contact.add(testContact);

        // Заменяем имя тестового контакта
        String newName = "New Test Name";
        contactsManager.editContact(0, newName, testContact.getPhoneNumber(), testContact.getEmail());

        // Проверяем, что контакт был отредактирован
        assertEquals(newName, contact.get(0).getName());
        assertThrows(IllegalArgumentException.class, () -> contactsManager.editContact(3, newName,testContact.getPhoneNumber(), testContact.getEmail()));
    }

    /*
    Проверка удаления контакта
    Тип: Юнит-тест
    Описание: Тест проверяет, что при удалении контакта из записной книжки соответствующий
    контакт действительно удаляется, и больше не отображается в приложении.
     */
    @Test
    void testDeleteContact(){
        List<Contact> contact = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contact);

        contact.add(new Contact("Test Name 1", "123456789", "TestMail@example.com"));
        contact.add(new Contact("Test Name 2", "123456789", "TestMail@example.com"));

        contactsManager.deleteContact(0);

        assertEquals(contact.size(), 1);
       // assertThrows(IllegalArgumentException.class, () -> contactsManager.deleteContact(3));
    }


    /*
        Тест на добавление контакта с пустым именем:
        Тип: Юнит-тест
        Описание: Проверка, что при попытке добавить контакт с пустым именем генерируется исключение
        или обрабатывается корректным образом.
    */
    @Test
    void testAddContactWithEmptyName() {
        List<Contact> contacts = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contacts);

        assertThrows(IllegalArgumentException.class, () ->
                contactsManager.addContact("", "123456789", "test@example.com"));
    }

    /*
    Тест на добавление контакта без номера телефона:
        Тип: Юнит-тест
        Описание: Проверка, что при добавлении контакта без указания номера телефона
        генерируется исключение или обрабатывается корректным образом.
    */
    @Test
    void testAddContactWithoutPhoneNumber() {
        List<Contact> contacts = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contacts);

        assertThrows(IllegalArgumentException.class, () ->
                contactsManager.addContact("Test Name", "", "test@example.com"));
    }

    /*
    Тест на добавление контакта без электронной почты:
        Тип: Юнит-тест
        Описание: Проверка, что при добавлении контакта без указания
        электронной почты генерируется исключение или обрабатывается корректным образом.
    */
    @Test
    void testAddContactWithoutEmail() {
        List<Contact> contacts = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contacts);

        assertThrows(IllegalArgumentException.class, () ->
                contactsManager.addContact("Test Name", "123456789", ""));
    }

    /*
    Тест на редактирование контакта с пустым именем:
        Тип: Юнит-тест
        Описание: Проверка, что при попытке редактировать контакт,
        устанавливая ему пустое имя, генерируется исключение или обрабатывается корректным образом.
    */
    @Test
    void testEditContactWithEmptyName() {
        List<Contact> contacts = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contacts);

        String initialName = "Test Name";
        String initialPhoneNumber = "123456789";
        String initialEmail = "test@example.com";

        contactsManager.addContact(initialName, initialPhoneNumber, initialEmail);

        assertThrows(IllegalArgumentException.class, () ->
                contactsManager.editContact(0, "", initialPhoneNumber, initialEmail));
    }

    /*
    Тест на редактирование контакта с изменением номера телефона:
        Тип: Юнит-тест
        Описание: Проверка, что функция редактирования контакта корректно обновляет номер телефона.
    */
    @Test
    void testEditContactWithPhoneNumberChange() {
        List<Contact> contacts = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contacts);

        String initialName = "Test Name";
        String initialPhoneNumber = "123456789";
        String initialEmail = "test@example.com";

        contactsManager.addContact(initialName, initialPhoneNumber, initialEmail);

        // Передаем текущие значения имени и e-mail, а также передаем новый номер телефона
        String newPhoneNumber = "987654321";
        contactsManager.editContact(0, initialName, newPhoneNumber, initialEmail);

        assertEquals(newPhoneNumber, contacts.get(0).getPhoneNumber());
    }
    /*
    Тест на редактирование несуществующего контакта:
        Тип: Юнит-тест
        Описание: Проверка, что при попытке редактировать контакт с несуществующим ID генерируется исключение.
    */
    @Test
    void testEditNonexistentContact() {
        List<Contact> contacts = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contacts);

        assertThrows(IllegalArgumentException.class, () ->
                contactsManager.editContact(0, "New Name","123456789","test@example.com"));
    }
    /*
    Тест на удаление несуществующего контакта:
        Тип: Юнит-тест
        Описание: Проверка, что при попытке удалить контакт с несуществующим ID генерируется исключение.
    */
    @Test
    void testDeleteNonexistentContact() {
        List<Contact> contacts = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contacts);

        assertThrows(IllegalArgumentException.class, () -> contactsManager.deleteContact(0));
    }
    /*
    Тест на получение списка контактов:
        Тип: Юнит-тест
        Описание: Проверка, что метод getContacts возвращает корректный список контактов.
    */
    @Test
    void testGetContacts() {
        List<Contact> contacts = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contacts);

        contactsManager.addContact("Test Name 1", "123456789", "test1@example.com");
        contactsManager.addContact("Test Name 2", "987654321", "test2@example.com");

        List<Contact> retrievedContacts = contactsManager.getContacts();

        assertEquals(contacts, retrievedContacts);
    }
    /*
    Тест на создание ContactsManager с пустым списком контактов:
    Тип: Юнит-тест
    Описание: Проверка, что при создании ContactsManager с пустым списком контактов объект создается корректно.
    */
    @Test
    void testCreateContactManagerWithEmptyList() {
        List<Contact> contacts = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contacts);

        assertNotNull(contactsManager);
        assertEquals(0, contactsManager.getContacts().size());
    }
    /*
    Интеграционный тест на добавление контакта с пустым именем и удаление:
    Тип: Интеграционный тест
    Описание: Проверка, что при добавлении контакта с пустым именем и последующем удалении контакта,
    список контактов остается пустым.
    */
    @Test
    void testAddContactWithEmptyNameAndDelete() {
        List<Contact> contacts = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contacts);

        // Шаг 1: Пользователь добавляет новый контакт с пустым именем
        assertThrows(IllegalArgumentException.class, () ->
                contactsManager.addContact("", "987654321", "empty@example.com"));

        // Проверяем, что контакт не был добавлен
        List<Contact> addedContacts = contactsManager.getContacts();
        assertEquals(0, addedContacts.size());

        // Шаг 2: Пользователь удаляет несуществующий контакт
        assertThrows(IllegalArgumentException.class, () ->
                contactsManager.deleteContact(0));

        // Проверяем, что список контактов остается пустым
        List<Contact> remainingContacts = contactsManager.getContacts();
        assertEquals(0, remainingContacts.size());
    }
    /*
    Интеграционный тест на добавление и удаление контакта:
    Тип: Интеграционный тест
    Описание: Проверка, что добавление и удаление контакта работает корректно.
    */
    @Test
    void testAddAndDeleteContact() {
        List<Contact> contacts = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contacts);

        // Шаг 1: Пользователь добавляет новый контакт
        contactsManager.addContact("Integration Test Contact", "987654321", "integration@example.com");

        // Проверяем, что контакт успешно добавлен
        List<Contact> addedContacts = contactsManager.getContacts();
        assertEquals(1, addedContacts.size());
        assertEquals("Integration Test Contact", addedContacts.get(0).getName());

        // Шаг 2: Пользователь удаляет добавленный контакт
        contactsManager.deleteContact(0);

        // Проверяем, что контакт успешно удален
        List<Contact> remainingContacts = contactsManager.getContacts();
        assertEquals(0, remainingContacts.size());

        // Шаг 3: Попытка удаления несуществующего контакта должна вызывать исключение
        assertThrows(IllegalArgumentException.class, () ->
                contactsManager.deleteContact(0));
    }

    /*
    E2E тест добавления, редактирования и удаления контакта и получения списка контактов:
    Тип: Интеграционный тест
    Описание: Проверка, что последовательное добавление, редактирование и удаление контакта работает корректно.
     */
    @Test
    void testAddEditDeleteContactScenario() {
        List<Contact> contacts = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contacts);

        String initialName = "E2E Test Contact";
        String initialPhoneNumber = "123456789";
        String initialEmail = "test@example.com";
        // Шаг 1: Пользователь добавляет новый контакт
        contactsManager.addContact(initialName, initialPhoneNumber, initialEmail);

        // Проверяем, что контакт успешно добавлен
        List<Contact> addedContacts = contactsManager.getContacts();
        assertEquals(1, addedContacts.size());
        assertEquals("E2E Test Contact", addedContacts.get(0).getName());

        // Шаг 2: Пользователь редактирует имя добавленного контакта
        contactsManager.editContact(0, "Edited E2E Test Contact",initialPhoneNumber,initialEmail);

        // Проверяем, что контакт успешно отредактирован
        List<Contact> editedContacts = contactsManager.getContacts();
        assertEquals("Edited E2E Test Contact", editedContacts.get(0).getName());

        // Шаг 3: Пользователь удаляет отредактированный контакт
        contactsManager.deleteContact(0);

        // Проверяем, что контакт успешно удален
        List<Contact> remainingContacts = contactsManager.getContacts();
        assertEquals(0, remainingContacts.size());

        // Шаг 4: Попытка редактирования или удаления несуществующего контакта должна вызывать исключение
        assertThrows(IllegalArgumentException.class, () ->
                contactsManager.editContact(0, "Invalid Contact ID",initialPhoneNumber,initialEmail));
        assertThrows(IllegalArgumentException.class, () ->
                contactsManager.deleteContact(0));

    }
}
