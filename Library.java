import java.util.Hashtable;

/* The Library class extends the Building class. It adds a collection of books that can be borrowed and returned. */
public class Library extends Building{

  private Hashtable<String, Boolean> collection;

  /**
   * Creates an instance of the class Library.
   * @param name The name of the Library.
   * @param address The address of the Library.
   * @param nFloors The number of floors the Library has.
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }
  
  /**
   * Adds a title to the collection if it is not already in the collection. When the title is added, it is available to borrow.
   * @param title The title to add to the collection.
   */
  public void addTitle(String title){
    if (this.collection.containsKey(title)){
      System.out.println(title + " is already in the collection.");
    } else{
      this.collection.put(title, true);
      System.out.println(title + " has been added to the collection.");
    }
  }

  /**
   * Removes a title from the collection if the title is in the collection.
   * @param title The title to remove.
   * @return The title that was removed.
   */
  public String removeTitle(String title){
    if (this.collection.containsKey(title)){
      this.collection.remove(title);
      System.out.println(title + " has been removed from the collection.");
      return title;
    } else{
      throw new RuntimeException("That title is not in the collection.");
    }
  }

  /**
   * Lets a user check out a book if the book is available to check out.
   * @param title The title to check out.
   */
  public void checkOut(String title){
    if (this.collection.containsKey(title)){
      if (this.collection.get(title) == true){
        this.collection.replace(title, true, false);
        System.out.println("You have checked out " + title + ".");
      } else{
        System.out.println(title + " is already checked out.");
      }
    } else{
      System.out.println(title + " is not in the collection.");
    }
  }

  /**
   * Lets a user return a book if that book has been checked out.
   * @param title The title of the book that has been returned.
   */
  public void returnBook(String title){
    if (this.collection.containsKey(title)){
      if (this.collection.get(title) == false){
        this.collection.replace(title, false, true);
        System.out.println("You have returned " + title + ".");
      } else{
        System.out.println(title + " has already been returned.");
      }
    } else{
      System.out.println(title + " is not in the collection.");
    }
  }

  /**
   * Accessor that allows a user to determine if a title is in the collection.
   * @param title
   * @return True if the title is in the collection, false if the title is not in the collection.
   */
  public boolean containsTitle(String title){
    if (this.collection.containsKey(title)){
      return true;
    } else{
      return false;
    }
  } 

  /**
   * Checks if a title in the collection is available to check out.
   * @param title The title to check availability for.
   * @return True if the title is available, false if the title is not available.
   */
  public boolean isAvailable(String title){
    if (this.containsTitle(title)){
      if (this.collection.get(title) == true){
        System.out.println(title + " is available.");
        return true;
      } else{
        System.out.println(title + " is not available.");
        return false;
      }
    } else{
      throw new RuntimeException(title + " is not in the collection.");
    }
   
  }

  /**
   * Prints out the entire collection, including title and checkout status.
   * //this method is not yet implented correctly--it's creating an infinite loop. 
   */
  public void printCollection(){
    System.out.println("Titles in the Collection:");
    while (this.collection.keys().hasMoreElements()){
      if (this.collection.get(this.collection.keys().nextElement()) == true){
        System.out.println(this.collection.keys().nextElement() + ": available.");
      } else{
        System.out.println(this.collection.keys().nextElement() + ": not available.");
      }
    }
  }



  /**
   * Demonstrates the methods in the Library class using an instance of the class with the name "Neilson".
   * @param args
   */
  public static void main(String[] args) {
    Library Neilson = new Library("Neilson", "7 Neilson Drive", 4);
    System.out.println(Neilson.collection);
    Neilson.addTitle("When Brooklyn Was Queer");
    System.out.println(Neilson.collection);
    Neilson.addTitle("When Brooklyn Was Queer");
    System.out.println(Neilson.removeTitle("When Brooklyn Was Queer"));
    //Neilson.removeTitle("When Brooklyn Was Queer"); 
    Neilson.addTitle("Patience and Sarah");
    Neilson.addTitle("Annie on My Mind");
    //Neilson.addTitle("The Gilda Stories");
    Neilson.checkOut("Patience and Sarah");
    Neilson.checkOut("Patience and Sarah");
    Neilson.checkOut("This Is How You Lose the Time War");
    System.out.println(Neilson.collection);
    Neilson.returnBook("Patience and Sarah");
    Neilson.returnBook("Patience and Sarah");
    Neilson.returnBook("This Is How You Lose the Time War");
    Neilson.containsTitle("Annie on My Mind");
    System.out.println(Neilson.containsTitle("Annie on My Mind"));
    Neilson.containsTitle("This Is How You Lose the Time War");
    //Neilson.checkOut("Annie on My Mind");
    System.out.println(Neilson.isAvailable("Annie on My Mind"));
    System.out.println(Neilson.collection);
    //Neilson.printCollection();
    Neilson.isAvailable("Annie on My Mind");
    Neilson.isAvailable("We Are Okay");

  }
  
}