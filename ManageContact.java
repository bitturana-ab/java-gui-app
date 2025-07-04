import java.util.ArrayList;
import java.util.Scanner;

class Message {
    private String text;
    private String recipient;
    private int id;

    public Message(String text, String recipient, int id) {
        this.text = text;
        this.recipient = recipient;
        this.id = id;
    }

    public void getDetails() {
        System.out.println("Contact name: " + recipient + "\nMessage: " + text + " " + "\nID: " + id);
    }

    public String getText() {
        return text;
    }

    public String getRecipient() {
        return recipient;
    }

    public int getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class Contact {
    private String name;
    private String number;
    private String email;
    private ArrayList<Message> messages;

    public Contact(String name, String number, String email, ArrayList<Message> messages) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = messages;
    }

    public Contact(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = new ArrayList<>();
    }

    public void getDetails() {
        System.out.println("Name: " + this.name + "" + "\nNumber: " + this.number + "" + "\nEmail: " + this.email);
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

}

public class ManageContact {
    private static ArrayList<Contact> contacts;
    private static Scanner sc;
    private static int id = 0;

    public static void main(String[] args) {
        contacts = new ArrayList<>();
        System.out.println("Welcome to the Contact Management System!");
        showIntialOptions();

    }

    private static void showIntialOptions() {
        System.out.println("Please select an option:" + "\n\t1. Manage Contacts" + "\n\t2. Message" + "\n\t3.Exit");
        sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                System.out.println("Exiting the Contact Management System. Goodbye!");
                break;
        }

    }

    private static void manageMessages() {
        System.out.println(
                "Please select one: " + "\n\t1. Show All Messages" + "\n\t2. Send a new message" + "\n\t3. Go back ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                showAllMessages();
                break;
            case 2:
                sendNewMessage();
                break;

            default:
                showIntialOptions();
                break;
        }
    }

    private static void sendNewMessage() {
        System.out.println("Enter name or number to send a message:");
        String name = sc.next();
        if (name.equals("")) {
            System.out.println("Please enter a valid name or number.");
            sendNewMessage();
        }
        boolean found = false;
        for (Contact c : contacts) {
            if (c.getName().equals(name) || c.getNumber().equals(name)) {
                found = true;
                System.out.println("Enter your message: ");
                String messageText = sc.next();
                if (messageText.equals("")) {
                    System.out.println("Please enter a valid message.");
                    sendNewMessage();
                } else {
                    id++;
                    Message message = new Message(messageText, name, id);
                    for (Contact cn : contacts) {
                        if (c.getName().equals(cn.getName()) || c.getNumber().equals(cn.getNumber())) {
                            ArrayList<Message> newMessages = cn.getMessages();
                            newMessages.add(message);
                            c.setMessages(newMessages);
                            // Contact current = c;
                            // current.setMessages(newMessages);
                            // contacts.remove(c);
                            // contacts.add(current);
                            System.out.println("----------------------");
                            System.out.println("Message sent successfully to: " + cn.getName());
                            System.out.println("----------------------");
                        }
                    }
                }
            }
        }
        if (!found) {
            System.out.println("-------------------------------------------------------");
            System.out.println("No any contact found with the name or number: " + name);
            System.out.println("-------------------------------------------------------");
        }
        showIntialOptions();
    }

    private static void showAllMessages() {
        ArrayList<Message> allMessage = new ArrayList<>();
        for (Contact c : contacts) {
            allMessage.addAll(c.getMessages());
            System.out.println("-------------------");
        }
        if (allMessage.size() > 0) {
            for (Message m : allMessage) {
                m.getDetails();
            }
        } else {
            System.out.println("No messages found.");
            System.out.println("-------------------");
        }
        showIntialOptions();
    }

    private static void manageContacts() {
        System.out.println("Please select one: " + "\n\t1. Show Contacts" + "\n\t2. Add a new contact"
                + "\n\t3. Delete a contact " + "\n\t4. Search for contact" + "\n\t5. Go back ");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                showContacts();
                break;
            case 2:
                addContact();
                break;
            case 3:
                deleteContact();
                break;
            case 4:
                searchContact();
                break;
            default:
                showIntialOptions();
                break;
        }
    }

    private static void deleteContact() {
        System.out.println("Enter name or number to delete contact: ");
        String search = sc.nextLine();
        if (search.equals("")) {
            System.out.println("Please enter a valid name or number.");
            deleteContact();
        }
        boolean found = false;
        for (Contact c : contacts) {
            if (c.getName().equals(search) || c.getNumber().equals(search)) {
                contacts.remove(c);
                System.out.println("Contact deleted successfully!");
                found = true;
                showIntialOptions();
                return;
            }
        }
        if (!found)
            System.out.println("No contact found with the name or number: " + search);
        showIntialOptions();
    }

    private static void searchContact() {
        System.out.println("Enter name or number to search contact: ");
        String search = sc.nextLine();
        if (search.equals("")) {
            System.out.println("Please enter a valid name or number.");
            searchContact();
        }
        boolean found = false;
        for (Contact c : contacts) {
            if (c.getName().equals(search) || c.getNumber().equals(search)) {
                c.getDetails();
                System.out.println("-------------------");
                found = true;
                showIntialOptions();
            }
        }
        if (!found)
            System.out.println("No contact found with the name or number: " + search);

        showIntialOptions();
    }

    private static void addContact() {
        System.out.println("Adding a new contact...");
        System.out.println("\nPlease Enter contact name: ");
        String name = sc.next();
        System.out.println("\nEnter contact number: ");
        String number = sc.next();
        System.out.println("\nEnter contact email: ");
        String email = sc.next();

        if (name.equals("") || number.equals("") || email.equals("")) {
            System.out.println("Invalid input. Please try again.");
            addContact();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name) || c.getNumber().equals(number)) {
                    System.out.println(
                            "User contact already exist! with: " + name
                                    + "\nPlease enter defferent contact details...");
                    doesExist = true;
                    addContact();
                }
            }
            if (!doesExist) {
                Contact contact = new Contact(name, number, email);
                contacts.add(contact);
                // contacts.add(new Contact(name, number, email));
                System.out.println("Contact added successfully!");
            }
        }
        showIntialOptions();
    }

    private static void showContacts() {
        if (contacts.size() == 0) {
            System.out.println("No contacts found.");
            System.out.println("-------------------");
            showIntialOptions();
            return;
        }
        for (Contact c : contacts) {
            c.getDetails();
            System.out.println("-------------------");
        }
        showIntialOptions();
    }
}
