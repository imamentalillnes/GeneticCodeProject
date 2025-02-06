public class Item {

    //Variables
    private final String name;
    private final double weight;
    private final int value;
    private boolean included;

    //initalizes the variablwes
    public Item(String name, double weight, int value){
        this.name = name;
        this. weight = weight;
        this.value = value;
        included = false;
    }

    //makes current item the same as the inserted item
    public Item(Item a){
        this.weight = a.getWeight();
        this.value = a.getValue();
        this.name = a.name;
        this.included = a.included;
    }
    
    //get methods
    public double getWeight(){
        return weight;
    }

    public int getValue(){
        return value;
    }

    public boolean isIncluded(){
        return included;
    }

    //included setter
    public void setIncluded(boolean included){
        this.included = included;
    }

    public String toString(){
        return " " + name + "(" + weight + " lbs, $" + value + ")"; 
    }

}
