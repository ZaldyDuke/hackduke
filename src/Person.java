import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Person {
	
	private Food food = new Food();
	private List<Integer> broadRatings;
	private List<Integer> pizzaRatings;
	private List<Integer> sandwichRatings;
	
	public Person() {
		broadRatings = Arrays.asList(1,1);
		pizzaRatings = Arrays.asList(1,1,1,1,1,1,1);
		sandwichRatings = Arrays.asList(1,1,1,1,1,1,1);
	}
	
	public Person(List<Integer> broadR, List<Integer> pizzaR, List<Integer> sandwichR) {
		broadRatings = new ArrayList<Integer>(broadR);
		pizzaRatings = new ArrayList<Integer>(pizzaR);
		sandwichRatings = new ArrayList<Integer>(sandwichR);
	}
	
	public int getRating(String foodItem) {
		if(food.indexBroadNames(foodItem) >= 0) {
			return broadRatings.get( food.indexBroadNames(foodItem) );
		} else if(food.indexPizzaNames(foodItem) >= 0) {
			return pizzaRatings.get( food.indexPizzaNames(foodItem) );
		} else if(food.indexSandwichNames(foodItem) >= 0) {
			return sandwichRatings.get( food.indexSandwichNames(foodItem) );
		} else {
			return -1;
		}
	}
	
	

}
