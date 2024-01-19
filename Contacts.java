package com.sagiia.maman14ex2;

import java.util.TreeMap;

/**
 * The Contacts class represents a simple contact management system using a TreeMap.
 * Each contact is stored with an associated key (phone number) and value (name).
 */
public class Contacts {

    // TreeMap to store contacts with key as phone number and value as name
    private TreeMap<Integer, String> table;

    /**
     * Constructs a new Contacts instance with an empty TreeMap.
     */
    public Contacts() {
        table = new TreeMap<>();
    }

    /**
     * Adds a new contact to the contacts table.
     *
     * @param key   The phone number of the contact.
     * @param value The name of the contact.
     */
    public void add (Integer key, String value) {
        table.put(key, value);
    }

    /**
     * Removes a contact by name from the contacts table.
     *
     * @param value The name of the contact to be removed.
     */
    public void removeName(String value) {
        table.values().remove(value);
    }

    /**
     * Updates the phone number of a contact in the contacts table.
     *
     * @param key   The new phone number.
     * @param value The name of the contact whose phone number is to be updated.
     */
    public void updatePhoneNumber(Integer key, String value) {
        for (Integer i : table.keySet()) {
            if (table.get(i).equals(value)) {
                table.remove(i);
                table.put(key, value);
                break;
            }
        }
    }

    /**
     * Retrieves the phone number of a contact by name from the contacts table.
     *
     * @param value The name of the contact.
     * @return The phone number associated with the contact, or null if not found.
     */
    public Integer getPhoneNumber(String value) {
        for (Integer i : table.keySet()) {
            if (table.get(i).equals(value)) {
                return i;
            }
        }
        return null;
    }

    /**
     * Gets the entire contacts table.
     *
     * @return The TreeMap containing all contacts.
     */
    public TreeMap<Integer, String> getTable() {
        return table;
    }
}
