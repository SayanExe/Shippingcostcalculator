import containers.Container;
import items.Item;
import methods.DefCalculations;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        

        boolean finalconfirmation = true;
        int[] totalOrder = {0,0,0,0};
        do{
            System.out.println("Please choose the following options: ");
            System.out.println("Press 1 to order laptops \n 2 to order Mouse \n 3 to order Desktop \n 4 to order LCD");

            int count = 0;
            byte choice = sc.nextByte();
            switch (choice){
                case 1 :
                    System.out.println("How many laptops you want to order");
                    totalOrder[0] += sc.nextInt();
                    break;
                case 2 :
                    System.out.println("How many Mouse you want to order");
                    totalOrder[1] += sc.nextInt();
                    break;
                case 3 :
                    System.out.println("How many Desktop you want to order");
                    totalOrder[2] += sc.nextInt();
                    break;
                case 4 :
                    System.out.println("How many LCD you want to order");
                    totalOrder[3] += sc.nextInt();
                    break;
            }
            System.out.print("Do you want to order anything else? 1 or 0: ");//Using 1: Yes and 0: No
            Byte conf = sc.nextByte();
            if(conf == 0){
				System.out.println("Thank you for your order please visit again:)");
                finalconfirmation = false;
			}

        }while(finalconfirmation == true);
		
		DefCalculations defCalcs = new DefCalculations(totalOrder);
		
		defCalcs.printOrderedItemsInfo();
		double totalVolume = defCalcs.totalVolume();
		
		double totalWeight = defCalcs.totalWeight();
		double totalPrice = defCalcs.calculateShippingPrice();
		System.out.println("Back to Main  finalOrderPrice: " + totalPrice);

    }


}