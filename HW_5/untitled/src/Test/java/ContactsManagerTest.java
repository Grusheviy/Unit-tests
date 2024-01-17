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
        contactsManager.editContact(0, newName);

        // Проверяем, что контакт был отредактирован
        assertEquals(newName, contact.get(0).getName());
        assertThrows(IllegalArgumentException.class, () -> contactsManager.editContact(3, newName));
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
        assertThrows(IllegalArgumentException.class, () -> contactsManager.deleteContact(3));
    }

    /*
    Интеграционный тест добавления, редактирования и удаления контакта:
    Тип: Интеграционный тест
    Описание: Проверка, что последовательное добавление, редактирование и удаление контакта работает корректно.
     */
    @Test
    void testAddEditDeleteContactIntegration() {
        List<Contact> contacts = new ArrayList<>();
        ContactsManager contactsManager = new ContactsManager(contacts);

        contactsManager.addContact("Integration Test Contact", "987654321", "integration@test.com");

       //Проверяем что контакт успешно добавлен
        assertEquals(1, contacts.size());
        assertEquals("Integration Test Contact", contacts.get(0).getName());
        assertEquals("987654321", contacts.get(0).getPhoneNumber());
        assertEquals("integration@test.com", contacts.get(0).getEmail());

        // Редактируем имя добавленного контакта
        String editedName = "Edited Integration Test Contact";
        contactsManager.editContact(0, editedName);

        // Проверяем, что контакт был успешно отредактирован
        assertEquals(editedName, contacts.get(0).getName());

        // Удаляем отредактированный контакт
        contactsManager.deleteContact(0);

        // Проверяем, что контакт был успешно удален
        assertEquals(0, contacts.size());

        // Попытка редактирования или удаления несуществующего контакта должна вызывать исключение
        assertThrows(IllegalArgumentException.class, () -> contactsManager.editContact(0, "Неверный ID контакта"));
        assertThrows(IllegalArgumentException.class, () -> contactsManager.deleteContact(0));
    }
}