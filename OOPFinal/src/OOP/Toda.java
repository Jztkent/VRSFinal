//Toda class
package OOP;


import java.io.*;
import java.util.*;

public class Toda extends Register {

    private String Name, PhoneNumber, Email, ContactPerson, Address;

    Toda(String name, String phoneNo, String email, String CP, String address) {

        this.Name = name;
        this.PhoneNumber = phoneNo;
        this.Email = email;
        this.ContactPerson = CP;
        this.Address = address;
    }

    Toda() {
    }

    @Override
    public void register() {
        String name, cellphonenumber, email, contactperson, address;
        Scanner sc = new Scanner(System.in);
        ArrayList<Toda> toda = new ArrayList<>();

        System.out.println("====================| Register Toda |====================");

        while (true) {
            System.out.print("Enter Name Of toda: ");
            name = sc.nextLine();

            if (name.matches(".*[A-Za-z].*")) {
                break;
            } else {
                System.out.println("Invalid Input, Please input valid name");
                System.out.println();
            }
        }
        while (true) {
            System.out.print("Enter Cellphone number: ");
            if (sc.hasNextLong()) {
                cellphonenumber = sc.nextLine();
                break;
            } else {
                System.out.println("Invalid Input, Please input valid Contact number");
                System.out.println();
                sc.nextLine();
            }
        }
        while (true) {
            System.out.print("Enter Email: ");
            email = sc.nextLine();
            if (email.contains("@") || email.contains(".com") || email.contains(".edu") && email.contains(".ph")) {
                break;
            } else {
                System.out.println("Invalid Input, Please input valid email");
                System.out.println();
            }
        }
        while (true) {
            System.out.print("Enter Contact Person: ");
            contactperson = sc.nextLine();
            if (contactperson.matches(".*[A-Za-z].*")) {
                break;
            } else {
                System.out.println("Invalid Input, Please input valid name");
                System.out.println();
            }
        }
        while (true) {
            System.out.print("Enter Address: ");
            address = sc.nextLine();
            if (address.matches(".*[A-Za-z].*")) {
                break;
            } else {
                System.out.println("Invalid Input, Please input valid Address");
                System.out.println();
            }
        }
        Toda T = new Toda(name, cellphonenumber, email, contactperson, address);
        toda.add(T);

        System.out.println("=========================================================");

        try (PrintWriter PW = new PrintWriter(new FileWriter("File\\Toda.txt", true))) {

            PW.print(name + "," + " ");
            PW.print(cellphonenumber + "," + " ");
            PW.print(email + "," + " ");
            PW.print(contactperson + "," + " ");
            PW.print(address + " ");
            PW.println();

        } catch (IOException e) {
            System.out.println("An Error Occurred" + e.getMessage());

        }
    }

    @Override
    public void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader("File\\Toda.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                System.out.printf("%-30s %-30s %-30s %-30s %-30s", parts[0], parts[1], parts[2], parts[3], parts[4]);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    @Override
    public void search() {
        BufferedReader reader = null;
        Scanner sc = new Scanner(System.in);
        try {
            reader = new BufferedReader(new FileReader("File\\Toda.txt"));
            System.out.print("Enter Name of Toda: ");
            String inputName = sc.nextLine();

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];

                if (name.equals(inputName)) {

                    System.out.println("========================================================| Toda Information |=========================================================");
                    System.out.printf("%-30s %-31s %-30s %-30s %-30s", "Name Of Toda", "Phone Number", "Email", "Contact Person", "Address");
                    System.out.println();
                    System.out.printf("%-30s %-30s %-30s %-30s %-30s", parts[0], parts[1], parts[2], parts[3], parts[4]);
                    System.out.println();
                    System.out.println("=====================================================================================================================================");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No Record Found!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();

                } catch (IOException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            }

        }
    }

    public void displaytodabyaddress(String inputaddress) {
        // Denise
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("File\\Toda.txt"));

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String adress = parts[4].trim();

                if (adress.equals(inputaddress)) {

                    System.out.printf("%-30s %-30s %-30s %-30s %-30s", parts[0], parts[1], parts[2], parts[3], parts[4]);
                    System.out.println();

                    found = true;

                }
            }
            if (!found) {
                System.out.println("Address Not Found!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();

                } catch (IOException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            }

        }
    }

}
