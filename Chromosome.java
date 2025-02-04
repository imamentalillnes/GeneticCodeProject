import java.util.*;

public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome> {

    //used for random number generator
    private static Random rng;

    //no arg constructure 
    public Chromosome(){
    }

    //copies items from the list into the chromosome 
    public Chromosome(ArrayList<Item> items) {
        for(Item i : items){
            this.add(new Item(i));
        }

        for(Item i : this){
            this.g
        }
        
    }

    //chormosome crossover mutation jkl;sdfgjkl;asdfgjkl;sdfg
    public Chromosome crossover(Chromosome other){
        for(Item i : other){

            //Parent 1 gets added
            if (rng.nextInt(10) >= 5){
                
            }
        }
    }

    //Mutates the chromosome 
    public void mutate(){
        for(Item i : this){
            //needs to get the item and change its invluded variable based on a 10% chance
        }
    }

    public int getFitness(){

    }

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

    public String toString(){
        for(Item i : this){

            
        }
    }

}
