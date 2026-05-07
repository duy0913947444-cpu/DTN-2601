package com.vti.entity;

import java.util.Objects;
import java.util.Scanner;

public class VietnamesePhone extends Phone{
    private Scanner sc = new Scanner(System.in);
    @Override
    public void insertContact(String name, String phone) {
        Contact contact = new Contact(name,phone);
        contacts.add(contact);
    }

    @Override
    public void removeContact(String name) {
        if(Objects.isNull(name) || name.equals(" ")) return;
        for(Contact contact: contacts){
            if(name.equals(contact.getName())){
                contacts.remove(contact);
            }
        }
    }

    @Override
    public void updateContact(String name, String newPhone) {
        if(Objects.isNull(name) || name.equals(" ")) return;
        for(int i = 0; i < contacts.size(); i++){
            if(name.equals(contacts.get(i).getName())){
                contacts.get(i).setNumber(newPhone);
            }
        }
    }

    @Override
    public void searchContact(String name) {
        if(Objects.isNull(name) || name.equals(" ")) return;
        for(Contact contact: contacts){
            if(name.equals(contact.getName())){
                System.out.println(contact);
            }
        }
    }
}
