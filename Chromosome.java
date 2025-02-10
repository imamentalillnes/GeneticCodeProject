import java.util.*;

public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome> {

    //used for random number generator
    private static Random rng = new Random();

    //no arg constructure 
    public Chromosome(){
    }

    //copies items from the list into the chromosome 
    public Chromosome(ArrayList<Item> items) {
        for(Item i : items){
            this.add(new Item(i));
        }

        for(int i = 0; i < this.size(); i++){
            this.get(i).setIncluded(rng.nextInt(10) >= 5);
        }
        
    }

    //chormosome crossover (decides which parents chromosomes gets passed to the new child)
    public Chromosome crossover(Chromosome other){

        //Chromosome
        Chromosome child = new Chromosome();

        for(int i = 0; i < this.size(); i++){

            //Parent 1 gets added
            if (rng.nextInt(10) >= 5){
                child.add(this.get(i));
            }
            else {
                child.add(other.get(i));
            }
        }

        //returns the new child made
        return child;
    }

    //Mutates the chromosome 
    public void mutate(){

        //runs through the items in the chromosome and tries to mutate
        for(int i = 0; i < this.size(); i++){

            //rng to decide
            if(!(rng.nextInt(10) >= 1)){

                //if its already included then dont include it
                if(this.get(i).isIncluded() == true){
                    this.get(i).setIncluded(false);
                }
                //otherwise do include it
                else {
                    this.get(i).setIncluded(true);
                }
            }
        }
    }

    public int getFitness(){

        //varable
        double itemWeight = 0.0;
        int totalValue = 0;

        //gets weight and value and adds them to temporary vars
        for(int i = 0; i < this.size(); i++){
            if(this.get(i).isIncluded() == true){
                itemWeight += this.get(i).getWeight();
                totalValue += this.get(i).getValue();
            }
        }

        //checks to make sure that total is above 10 
        if(itemWeight > 10){
            return 0;
        }
        else {
            return totalValue;
        }
    }

    //checks the current chromosome against another one to see who got the higher score
    public int compareTo(Chromosome other){
        if (this.getFitness() > other.getFitness()) {
            return -1;
        }
        else if (this.getFitness() < other.getFitness()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    //prints out all the items and returns the fitness value
    public String toString(){
        for(int i =0; i < this.size(); i++){
            if(this.get(i).isIncluded() == true){
                System.out.println(this.get(i).toString());
            }
        }
        return "fitness value " + this.getFitness();
    }

}
