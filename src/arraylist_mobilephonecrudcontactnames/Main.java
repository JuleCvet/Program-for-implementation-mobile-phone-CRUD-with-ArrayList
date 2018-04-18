
package arraylist_mobilephonecrudcontactnames;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0046 946 8408");
    
    public static void main(String[] args) {
        
    Integer myIntValue = 56; //in compile time is equal to: Integer.valueOf(56);
    int myInt = myIntValue; //is equal to --> myIntValue.intValue();     (intValue is returning int)
    
    ArrayList<Integer> intArrayList = new ArrayList<Integer>();
    for(int i=0; i<=10; i++){
        intArrayList.add(Integer.valueOf(i));//AUTOBOXING, converting from primitive to Integer class
    }
    
    for(int i=0; i<=10; i++){
        //System.out.println(i + " --> " + intArrayList.get(i).intValue()); //UNBOXING, converting from Integer class to primitive type
        
     
        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double dbl = 0.0; dbl <= 10.0; dbl+= 0.5) {
            myDoubleValues.add(Double.valueOf(dbl));//from primitiv to Double, AUTOBOXING
        }
        
        for (int j=0; j<= myDoubleValues.size(); j++) {
            double value = myDoubleValues.get(j).doubleValue();
            System.out.println(i + " --> " + value);//UNBOXING
        }
        
    //even without   .valueOf() and .doubleValue(), the code is working the same
        
        
        
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            
            switch(action){
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                   mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
               case 6:
                   printActions();
                    break;
            }
        }
    }
    
    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber  = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);
//from Contact class is calling that static method directly
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added: " + name + ", phone = " + phoneNumber);
        }else{
            System.out.println("Cannot add, " + name + " already on file.");
        }
    }
    
    
    private static void updateContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }
        
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber  = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
            if(mobilePhone.updateContact(existingContactRecord, newContact)){
                System.out.println("Successfully updated record. ");
            }else {
                System.out.println("Error updating record.");
        }
    }
    
    private static void removeContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }
        
            if(mobilePhone.removeContact(existingContactRecord)){
                System.out.println("Successfully deleted.");
        }else {
                System.out.println("Error deleting contact.");
         }      
     } 
     
     
     private static void queryContact(){//find it
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }
        
         System.out.println("Name: " + existingContactRecord.getContactName() + "phone number is: "
                 + existingContactRecord.getPhoneNumber());
             } 
     
     
    private static void startPhone(){System.out.println("Starting phone... ");}
    
    
    private static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to add a new contact\n" +
                "3 - to update an existing contact\n" +
                "4 - to remove an existing contact\n" +
                "5 - query if an existing contact exists\n" +
                "6 - to print a list of available actions\n");
        System.out.println("Choose your action: ");
    }
}
