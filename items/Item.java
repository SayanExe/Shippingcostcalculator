package items;

import java.sql.SQLOutput;

public class Item {
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private int[] dimensions = new int[3];

    public int[] getDimensions(){
        return dimensions;
    }
    public void setDimensions(int[] dimensions){
        this.dimensions = dimensions;

    }
    public void printinfo(){
        //System.out.println("Laptop Dimensions are: ");
        for(int i=0; i<dimensions.length; i++){
            System.out.println(dimensions[i]);
        }

    }
    public Item(int length, int bredth, int height,double weight){
        dimensions[0] = length;
        dimensions[1] = bredth;
        dimensions[2] = height;
        this.weight = weight;
    }

    public double calVolume(){
        int volume = 1;
        for(int elements : dimensions){
            volume *= elements;
        }
        return volume;

   }
}