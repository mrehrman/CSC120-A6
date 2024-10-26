/* This is a stub for the Cafe class */
public class Cafe extends Building{

    //intialize attributes
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups; 
   
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }
    
    //add error handling
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        this.nCups = this.nCups - 1;
        System.out.println("You now have " + this.nCups + " cups, " + this.nCoffeeOunces + " ounces of coffee, " + this.nSugarPackets + " packets of sugar, and " + this.nCreams + " creams in your inventory.");
    }

    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass", "7 Neilson Drive", 1, 150, 150, 150, 50);
        compass.sellCoffee(24, 12, 15);
    }
    
}
