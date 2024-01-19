package com.sagiia.maman14ex2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;


/**
 * The Maman14Ex2Controller class is the controller for the JavaFX application.
 * It manages the interaction between the GUI components and the Contacts class.
 */
public class Maman14Ex2Controller {

    @FXML
    private ListView<String> list;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPhoneNumber;

    // Instance of the Contacts class to manage contacts data
    private Contacts contact = new Contacts();

    // Current selected contact's name
    private String currName;

    // Flag to track if the "Add" button was pressed
    private boolean addPress = false;

    /**
     * Initializes the controller. This method is automatically called after the FXML file is loaded.
     * It sets up initial data, event listeners, and refreshes the contacts list.
     */
    @FXML
    public void initialize() {
        currName = "";

        addContacts();

        refreshList();

        itemListener();

    }

    /**
     * Sets up a listener for the contact list. When an item is selected, it updates the text fields with the
     * selected contact's information.
     */
    private void itemListener() {
        list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                addPress = false;
                currName = newValue;
                tfName.setText(newValue);
                tfPhoneNumber.setText(contact.getPhoneNumber(newValue).toString());
            }
        });
    }

    /**
     * Adds initial contacts to the Contacts instance.
     */
    private void addContacts() {
        contact.add(123456789, "Sagi");
        contact.add(111223344, "Rachel");
        contact.add(555666777, "David");
        contact.add(888999000, "Sarah");
        contact.add(112233445, "Michael");
        contact.add(667788990, "Rebecca");
        contact.add(445566778, "Jonathan");
        contact.add(998877665, "Emily");
        contact.add(334455667, "Daniel");
        contact.add(778899001, "Jessica");
        contact.add(112233445, "Ryan");
        contact.add(555444333, "Jennifer");
        contact.add(222333444, "Matthew");
        contact.add(777888999, "Laura");
        contact.add(444555666, "Christopher");
        contact.add(666777888, "Amanda");
        contact.add(999000111, "Nicholas");
        contact.add(333222111, "Ashley");
        contact.add(888777666, "Brian");
        contact.add(555222111, "Megan");
        contact.add(111999888, "Kevin");
        contact.add(444999555, "Kimberly");
        contact.add(777222444, "Justin");
        contact.add(888111222, "Stephanie");
        contact.add(111222333, "Brandon");
    }

    /**
     * Handles the "Add" button action. If the button was not pressed before, it clears the text fields,
     * allowing the user to enter new contact information. If pressed, it adds the contact to the list.
     *
     * @param ignoredEvent The ActionEvent triggered by the "Add" button.
     */
    @FXML
    void addContact(ActionEvent ignoredEvent) {
        if (!addPress) {
            // Clear text fields for new contact entry
            tfName.setText("");
            tfPhoneNumber.setText("");
            addPress = true;
            return;
        }
        if (!currName.equals(tfName.getText()) && !tfPhoneNumber.getText().isEmpty()) {
            // Add new contact to the Contacts instance
            contact.add(Integer.parseInt(tfPhoneNumber.getText()), tfName.getText());
            JOptionPane.showMessageDialog(null, "Contact added successfully");
        } else if (tfPhoneNumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a contact name and phone number");
        } else {
            JOptionPane.showMessageDialog(null, "Contact already exists");
        }
        // Refresh the contact list in the GUI
        refreshList();
    }

    /**
     * Refreshes the contact list in the GUI by clearing and re-populating it with the current contacts.
     */
    private void refreshList() {
        addPress = false;
        list.getItems().clear();
        list.getItems().addAll(contact.getTable().values());
    }

    /**
     * Handles the "Delete" button action. Deletes the selected contact from the Contacts instance
     * and refreshes the contact list.
     *
     * @param ignoredEvent The ActionEvent triggered by the "Delete" button.
     */
    @FXML
    void deleteContact(ActionEvent ignoredEvent) {
        if (tfName.getText().isEmpty() || tfPhoneNumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a contact");
            return;
        }
        // Remove the selected contact by name from the Contacts instance
        contact.removeName(currName);
        JOptionPane.showMessageDialog(null, "Contact deleted successfully");
        // Refresh the contact list in the GUI
        refreshList();
    }

    /**
     * Handles the "Search" button action. Prompts the user to enter a name to search and displays
     * the corresponding phone number if found.
     *
     * @param ignoredEvent The ActionEvent triggered by the "Search" button.
     */
    @FXML
    void searchContact(ActionEvent ignoredEvent) {
        // Prompt the user to enter a name to search
        String name = JOptionPane.showInputDialog("Enter name to search");
        // Get the phone number for the entered name from the Contacts instance
        Integer phoneNumber = contact.getPhoneNumber(name);
        if (phoneNumber != null){
            // Display the phone number if the name is found
            JOptionPane.showMessageDialog(null, "Phone number of " + name + " is: " + phoneNumber);
        } else {
            JOptionPane.showMessageDialog(null, "Name not found");
        }
    }

    /**
     * Handles the "Edit" button action. Updates the phone number of the selected contact in the Contacts instance
     * and refreshes the contact list.
     *
     * @param ignoredActionEvent The ActionEvent triggered by the "Edit" button.
     */
    public void editContact(ActionEvent ignoredActionEvent) {
        if (tfName.getText().isEmpty() || tfPhoneNumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a contact");
            return;
        }
        // Update the phone number of the selected contact in the Contacts instance
        contact.updatePhoneNumber(Integer.parseInt(tfPhoneNumber.getText()), currName);
        JOptionPane.showMessageDialog(null, "Contact updated successfully");
        // Refresh the contact list in the GUI
        refreshList();
    }
}