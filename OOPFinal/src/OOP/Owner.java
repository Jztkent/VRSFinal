//Owner class
package OOP;

import java.io.*;
import java.util.*;
import static OOP.OOP.validateDateFormat;


public class Owner extends Register {

    private String Id, Firstname, Lastname, Gender, Birth, Address;

    Owner(String id, String firstname, String lastname, String gender, String birth, String address) {
        this.Id = id;
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.Gender = gender;
        this.Birth = birth;
        this.Address = address;

    }

    Owner() {
    }

    @Override
    public void register() {
        ArrayList<Owner> O = new ArrayList<>();
        String Id, firstname, lastname, gender, dateofbirth, address;
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================| Register Owner |=================================");

        while (true) {
            System.out.print("Enter Owner's Id : ");
            Id = sc.nextLine();
            if (isIDExists(Id)) {
                System.out.println("This Owner's Id is already registered. Please choose a different ID.");
                System.out.println();
            } else {
                if (!Id.matches("^[A-Za-z]+$")) {
                    break;
                } else {
                    System.out.println("Input Numeric Id!");
                    System.out.println();
                }
            }
        }

        while (true) {
            System.out.print("Enter Firstname : ");
            firstname = sc.nextLine();
            if (firstname.matches("^[A-Za-z]+$")) {
                break;
            } else {
                System.out.println("Input Valid Name!");
                System.out.println();
            }
        }
        while (true) {
            System.out.print("Enter Lastname : ");
            lastname = sc.nextLine();
            if (lastname.matches("^[A-Za-z]+$")) {
                break;
            } else {
                System.out.println("Input Valid Name!");
                System.out.println();
            }
        }
        while (true) {
            System.out.print("Enter Gender : ");
            gender = sc.nextLine();
            if (gender.matches("Male") || gender.matches("Female")) {
                break;
            } else {
                System.out.println("Input Valid Gender!");
                System.out.println();
            }
        }
        while (true) {
            System.out.print("Enter Date Of bith : ");
            dateofbirth = sc.nextLine();
            if (validateDateFormat(dateofbirth)) {
                break;
            } else {
                System.out.println("Invalid date format. Please use the format YYYY-MM-DD.");
                System.out.println();
            }
        }
        while (true) {

            System.out.print("Enter Address : ");
            address = sc.nextLine();
            if (address.matches(".*[A-Za-z].*")) {
                break;
            } else {
                System.out.println("Input Valid address!");
                System.out.println();
            }
        }
        Owner own = new Owner(Id, firstname, lastname, dateofbirth, address, gender);
        O.add(own);
        System.out.println("=============================================================================");

        //fileHandling
        try (PrintWriter PW = new PrintWriter(new FileWriter("File\\Owner.txt", true))) {

            PW.print(Id + "," + " ");
            PW.print(firstname + "," + " ");
            PW.print(lastname + "," + " ");
            PW.print(gender + "," + " ");
            PW.print(dateofbirth + "," + " ");
            PW.print(address + " ");
            PW.println();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    @Override
    public void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader("File\\Owner.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s", parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
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
            reader = new BufferedReader(new FileReader("File\\Owner.txt"));
            System.out.print("Enter ID: ");
            String inputID = sc.nextLine();

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String ID = parts[0];

                if (ID.equals(inputID)) {

                    System.out.println("===================================================================| Owner Information |==================================================================");
                    System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s", "ID", "First Name", "Last Name", "Gender", "Date Of Birth", "Address");
                    System.out.println();
                    System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s", parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                    System.out.println();
                    System.out.println("=========================================================================================================================================================");
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

    public static boolean isIDExists(String ID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("File\\Owner.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String existingID = parts[0].trim();
                if (existingID.equalsIgnoreCase(ID)) {
                    return true; //already exists
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return false; //not found
    }

    public void delete() {
        // Bj keyt
        StringBuilder content = new StringBuilder();
        BufferedReader reader;
        Scanner sc = new Scanner(System.in);
        String Oid;
        try {
            reader = new BufferedReader(new FileReader("File\\Owner.txt"));

            while (true) {
                System.out.print("Enter Owner's Id : ");
                Oid = sc.nextLine();
                if (!isIDExists(Oid)) {
                    System.out.println("This Owner's Id is Not registered. Please choose a different ID.");
                    System.out.println();

                } else {
                    if (!Oid.matches("^[A-Za-z]+$")) {
                        break;
                    } else {
                        System.out.println("Input Numeric Id!");
                        System.out.println();
                    }
                }
            }

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String Id = parts[0].trim();

                if (!Id.equals(Oid)) {
                    content.append(line).append("\n");

                }

            }
            reader.close();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("File\\Owner.txt"))) {
                writer.write(content.toString());
                System.out.println("Data Deleted Successfully");
                writer.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: ");

        } catch (IOException e) {
            System.out.println("Error reading or writing to the file: ");

            System.out.println("Failed to delete data from ");
        }
    }

    public void displayOwnersByAge(int inputAge) {
// jessabyll
        try (BufferedReader reader = new BufferedReader(new FileReader("File\\Owner.txt"))) {

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String dateOfBirth = parts[4].trim();
                int age = calculateAge(dateOfBirth);
                if (age == inputAge) {
                    found = true;

                    System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s", parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                    System.out.println();
                }
            }
            if (!found) {
                System.out.println("No Owners Found for the specified Age.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private int calculateAge(String dateOfBirth) {

        int birthYear = Integer.parseInt(dateOfBirth.substring(0, 4));
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - birthYear;
    }

    public void displayOwnerByGender(String inputgender) {
// Jaycel
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("File\\Owner.txt"));

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String gender = parts[3].trim();

                if (gender.equals(inputgender)) {

                    System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s", parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                    System.out.println();

                    found = true;

                }
            }
            if (!found) {
                System.out.println("Gender Not Found!");
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
