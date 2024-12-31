package com.ltp.contacts.service;

import java.util.List;

import com.ltp.contacts.pojo.Contact;

public interface ContactService {
    Contact geContactById(String id);

    void saveContact(Contact contact);

    void updateContact(String id, Contact contact);

    public void deleteContact(String id);

    public List<Contact> getContacts();
}
