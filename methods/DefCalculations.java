package methods;
import containers.Container;
import items.Item;
public class DefCalculations extends Calculation{
	private Container bigContainer;
    private Container smallContainer;
	
	private Item Laptop;
    private Item Mouse;
    private Item Desktop;
    private Item LCD;
	
	private double totalVolume;
	private double totalWeight;
	
	private double totalLaptopsVolume;
	private double totalMousesVolume;
	private double totalDesktopsVolume;
	private double totalLCDsVolume;
	
	private double totalLaptopsWeight;
	private double totalMousesWeight;
	private double totalDesktopsWeight;
	private double totalLCDsWeight;

	public int[] totalOrder = {0,0,0,0};
	
	public DefCalculations(int[] totalOrder){
		//Intialising Items //Creating objects
		bigContainer = new Container(2.59,2.43,12.01); 
		smallContainer = new Container(2.592,2.43,6.06);
		
		Laptop = new Item(60, 50, 50, 6.5);
		Mouse = new Item(30, 60, 60,0.2);
		Desktop = new Item(100,150,50,20);
		LCD = new Item(120,140,80,2.6);
		
		totalVolume = 0.0;
		totalWeight = 0.0;
		
		totalLaptopsVolume = 0.0;
		totalMousesVolume = 0.0;
		totalDesktopsVolume = 0.0;
		totalLCDsVolume = 0.0;
		
		totalLaptopsWeight = 0.0;
		totalMousesWeight = 0.0;
		totalDesktopsWeight = 0.0;
		totalLCDsWeight = 0.0;
		
		for(int i = 0; i<4; i++){
			this.totalOrder[i] = totalOrder[i];
		}
	}
	
    @Override
    public double totalVolume() {
		double volumeItem;
		for(int i = 0; i<4; i++){
			volumeItem = 0.0;
			String itemName = "";
			switch (i){
                case 0 :
                    itemName = "Laptop";
					volumeItem += (Laptop.calVolume() * totalOrder[0]);
					totalLaptopsVolume = volumeItem;
                    break;

				case 1 :
                    itemName = "Mouse";
					volumeItem += (Mouse.calVolume() * totalOrder[1]);
					totalMousesVolume = volumeItem;
                    break;

				case 2 :
                    itemName = "Desktop";
					volumeItem += (Desktop.calVolume() * totalOrder[2]);
					totalDesktopsVolume = volumeItem;
                    break;

				case 3 :
                    itemName = "LCD";
					volumeItem += (LCD.calVolume() * totalOrder[3]);
					totalLCDsVolume = volumeItem;
                    break;
			}
			//System.out.println("Total " + itemName + " Volume: " + volumeItem);                
			
			totalVolume += volumeItem;

		}
		System.out.println("TotalOrderVolume: " + totalVolume);
		
		return totalVolume;
    }
	
	@Override
    public double totalWeight() {
		double weightItem;
		for(int i = 0; i<4; i++){
			weightItem = 0.0;
			String itemName = "";
			switch (i){
                case 0 :
                    itemName = "Laptop";
					weightItem += (Laptop.getWeight() * totalOrder[0]);
					totalLaptopsWeight = weightItem;
                    break;

				case 1 :
                    itemName = "Mouse";
					weightItem += (Mouse.getWeight() * totalOrder[1]);
					totalMousesWeight = weightItem;
                    break;

				case 2 :
                    itemName = "Desktop";
					weightItem += (Desktop.getWeight() * totalOrder[2]);
					totalDesktopsWeight = weightItem;
                    break;

				case 3 :
                    itemName = "LCD";
					weightItem += (LCD.getWeight() * totalOrder[3]);
					totalLCDsWeight = weightItem;
                    break;
			}
			//System.out.println("Total " + itemName + " Weight: " + weightItem);                
			
			totalWeight += weightItem;

		}
		System.out.println("TotalOrderWeight: " + totalWeight + " Kgs");
		return totalWeight;

	}
	
	@Override
	public double calculateShippingPrice() {
		double totalPrice = 0.0;
		int numSmallContainers = 0;
		int numBigContainers = 0;
		
		double totalVolume = 0.0;
		double smallContainerVolume = smallContainer.calVolumeInCms();
		double bigContainerVolume = bigContainer.calVolumeInCms();
		double remainingContainerVolume = 0.0;//smallContainerVolume;
		for(int i = 0; i<4; i++){
			switch (i){
                case 0 :
                    totalVolume += totalLaptopsVolume;
					break;
				case 1 :
                    totalVolume += totalMousesVolume;
					break;
				case 2 :
                    totalVolume += totalDesktopsVolume;
					break;
				case 3 :
                    totalVolume += totalLCDsVolume;
					break;
			}
		}
		if(totalVolume <= smallContainerVolume){
			numSmallContainers++;
		}
		else{
			numBigContainers = (int) totalVolume/(int) bigContainerVolume;
			//System.out.println("TotalBigContainers: " + numBigContainers);
			remainingContainerVolume = (int)totalVolume % (int)bigContainerVolume;
			//numSmallContainers = (int)remainingContainerVolume/smallContainerVolume
			if(remainingContainerVolume <= smallContainerVolume)
				numSmallContainers++;
			else
				numBigContainers++;
		}
		totalPrice = numSmallContainers*1200 + numBigContainers*1800;
		System.out.println("numSmallContainers: " + numSmallContainers);
		System.out.println("numbBigContainers: " + numBigContainers);
		System.out.println("totalPrice: " + totalPrice);
		return totalPrice;
	}
	
