
package Pet;

/**
 *
 * @author jimmashanko
 */
/**
* Class of Pets.
*/
public class Pets {

    private String name;

    private int age;

    /**
    * Instantiating a new pet.
    *
    * @param name the name
    * @param age the age
    */
    public Pets(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    /**
     * generating getter and setter for name and age
    * Gets the name.
    *
    * @return the name
    */
    public String getName() {
        return name;
    }

    /**
    * @param name the new name
    */
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    /**
    * @param age the new age
    */
    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        String str = "";
        str = String.format("%5s%10s%10s%5d%5s\n", "|", name, "|", age, "|");
        return str;
    }

}

