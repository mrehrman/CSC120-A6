/* The Cafe class extends the Building class. A Cafe can store an inventory, sell coffee, and restock its inventory. */
public class Cafe extends Building{

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups; 
   
    /**
     * Creates an instance of the class Cafe.
     * @param name The name of the Cafe.
     * @param address The address of the Cafe.
     * @param nFloors The number of floors the Cafe has.
     * @param nCoffeeOunces The number of ounces of coffee in the Cafe's inventory.
     * @param nSugarPackets The number of sugar packets in the Cafe's inventory.
     * @param nCreams The number of creams in the Cafe's inventory.
     * @param nCups The number of cups in the Cafe's inventory.
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }
    
    /**
     * Allows the Cafe to sell coffee. If the Cafe does not have enough of an item in its inventory to sell, it restocks.
     * @param size The number of ounces of coffee being sold. 
     * @param nSugarPackets The number of sugar packets being sold.
     * @param nCreams The number of creams being sold.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces >= size){
         this.nCoffeeOunces = this.nCoffeeOunces - size;
        } else{
            this.restock(64, 25, 25, 25);
            this.nCoffeeOunces = this.nCoffeeOunces - size;
        } if (this.nSugarPackets >= nSugarPackets){
            this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        } else{
            this.restock(64, 25, 25, 25);
            this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        } if (this.nCreams >= nCreams){
            this.nCreams = this.nCreams - nCreams;
        } else{
            this.restock(64, 25, 25, 25);
            this.nCreams = this.nCreams - nCreams;
        } if (this.nCups >= nCups){
            this.nCups = this.nCups - 1;
        } else{
            this.restock(64, 25, 25, 25);
            this.nCups = this.nCups - 1;
        }
        System.out.println("You sold coffee. You now have " + this.nCups + " cups, " + this.nCoffeeOunces + " ounces of coffee, " + this.nSugarPackets + " packets of sugar, and " + this.nCreams + " creams in your inventory.");
    }

    /**
     * Allows the Cafe to restock items in its inventory.
     * @param nCoffeeOunces The number of ounces of coffee in the Cafe's inventory.
     * @param nSugarPackets The number of sugar packets in the Cafe's inventory.
     * @param nCreams The number of creams in the Cafe's inventory.
     * @param nCups The number of cups in the Cafe's inventory.
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = this.nCoffeeOunces + nCoffeeOunces;
        this.nSugarPackets = this.nSugarPackets + nSugarPackets;
        this.nCreams = this.nCreams + nCreams;
        this.nCups = this.nCups + nCups;
        System.out.println("You have restocked. You now have " + this.nCups + " cups, " + this.nCoffeeOunces + " ounces of coffee, " + this.nSugarPackets + " packets of sugar, and " + this.nCreams + " creams in your inventory.");

    } 


   /**
   * Demonstrates the methods in the Cafe class using an instance of the class with the name "Compass".
   * @param args
   */
    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass", "7 Neilson Drive", 1, 150, 150, 150, 50);
        compass.sellCoffee(24, 12, 15);
        compass.sellCoffee(200, 200, 200);
        compass.sellCoffee(125, 20, 2);
    }
    
}
