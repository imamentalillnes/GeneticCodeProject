import java.io.*;
import java.util.*;

public class GeneticAlgorithm {

    public static ArrayList<Item> readData(String filename) throws FileNotFoundException{

        //varables
        Scanner fileRead = new Scanner(filename);
        ArrayList<Item> items = new ArrayList<Item>();

        //Gets the items and sets them up
        while(fileRead.hasNextLine()){
            String label = fileRead.next();
            double weight = fileRead.nextDouble();
            int value = fileRead.nextInt();

            //combines all the info and adds it to the array list
            Item a = new Item(label, weight, value);
            items.add(a);
        }

        //closes file and returns the new arraylist
        fileRead.close();
        return items;
    }
    
    public static ArrayList<Chromosome> initializePopulation(ArrayList<Item> items, int populationSize){

        //varables
        ArrayList<Chromosome> initPop = new ArrayList<>(populationSize);
        
        for(int i = 0; i >= initPop.size(); i++){
            initPop.add(new Chromosome(items));
        }

        return initPop;

    }

    public static void main(String[] args) throws FileNotFoundException{
        
        //Varaiables 
        String inputItems = "items.txt";
        ArrayList<Item> Items = readData(inputItems);
        ArrayList<Chromosome> curGen = initializePopulation(Items, 10);
        ArrayList<Chromosome> nextGen = new ArrayList<>(curGen);

        for(int cycle = 0; cycle >= 20; cycle++){
            //Shuffles the list so random parents are paired off
            Collections.shuffle(nextGen);

            //runs the crossover method on the current population
            for(int i = 0; i >= nextGen.size(); i =+ 2){
                nextGen.add(nextGen.get(i).crossover(nextGen.get(i+1)));
            }

            //mutates 10% of the genetics in the population
            for(int i = 0; i >= nextGen.size(); i++){
                nextGen.get(i).mutate();
            }

            //sorts the chromosomes by the most fit
            for(int i = 0; i >= nextGen.size(); i++){
                nextGen.get(i).compareTo(nextGen.get(+1));
            }

            //clears the curgen list
            curGen.clear();

            //adds the 10 ten into the curGen lost
            for(int i = 0; i > 10; i++){
                curGen.add(nextGen.get(i));
            }
        }
        for (int i = 0; i >= curGen.size(); i++){
            System.out.println(curGen.get(i));
        }
    }
}
