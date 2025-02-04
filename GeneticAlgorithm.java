import java.io.*;
import java.util.*;

public class GeneticAlgorithm {

    public static ArrayList<Item> readData(String filename) throws FileNotFoundException{

        //varables
        FileReader file = new FileReader(filename);
        Scanner fileRead = new Scanner(file);
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

    }

    public static void main(String[] args) throws FileNotFoundException{
        
    }
}
