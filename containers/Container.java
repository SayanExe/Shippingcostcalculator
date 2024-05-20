package containers;
public class Container {
    private int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    private double[] dimensions = new double[3];

    public double[] getDimensions(){
        return dimensions;
    }
    public void setDimensions(double[] dimensions){
        this.dimensions = dimensions;

    }
    public void printinfo(){
        for(int i=0; i<dimensions.length; i++){
            System.out.println(dimensions[i]);
        }

    }
    public Container(double length,double height, double bredth){
        dimensions[0] = length;
        dimensions[1] = height;
        dimensions[2] = bredth;
		
		cost = 0;
    }

    public double calVolumeInCms(){
        double volume = 1;
        for(double elements : dimensions){
            volume *= (elements*100); //Converting dimensions from meters to centimeters
        }
        return volume;
    }
	
	public static double calCost(double totalOrderWeight, double length){
        double cost = 0.0;
        if(length == 12.01) //bigContainer
			cost = 1800; //cost is fixed regardless of weight
		else //smallContainer
			cost = (totalOrderWeight <= 500) ? 1000 : 1200;

        return cost;
    }

}
