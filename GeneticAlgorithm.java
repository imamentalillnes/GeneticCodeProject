import java.io.*;
import java.util.*;

public class GeneticAlgorithm {

    public static ArrayList<Item> readData(String filename) throws FileNotFoundException{

        //varables
        File fileName = new File(filename);
        Scanner fileRead = new Scanner(fileName);
        ArrayList<Item> items = new ArrayList<Item>();
        ArrayList<String> allItemInfo = new ArrayList<>();  
        String label = "";
        double weight = 0.0;
        int value = 0;
        int nextNum = 0;
        
        //collects all the items seperated by spaces from the file
        while(fileRead.hasNext()){
            allItemInfo.add(fileRead.next().replace(",", ""));
        }

        //Gets the items and sets them up
        for(int i = 0; i < allItemInfo.size(); i++){

            try{
                if (Double.parseDouble(allItemInfo.get(i)) > 0 && nextNum == 0) {
                    weight = Double.parseDouble(allItemInfo.get(i));
                    nextNum++;
                }
                else if(Integer.parseInt(allItemInfo.get(i)) > 0 && nextNum == 1){
                    value = Integer.parseInt(allItemInfo.get(i));
                }
            }
            catch(NumberFormatException nfe){
                label += " " + allItemInfo.get(i);
            }

            //combines all the info and adds it to the array list
            if(!label.isEmpty() && weight != 0 && value != 0){
                Item a = new Item(label, weight, value);
                items.add(a);
                label = "";
                value = 0;
                weight = 0;
                nextNum = 0;
            }     
            
        }

        //closes file and returns the new arraylist
        fileRead.close();
        return items;
    }
    
    public static ArrayList<Chromosome> initializePopulation(ArrayList<Item> items, int populationSize){

        //varables
        ArrayList<Chromosome> initPop = new ArrayList<>(populationSize);
        
        for(int i = 0; i < populationSize; i++){
            initPop.add(new Chromosome(items));
        }

        return initPop;
    }

    public static void main(String[] args) throws FileNotFoundException{

        //Varaiables 
        String inputItems = "items.txt";
        ArrayList<Item> Items = readData(inputItems);
        ArrayList<Chromosome> curGen = initializePopulation(Items, 10);

        for(int cycle = 0; cycle < 20; cycle++){

            //Makes the nextGen array 
            ArrayList<Chromosome> nextGen = new ArrayList<Chromosome>((curGen));

            //Shuffles the list so random parents are paired off
            Collections.shuffle(nextGen);

            //runs the crossover method on the current population
            for(int i = 0; i < curGen.size(); i += 2){
                nextGen.add(nextGen.get(i).crossover(nextGen.get(i+1)));
            }

            //mutates 10% of the genetics in the population
            for(int i = 0; i < nextGen.size(); i++){
                nextGen.get(i).mutate();
            }

            //sorts the chromosomes by the most fit
            Collections.sort(nextGen);

            //clears the curgen list
            curGen.clear();

            //take the last 5 chromosomes off
            for(int i = nextGen.size(); i > 10; i--){
                nextGen.remove(i-1);
            }

            //adds the top ten chromosomes to the curGen
            curGen = new ArrayList<>(nextGen);

        }
        for (int i = 0; i < curGen.size(); i++){
            System.out.println(curGen.get(i));
            System.out.println();
        }
    }
}
