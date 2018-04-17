package arraylist_mobilephonecrudcontactnames;

public class Contact {
    
    private String contactName;
    private String phoneNumber;

    public Contact() {
    }
    
    public Contact(String contactName, String phoneNumber) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Contacts{" + "contactName=" + contactName + ", phoneNumber=" + phoneNumber + '}';
    }
   
    public static Contact createContact(String contactName, String phoneNumber){
        return new Contact(contactName, phoneNumber);
    }
}