	//@Override
    /*public double calculateShippingPrice() {
		double totalPrice = 0.0;
		double smallContainerVolume = smallContainer.calVolumeInCms();
		double bigContainerVolume = bigContainer.calVolumeInCms();
		double remainingContainerVolume = 0.0;//smallContainerVolume;
		
		int numSmallContainers = 0;
		int numBigContainers = 0;
		for(int i = 0; i<4; i++){
			double totalItemVolume = 0.0;
			double totalItemWeight = 0.0;
			switch (i){
                case 0 :
                    totalItemVolume = totalLaptopsVolume;
					totalItemWeight = totalLaptopsWeight;
                    break;
				case 1 :
                    totalItemVolume = totalMousesVolume;
					totalItemWeight = totalMousesWeight;
                    break;
				case 2 :
                    totalItemVolume = totalDesktopsVolume;
					totalItemWeight = totalDesktopsWeight;
                    break;
				case 3 :
                    totalItemVolume = totalLCDsVolume;
					totalItemWeight = totalLCDsWeight;
                    break;
			}
			
			double tempTotalItemVolume = totalItemVolume;
			double tempItemVolume = (totalOrder[i] > 0) ? (tempTotalItemVolume/totalOrder[i]) : 0;
			int tempNumItems = 0;
			double tempWeight = 0.0;
			if(i > 0 && remainingContainerVolume > 0){//only i = 0 will have 0.0 for remainingContainerVolume
				tempNumItems = (int) Math.floor(remainingContainerVolume/tempItemVolume);
				totalItemWeight -= (totalOrder[i] > 0) ? (tempNumItems * (totalItemWeight/totalOrder[i])) : 0;
				totalItemWeight = totalItemWeight > 0 ? totalItemWeight : 0;
				tempTotalItemVolume = ((totalOrder[i] - tempNumItems) * tempItemVolume); //volume of items after some were fit in extra space from previous item container
				tempTotalItemVolume = tempTotalItemVolume > 0 ? tempTotalItemVolume : 0;
			}			
			
			int nSmallContainersNeeded = (int) Math.ceil(tempTotalItemVolume/smallContainerVolume);
			int numItemsFittedSmallContainer = (tempItemVolume > 0) ? (int) Math.floor(smallContainerVolume/tempItemVolume) : 0; //max items that can be fitted in SmallContainer
			int numItemsRemainingSmallContainer = (numItemsFittedSmallContainer > 0) ? (numItemsFittedSmallContainer - (totalOrder[i] % numItemsFittedSmallContainer)) : 0; //num of Items that can still be fitted
			numItemsRemainingSmallContainer = (numItemsRemainingSmallContainer >= 0) ? numItemsRemainingSmallContainer : 0;
			
			int nBigContainersNeeded = (int) Math.ceil(tempTotalItemVolume/bigContainerVolume);
			int numItemsFittedBigContainer = (tempItemVolume > 0) ? (int) Math.floor(bigContainerVolume/tempItemVolume) : 0;
			int numItemsRemainingBigContainer = (numItemsFittedBigContainer > 0) ? (numItemsFittedBigContainer - (totalOrder[i] % numItemsFittedBigContainer)) : 0;
			numItemsRemainingBigContainer = (numItemsRemainingBigContainer >= 0) ? numItemsRemainingBigContainer : 0;
			
			double tempSmallContainerPrice = nSmallContainersNeeded * Container.calCost(totalItemWeight, 6.06);//smallContainerWt > 500 if filled completely with laptop/Desktop
			double tempBigContainerPrice = nBigContainersNeeded * Container.calCost(totalItemWeight, 12.01);
			if(tempBigContainerPrice < tempSmallContainerPrice){
				numBigContainers += nBigContainersNeeded;
				totalPrice += tempBigContainerPrice;
				remainingContainerVolume = tempItemVolume * numItemsRemainingBigContainer;
			} else {
				numSmallContainers += nSmallContainersNeeded;
				totalPrice += tempSmallContainerPrice;
				remainingContainerVolume = tempItemVolume * numItemsRemainingSmallContainer;
			}
			

		}
		System.out.println("numSmallContainers: " + numSmallContainers);
		System.out.println("numbBigContainers: " + numBigContainers);
		System.out.println("totalPrice: " + totalPrice);
		return totalPrice;
	}*/
	
	@Override
	public void printOrderedItemsInfo(){
		System.out.println("ORDER SUMMARY: ");
		for(int i = 0; i<4; i++){
			String itemName = "";
			switch (i){
                case 0 :
                    itemName = "Laptop";
					break;
					
				case 1 :
                    itemName = "Mouse";
					break;

				case 2 :
                    itemName = "Desktop";
					break;

				case 3 :
                    itemName = "LCD";
					break;
			}
			System.out.println(itemName + ": " + totalOrder[i]);
		}
		
		return;	
	}

}
