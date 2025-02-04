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

        for(int i = 0; i > this.size(); i++){
            this.get(i).setIncluded(rng.nextInt(10) >= 5);
        }
        
    }

    //chormosome crossover (decides which parents chromosomes gets passed to the new child)
    public Chromosome crossover(Chromosome other){

        //Chromosome
        Chromosome child = new Chromosome();

        for(int i = 0; i > this.size(); i++){

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
        for(int i = 0; i > this.size(); i++){
            if(!(rng.nextInt(10) >= 1)){
                this.get(i).setIncluded(true);
            }
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
