// Main class
package OOP;


import java.util.*;
import java.util.regex.*;

public class OOP {

    public static void main(String[] args) {
        Toda T = new Toda();
        Vehicle V = new Vehicle();
        Owner O = new Owner();
//instantiation to display ang naa sa uban 1
        Scanner sc = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("|==========| Transportation Registration System |==========|");
            System.out.println("1. Register");
            System.out.println("2. Display Toda Information");
            System.out.println("3. Display Owner Information");
            System.out.println("4. Display Vehicle Information");
            System.out.println("5. Search Information");
            System.out.println("6. Delete");
            System.out.println("7. Search By:");
            System.out.println("8. Check Car Color");
            System.out.println("9. Exit");
            System.out.println("|=========================================================|");

            System.out.print("Enter A Number: ");

            if (sc.hasNextInt()) {
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        OUTER:
                        while (true) {
                            System.out.println("===============1=========| Register |========================");
                            System.out.println("A.Toda       B.Owner         C.Vehicle         D.Back");
                            System.out.println("=============================================================");
                            System.out.print("Enter A Letter: ");
                            char input = sc.next().charAt(0);
                            char choice = Character.toUpperCase(input);
                            switch (choice) {
                                case 'A':
                                    T.register();
                                    System.out.println();
                                    break;

                                case 'B':
                                    O.register();
                                    System.out.println();
                                    break;

                                case 'C':
                                    V.register();
                                    System.out.println();
                                    break;
                                case 'D':
                                    System.out.println("Proceed!");
                                    break OUTER;
                                default:
                                    System.out.println("Please Enter Letters A-D");
                                    sc.nextLine();
                                    break;
                            }
                        }
                        break;

                    case 2:
//formating
                        System.out.println("===========================================================| List Of Toda |==========================================================");
                        System.out.printf("%-30s %-31s %-30s %-30s %-30s", "Name Of Toda", "Phone Number", "Email", "Contact Person", "Address");
                        System.out.println();
                        T.read();
                        System.out.println();
                        System.out.println("=====================================================================================================================================");

                        break;
                    case 3:

                        System.out.println("=====================================================================| List Of Owner |===================================================================");
                        System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s", "ID", "First Name", "Last Name", "Gender", "Date Of Birth", "Address");
                        System.out.println();
                        O.read();
                        System.out.println();
                        System.out.println("=========================================================================================================================================================");

                        break;
                    case 4:

                        System.out.println("=========================================================================| List Of Vehicle |========================================================================");
                        System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s", "Body Number", "Engine Number", "Body Color", "Registration Date", "Owner's ID", "Vehicle Type", "firstname");
                        System.out.println();
                        V.read();
                        System.out.println();
                        System.out.println("====================================================================================================================================================================");

                        break;
                    case 5:
                        OUTER:

                        while (true) {
                            System.out.println("===================| Search Information |===================");
                            System.out.println("A.Toda       B.Owner         C.Vehicle         D.Back");
                            System.out.println("=============================================================");
                            System.out.print("Enter A Letter: ");
                            char input = sc.next().charAt(0);
                            char choice = Character.toUpperCase(input);

                            switch (choice) {
                                case 'A':
                                    T.search();
                                    break;

                                case 'B':
                                    O.search();
                                    break;

                                case 'C':
                                    V.search();
                                    break;

                                case 'D':
                                    System.out.println("Proceed!");
                                    break OUTER;

                                default:
                                    System.out.println("Please Enter Letters A-D");
                                    sc.nextLine();
                                    break;
                            }
                        }
                        break;
                    case 6:
                        OUTER:
                        while (true) {
                            System.out.println("========================| Delete |=========================");
                            System.out.println("        A.Owner         B.Vehicle         C.Back            ");
                            System.out.println("=============================================================");
                            System.out.print("Enter A Letter: ");
                            char input = sc.next().charAt(0);
                            char choice = Character.toUpperCase(input);
                            switch (choice) {

                                case 'A':
                                    O.delete(); // BJ keyt
                                    System.out.println();
                                    break;

                                case 'B':
                                    V.delete(); // Sausejo
                                    System.out.println();
                                    break;

                                case 'C':
                                    System.out.println("Proceed!");
                                    break OUTER;

                                default:
                                    System.out.println("Please Enter Letters A-D");
                                    sc.nextLine();
                                    break;
                            }
                        }
                        break;

                    case 7:
                        OUTER:

                        while (true) {
                            System.out.println("===============================================| Search |==============================================");
                            System.out.println("A.Owner By Gender       B.Owner By Age        C.Vehicle By Color        D.Toda By Address       E.Exit");
                            System.out.println("========================================================================================================");
                            System.out.print("Enter A Letter: ");
                            char input = sc.next().charAt(0);
                            char choice = Character.toUpperCase(input);

                            switch (choice) {
                                case 'A': // Jaycel 
                                    while (true) {
                                        System.out.print("Enter Gender : ");
                                        String gender = sc.nextLine();
                                        

                                        if (gender.matches("Male") || gender.matches("Female")) {
                                            System.out.println("===================================================================| Owner Information |==================================================================");
                                            System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s", "ID", "First Name", "Last Name", "Gender", "Date Of Birth", "Address");
                                            System.out.println();
                                            O.displayOwnerByGender(gender);
                                            System.out.println();
                                            System.out.println("=========================================================================================================================================================");
                                            break;
                                        } else {
                                            System.out.println("Input Valid Gender! E.g(Male, Female) ");
                                            System.out.println();
                                        }
                                    }
                                    break;
                                case 'B': // Jessablye 

                                    while (true) {
                                        System.out.print("Enter Age: ");
                                        String ageString = sc.nextLine();
                                        

                                        if (ageString.matches("\\d+")) {
                                            int age = Integer.parseInt(ageString);
                                            System.out.println("===================================================================| Owner Information |==================================================================");
                                            System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s", "ID", "First Name", "Last Name", "Gender", "Date Of Birth", "Address");
                                            System.out.println();
                                            O.displayOwnersByAge(age);
                                            System.out.println();
                                            System.out.println("=========================================================================================================================================================");
                                            break;
                                        } else {
                                            System.out.println("Input Valid Age!");
                                            System.out.println();
                                        }
                                    }
                                    break;

                                case 'C': // Kent
                                    while (true) {
                                        System.out.print("Enter Body Color : ");
                                        String bodycolor = sc.nextLine();
                                        

                                        if (bodycolor.matches("^[A-Za-z]+$")) {
                                            System.out.println("=========================================================================| List Of Vehicle |========================================================================");
                                            System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s", "Body Number", "Engine Number", "Body Color", "Registration Date", "Owner's Name", "Vehicle Type", "firstname");
                                            System.out.println();
                                            V.color(bodycolor);
                                            System.out.println();
                                            System.out.println("====================================================================================================================================================================");
                                            break;
                                        } else {
                                            System.out.println("Input Valid Color!");
                                            System.out.println();
                                        }
                                    }
                                    break;

                                case 'D': // Denise
                                    while (true) {
                                        System.out.print("Enter Toda's Address : ");
                                        String address = sc.nextLine();
                                       

                                        if (address.matches("^[A-Za-z]+$")) {
                                            System.out.println("========================================================| Toda Information |=========================================================");
                                            System.out.printf("%-30s %-31s %-30s %-30s %-30s", "Name Of Toda", "Phone Number", "Email", "Contact Person", "Address");
                                            System.out.println();
                                            T.displaytodabyaddress(address);
                                            System.out.println();
                                            System.out.println("====================================================================================================================================================================");
                                            break;
                                        } else {
                                            System.out.println("Input Valid Address!");
                                            System.out.println();
                                        }
                                    }
                                    break;

                                case 'E':
                                    System.out.println("Proceed!");
                                    break OUTER;

                                default:
                                    System.out.println("Please Enter Letters A-D");
                                    sc.nextLine();
                                    break;
                            }
                        }
                        break;

                   

                    case 8:
                        
                        while (true) {
                                        System.out.print("Enter Vehicle Type : ");
                                        String type = sc.nextLine();
                                        
                                        
                                     if (type.matches("^[A-Za-z]+$")){
                                        System.out.print("Enter Vehicle Color : ");
                                        String color = sc.nextLine();
                                        
                                       if(color.matches("^[A-Za-z]+$")) {
                                            System.out.println("=========================================================================| List Of Vehicle |========================================================================");
                                            System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s", "Body Number", "Engine Number", "Body Color", "Registration Date", "Owner's Name", "Vehicle Type", "firstname");
                                            System.out.println();
                                            V.checkColor(type, color);
                                            System.out.println();
                                            System.out.println("====================================================================================================================================================================");
                                            
                                        } else {
                                            System.out.println("Invalid color!");
                                            System.out.println();
                                        }break;
                                        
                                     }else {
                                            System.out.println("Invalid type!");
                                            System.out.println();
                                     }
                                    }
                                   break;
                                    
                       case 9:
                        System.out.println("Thank You For Using Our System...");
                        System.out.println();
                        break;

                    default:
                        System.out.println("Please Enter Numbers From 1-6");
                        System.out.println();
                        break;

                }

            } else {
                System.out.println("!Please Enter an Integer!");
                System.out.println();
                sc.next();
            }

        } while (option != 9);

    }

    public static boolean validateDateFormat(String dateString) {
        String pattern = "^\\d{4}-\\d{2}-\\d{2}$";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(dateString);
        return matcher.matches();
    }

}
