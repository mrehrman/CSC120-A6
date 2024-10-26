import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building{

  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }
  
  //methods
  public void addTitle(String title){
    if (this.collection.containsKey(title)){
      System.out.println(title + " is already in the collection.");
    } else{
      this.collection.put(title, true);
      System.out.println(title + " has been added to the collection.");
    }
  }

  public String removeTitle(String title){
    if (this.collection.containsKey(title)){
      this.collection.remove(title);
      System.out.println(title + " has been removed from the collection.");
      return title;
    } else{
      throw new RuntimeException("That title is not in the collection.");
    }
  }

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

  public boolean containsTitle(String title){
    if (this.collection.containsKey(title)){
      System.out.println(title + " is in the collection.");
      return true;
    } else{
      System.out.println(title + " is not in the collection.");
      return false;
    }
  } 

   // returns true if the title is currently available, false otherwise
  public boolean isAvailable(String title){
    if (this.collection.get(title) == true){
      System.out.println(title + " is available.");
      return true;
    } else{
      System.out.println(title + " is not available.");
      return false;
    }
  }

  // prints out the entire collection in an easy-to-read way (including checkout status)
  //this method has not yet been implemented correctly--creating an infinite loop?
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

  }
  
}