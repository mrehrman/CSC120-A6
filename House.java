/* The House class extends the Building class, adding information about house residents and dining rooms. */

import java.util.ArrayList;

public class House extends Building {

  //initialize attributes
  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  /**
   * Creates instance of class House.
   * @param name The name of the House.
   * @param address The address of the House.
   * @param nFloors The number of floors the House has.
   * @param dining True if the house has a dining room, false if the house does not have a dining room.
   */
  public House(String name, String address, int nFloors, boolean dining) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = dining;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Accessor for the hasDiningRoom attribute of a House.
   * @return True if the House has a dining room, false if the House does not have a dining room.
   */
  public boolean hasDiningRoom(){
    if (this.hasDiningRoom == true){
      System.out.println(this.name + " has a dining room.");
      return this.hasDiningRoom;
    } else{
      System.out.println(this.name + " does not have a dining room.");
      return this.hasDiningRoom;
    }
  }

  /**
   * Accessor for the number of residents a House has.
   * @return The number of residents the House has, found using the size of the ArrayList that stores residents.
   */
  public int nResidents(){
      System.out.println(this.name + " has " + this.residents.size() + " residents.");
      return this.residents.size();
  }

  //other methods
  /**
   * Lets a resident move into a House by adding their name to the ArrayList that stores residents.
   * @param name The name of the resident to move into the House.
   */
  public void moveIn(String name){
    if (this.residents.contains(name)){
      System.out.println(name + " is already a resident of " + this.name + ".");
    } else {
      this.residents.add(name);
      System.out.println(name + " is now a resident of " + this.name + ".");
    }
  }

  /**
   * Lets a reisdent move out of a House by removing their name from the ArrayList that stores residents.
   * @param name The name of the resident to move out of the House.
   * @return The name of the resident that has moved out of the House.
   */
  public String moveOut(String name){
    if (this.residents.contains(name)){
      this.residents.remove(name);
      System.out.println(name + " has moved out of " + this.name + ".");
      return name;
    } else {
      throw new RuntimeException(name + " is not a resident of " + this.name + ".");
    }
  }
  
  /**
   * Says whether a person is a resident of a House.
   * @param person The name of the person to check residency for.
   * @return True if the person is a resident of the House, false if the person is not a resident.
   */
  public boolean isResident(String person){
    if (this.residents.contains(person)){
      System.out.println(person + " is a resident of " + this.name + ".");
      return true;
    } else {
      System.out.println(person + " is not a resident of " + this.name + ".");
      return false;
    }
  }

  /**
   * Demonstrates the methods in the House class using an instance of the class with the name "Tyler".
   * @param args
   */
  public static void main(String[] args) {
    House tyler = new House("Tyler", "6 Green Street", 4, true);
    System.out.println(tyler.name);
    System.out.println(tyler.hasDiningRoom());
    tyler.nResidents();
    tyler.moveIn("Maddie");
    tyler.nResidents();
    tyler.moveIn("LC");
    tyler.moveIn("LC");
    tyler.nResidents();
    tyler.moveOut("Maddie");
    tyler.nResidents();
    tyler.isResident("LC");
    tyler.isResident("Maddie");
    tyler.moveOut("Maddie");

  }

}