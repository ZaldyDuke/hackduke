import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class ReadMenu {
	private File myMenu;
	private List<FoodItem> myFoodList;
	private Restaurant myRestaurant;
	public ReadMenu (File menuFile){
		myMenu=menuFile;
		myFoodList=new ArrayList<FoodItem>();
	}
	public void parseMenu(){
		try {
			Scanner scanner = new Scanner(myMenu);
			String foodType="";
            String name="";
            String[] sizes=null;
            String[] calories=null;
            String[] prices=null;
            String[] meats=null, condiments=null;
	        while (scanner.hasNextLine()) {	        	
	            String[] line=scanner.nextLine().split(" ");
	            String category = line[0];
	            if(category.equals("Type:")){
	            	foodType=line[1];
	            }
	            else if(category.equals("Name:")){
	            	name=line[1];
	            }
	            else if(category.equals("Meat:")){
	            	meats=Arrays.copyOfRange(line, 1, line.length);
	            }
	            else if(category.equals("Condiments:")){
	            	condiments=Arrays.copyOfRange(line, 1, line.length);
	            }
	            else if(category.equals("Sizes:")){
	            	//System.out.println("reading sizes");
	            	sizes= Arrays.copyOfRange(line, 1, line.length);
	            	for(int i=0; i<sizes.length; i++){
	            		//System.out.println(sizes[i]);
	            	}
	            }
	            else if(category.equals("Calories:")){
	            	calories=Arrays.copyOfRange(line, 1, line.length);
	            }
	            else if(category.equals("Price:")){
	            	prices=Arrays.copyOfRange(line, 1, line.length);
	            	for(int i=0; i<sizes.length; i++){
	            		//System.out.println(name);
	            		FoodItem foodItem = new FoodItem(name, sizes[i], meats, condiments, Integer.parseInt(calories[i]), Double.parseDouble(prices[i]));
	            		myFoodList.add(foodItem);
	            	}
	            }            
	        }
	        myRestaurant=new Restaurant(foodType, myFoodList);
	        scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		
	}
	public Restaurant getMyRestaurant(){
		return myRestaurant;
	}
	
}