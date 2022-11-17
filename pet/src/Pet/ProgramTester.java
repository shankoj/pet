
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
                updateExistingPet(scan);
            }else if(option==4){
                 removeExistingPet(scan);    
            }else if(option==5){
                searchByPetName(scan);
            }else if(option==6){
                searchByPetAge(scan);
            }else if(option==7){
                System.out.println("Goodbye!");
            }else{
                System.out.println("Invalid choice!");
            }
            } while (option != 7);

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
        * Updating the existing pet.
        *
        * @param scan the scan
        */
        private static void updateExistingPet(Scanner scan) {

            viewAllPets();
            System.out.print("Enter the pet ID you want to update: ");
            int id = scan.nextInt();
            scan.nextLine();
            System.out.print("Enter new name and new age: ");
            String petString = scan.nextLine();
            String name = petString.split("\\s+")[0];
            int age = Integer.parseInt(petString.split("\\s+")[1]);
            String oldName = pets.get(id).getName();
            int oldAge = pets.get(id).getAge();
            pets.get(id).setName(name);
            pets.get(id).setAge(age);

            System.out.println(oldName + " " + oldAge + " changed to " + name + " " + age);
        }

        /**
        * Removes the existing pet.
        *
        * @param scan the scan
        */
        private static void removeExistingPet(Scanner scan) {

            viewAllPets();
            System.out.print("Enter the pet ID to remove: ");
            int id = scan.nextInt();
            scan.nextLine();
            String name = pets.get(id).getName();
            int age = pets.get(id).getAge();
            pets.remove(id);
            System.out.println(name + " " + age + " is removed.");
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
                System.out.println("3) Update an existing pet.");
                System.out.println("4) Remove an existing pet.");
                System.out.println("5) Search pets by name.");
                System.out.println("6) Search pets by age.");
                System.out.println("7) Exit program");
        }
}



