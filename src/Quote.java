import java.util.ArrayList;
import java.util.List;

public class Quote {
	
	private Food food = new Food();
	
	public String getBroadFavorite(List<Person> attendees) {
		int[] vals = new int[food.getBroadNames().length];
		for(Person p : attendees) {
			for(int i=0; i<food.getBroadNames().length; i++) {
				vals[i] += getWeight( p.getRating(food.getBroadNames()[i]) );
			}
		}
		int maxIndex = 0;
		for(int i=1; i<vals.length; i++) {
			maxIndex = vals[maxIndex] > vals[i] ? maxIndex : i;
		}
		return food.getBroadNames()[maxIndex];
	}
	
	public String getQuote(List<Person> attendees, String broadType, List<Restaurant> restaurants) {
		
		int calories = getNumCalories(attendees);
		int[] vals = makeVals(attendees, broadType);
		String[] names = getNames(broadType);
		boolean[] satisfied = new boolean[attendees.size()];
		List<String> toBuyNames = new ArrayList<String>();
		
		int numSatisfied = 0, counter = 0;
		while(counter < names.length) {
			int maxIndexFind = getMax(vals);
			toBuyNames.add(names[maxIndexFind]);
//			for(int i=0; i<attendees.size(); i++) {
//				if(attendees.get(i).getRating(names[maxIndexFind]) > 0) {
//					satisfied[i] = true;
//					numSatisfied++;
//				}
//			}
			vals[maxIndexFind] = Integer.MIN_VALUE;
			counter++;
		}
		
		Restaurant rest = restaurants.get(0);
		if( ! rest.getMyFoodType().equals(broadType)) {
			rest = restaurants.get(1);
		}
		
		String order = getOrder(toBuyNames, rest, calories);
		return order;
		
	}
	
	private String getOrder(List<String> toBuyNames, Restaurant rest, int calories) {
		
		double price = 0;
		int currentCalories = 0;
		int toBuyIndex = 0;
		List<String> orders = new ArrayList<String>();
		List<FoodItem> items = rest.getMyFoodItemList();
		boolean added = false;
		
		while(currentCalories < calories && toBuyIndex < toBuyNames.size()) {
			//System.out.println("a");
			added = false;
			for(FoodItem fi : items) {
//				System.out.println("b");
//				System.out.println(fi.getMyName());
//				System.out.println(toBuyNames.get(toBuyIndex));
				if(fi.getMyName().equals(toBuyNames.get(toBuyIndex))) {
					price += fi.getMyPrice();
					currentCalories += fi.getMyCalories();
					orders.add(fi.getMyName() + " " + fi.getMySize());
					toBuyIndex++;
					added = true;
					break;
				}
			}
			if(! added) {
				toBuyIndex++;
			}
		}
		
		return assembleQuote(price, currentCalories, orders);
		
	}
	
	private String assembleQuote(double price, int cals, List<String> orders) {
		
		String ret = "Price: " + price + "\nCalories: " + cals + "\nItems:\n";
		for(String o : orders) {
			ret += o + "\n";
		}
		return ret;
		
	}
	
	private int getMax(int[] vals) {
		int maxIndex = 0;
		for(int i=1; i<vals.length; i++) {
			maxIndex = vals[maxIndex] > vals[i] ? maxIndex : i;
		}
		return maxIndex;
	}
	
	private String[] getNames(String broadType) {
		if(broadType.equals(food.getBroadNames()[0])) {
			return food.getPizzaNames();
		}
		return food.getSandwichNames();
	}
	
	private int[] makeVals(List<Person> attendees, String broadType) {
		int[] vals;
		if(broadType.equals(food.getBroadNames()[0])) {
			vals = new int[food.getPizzaNames().length];
			for(Person p : attendees) {
				for(int i=0; i<food.getPizzaNames().length; i++) {
					vals[i] += getWeight( p.getRating(food.getPizzaNames()[i]) );
				}
			}
		} else {
			vals = new int[food.getSandwichNames().length];
			for(Person p : attendees) {
				for(int i=0; i<food.getSandwichNames().length; i++) {
					vals[i] += getWeight( p.getRating(food.getSandwichNames()[i]) );
				}
			}
		}
		return vals;
	}
	
	private int getNumCalories(List<Person> attendees) {
		return attendees.size() * 700;
	}
	
	private int getWeight(int i) {
		if(i == 0) {
			return -2;
		}
		return i;
	}

}
