
package Pet;

import java.util.ArrayList;
import java.util.Scanner;


public class ProgramTester{

    
     static ArrayList<Pets> pets;

    /**
    * @param args the arguments
    */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        pets = new ArrayList<>();
        int option;
        do {
            menu();
            System.out.print("Your chioce: ");
            option = scan.nextInt();
          
            scan.nextLine();
            if (option ==1){
                viewAllPets();
            }else if(option==2){
                addMorePets(scan);
            }else if(option==3){
                searchByPetName(scan);
            }else if(option==4){
                searchByPetAge(scan);
            }else if(option==5){
                System.out.println("Goodbye!");
            }else{
                System.out.println("Invalid choice!");
            }
            } while (option != 5);

                scan.close();
        }
   
    private static void viewAllPets() {

        System.out.println("+---------------------------------------+");
        System.out.printf("|%5s%5s%10s%10s%5s%5s\n", "ID", "|", "NAME", "|", "AGE", "|");
        System.out.println("+---------------------------------------+");
        int i = 0;
        for (Pets pet : pets) {

            System.out.printf("|%5d%5s", i, pet.toString());

        i++;
        }
            System.out.println("+---------------------------------------+");
            System.out.println((i) + " rows in set.");
    }

    /**
    * Adding more pets.
    *
    * @param scan the scan
    */
    private static void addMorePets(Scanner scan) {
        int count = 0;
        String petString = " ";
        
      
        do {

            System.out.print("add pet (name, age): ");
            petString = scan.nextLine();
            if (petString.equalsIgnoreCase("done")) {

                break;
            }
                String name = petString.split("\\s+")[0];
                int age = Integer.parseInt(petString.split("\\s+")[1]);

                pets.add(new Pets(name, age));
                count++;

            } while (!petString.equalsIgnoreCase("done"));
                System.out.println(count + " pets added.");
        }
       /**
        * Searching  pet by  name.
        * @param scan the scan
        */
        private static void searchByPetName(Scanner scan) {

            System.out.print("Enter name to search: ");
            String name = scan.nextLine();

            System.out.println("+---------------------------------------+");
            System.out.printf("|%5s%5s%10s%10s%5s%5s\n", "ID", "|", "NAME", "|", "AGE", "|");
            System.out.println("+---------------------------------------+");
            int i = 0;
            for (Pets pet : pets) {

                if (pet.getName().equalsIgnoreCase(name)) {

                    System.out.printf("|%5d%5s", i, pet.toString());
                    i++;
                }
            }
            System.out.println("+---------------------------------------+");
            System.out.println((i) + "rows in set.");

        }

        /**
        * Searching pet by age.
        *
        * @param scan the scan
        */
        private static void searchByPetAge(Scanner scan) {

            System.out.print("Enter age to search: ");
            int age = scan.nextInt();
            scan.nextLine();
            System.out.println("+---------------------------------------+");
            System.out.printf("|%5s%5s%10s%10s%5s%5s\n", "ID", "|", "NAME", "|", "AGE", "|");
            System.out.println("+---------------------------------------+");
            int i = 0;
            for (Pets pet : pets) {

                if (pet.getAge() == age) {

                    System.out.printf("|%5d%5s", i, pet.toString());
                    i++;
                }
            }
            System.out.println("+---------------------------------------+");
            System.out.println((i) + "rows in set.");

        }

        
        public static void menu() {

                System.out.println("What would like to do?");
                System.out.println("1) View all pets.");
                System.out.println("2) Add more pets.");
                System.out.println("3) Search pets by name.");
                System.out.println("4) Search pets by age.");
                System.out.println("5) Exit program");
        }
}



