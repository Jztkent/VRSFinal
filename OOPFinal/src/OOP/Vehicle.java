//Vehicle Class
package OOP;

import java.io.*;
import java.util.*;
import static OOP.OOP.validateDateFormat;


public class Vehicle extends Register {

    private String Bodynumber, Enginenumber, Bodycolor, Registrationdate, firstname, Type;

    Vehicle(String bodynumber, String enginenumber, String bodycolor, String registrationdate, String ownerID, String type) {

        this.Bodynumber = bodynumber;
        this.Enginenumber = enginenumber;
        this.Bodycolor = bodycolor;
        this.Registrationdate = registrationdate;
        this.firstname = firstname;
        this.Type = type;

    }

    Vehicle() {
    }

    @Override
    public void register() {
        String bodyNumber, Oid, enginenumber, bodycolor, rdate, vehicletype;
        Scanner sc = new Scanner(System.in);
        ArrayList<Vehicle> V = new ArrayList<>();
        System.out.println("=========================| Register Vehicle |=================================");

        while (true) {
            System.out.print("Enter Body Number: ");
            bodyNumber = sc.nextLine();
            if (isbodyNumberExists(bodyNumber)) {
                System.out.println("This Body Number is already registered. Please choose a different Body Number.");
                System.out.println();
            } else {
                if (!bodyNumber.matches("^[A-Za-z]+$")) {
                    break;
                } else {
                    System.out.println("Input Valid Number!");
                    System.out.println();

                }
            }
        }

        while (true) {
            System.out.print("Enter Engine Number: ");
            enginenumber = sc.nextLine();
            if (isenginenumberExists(enginenumber)) {
                System.out.println("This Engine Number is already registered. Please choose a different Engine Number.");
                System.out.println();
            } else {
                if (!enginenumber.matches("^[A-Za-z]+$")) {
                    break;
                } else {
                    System.out.println("Input Valid Number!");
                    System.out.println();

                }
            }
        }
        while (true) {
            System.out.print("Enter Body Color : ");
            bodycolor = sc.nextLine();
            if (bodycolor.matches("^[A-Za-z]+$")) {
                break;
            } else {
                System.out.println("Input Valid Color!");
                System.out.println();
            }
        }
        while (true) {
            System.out.print("Enter Registration Date : ");
            rdate = sc.nextLine();
            if (validateDateFormat(rdate)) {
                break;
            } else {
                System.out.println("Invalid date format. Please use the format YYYY-MM-DD.");
                System.out.println();
            }
        }
        while (true) {

            System.out.print("Enter Owner's Id: ");
            Oid = sc.nextLine();
            if (!isOIDExists(Oid)) {
                System.out.println("This Owner's Id is not registered. Please enter the registered owners ID.");
                System.out.println();
            } else {
                if (!Oid.matches("^[A-Za-z]+$")) {
                    break;
                } else {
                    System.out.println("Input Valid Id!");
                    System.out.println();
                }
            }
        }
        while (true) {
            System.out.print("Enter Vehicle Type : ");
            vehicletype = sc.nextLine();
            if (vehicletype.matches("^[A-Za-z]+$")) {
                break;
            } else {
                System.out.println("Input Valid Vehicle Type!");
                System.out.println();
            }
        }
        Vehicle ve = new Vehicle(bodyNumber, enginenumber, bodycolor, rdate, Oid, vehicletype);
        V.add(ve);
        System.out.println("=============================================================================");

        try (PrintWriter PW = new PrintWriter(new FileWriter("File\\Vehicle.txt", true))) {

            PW.print(bodyNumber + "," + " ");
            PW.print(enginenumber + "," + " ");
            PW.print(bodycolor + "," + " ");
            PW.print(rdate + "," + " ");
            PW.print(Oid + "," + " ");
            PW.print(vehicletype + " ");
            PW.println();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());

        }
    }

    @Override
    public void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader("File\\Vehicle.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                System.out.printf(" %-30s %-30s %-30s %-30s %-30s %-30s", parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
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
            reader = new BufferedReader(new FileReader("File\\Vehicle.txt"));
            System.out.print("Enter Body Number: ");
            String inputBN = sc.nextLine();

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String bn = parts[0];

                if (bn.equals(inputBN)) {
                    String OID = parts[4].trim();
                    System.out.println("=======================================================================| Vehicle Information |======================================================================");
                    System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s", "Body Number", "Engine Number", "Body Color", "Registration Date", "Owner", "Vehicle Type");
                    System.out.println();
                    System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s", parts[0], parts[1], parts[2], parts[3], OwnersID(OID), parts[5]);
                    System.out.println();
                    System.out.println("====================================================================================================================================================================");
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

    public static boolean isbodyNumberExists(String bodyNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader("File\\Vehicle.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String existingID = parts[0].trim();
                if (existingID.equalsIgnoreCase(bodyNumber)) {
                    return true; //already exists
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return false; // not found
    }

    public static boolean isenginenumberExists(String enginenumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader("File\\Vehicle.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String existingID = parts[1].trim();
                if (existingID.equalsIgnoreCase(enginenumber)) {
                    return true; // already exists
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return false; // not found
    }

    public static boolean isOIDExists(String ID) {
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

    public static String OwnersID(String OID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("File\\Owner.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String existingID = parts[0].trim();
                if (existingID.equalsIgnoreCase(OID.trim())) {

                    String fname = parts[1];
                    String lname = parts[2];
                    return fname + lname;
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return "No Owner";
    }

    public void color(String inputclr) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("File\\Vehicle.txt"));

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String color = parts[2].trim();

                if (color.equals(inputclr)) {
                    String OID = parts[4].trim();
                    System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s", parts[0], parts[1], parts[2], parts[3], OwnersID(OID), parts[5]);
                    System.out.println();

                    found = true;

                }
            }
            if (!found) {
                System.out.println("Vehicle Body Color Not Found!");
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

    public void delete() {
        // sausejo
        StringBuilder content = new StringBuilder();
        BufferedReader reader;
        Scanner sc = new Scanner(System.in);
        String bodyNumber;
        try {
            reader = new BufferedReader(new FileReader("File\\Vehicle.txt"));

            while (true) {
                System.out.print("Enter Body Number: ");
                bodyNumber = sc.nextLine();
                if (!isbodyNumberExists(bodyNumber)) {
                    System.out.println("There's no such Body Number registered. Please choose a different Body Number.");
                    System.out.println();

                } else {
                    if (!bodyNumber.matches("^[A-Za-z]+$")) {
                        break;
                    } else {
                        System.out.println("Input Valid Number!");
                        System.out.println();

                    }
                }
            }

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String bn = parts[0].trim();

                if (!bn.equals(bodyNumber)) {
                    content.append(line).append("\n");

                }

            }
            reader.close();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("File\\Vehicle.txt"))) {
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
    
    public void checkColor(String inputType, String inputColor){
        //ella
     BufferedReader reader = null;
    
        try {
            reader = new BufferedReader(new FileReader("File\\Vehicle.txt"));

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                 String color = parts[2].trim();
                 String type = parts[5].trim();
                

                if (type.equals(inputType) && color.equals(inputColor)) {
                    String OID = parts[4].trim();
                    System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s", parts[0], parts[1], parts[2], parts[3], OwnersID(OID), parts[5]);
                    System.out.println();

                    found = true;

                }
            }
            if (!found) {
                System.out.println("No "+inputType+" with a Body Color "+ inputColor +"!");
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
