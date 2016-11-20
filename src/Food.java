
public class Food {
	
	private String[] broadNames = new String[]{"Pizza", "Sandwiches"};
	private String[] pizzaNames = new String[]{"Cheese", "Pepperoni", "Sausage", "Mushroom", 
				"Onion", "Bacon", "Olive"};
	private String[] sandwichNames = new String[]{"White", "Sourdough", "Pepe", "Veggie",
				"Chicken", "Turkey", "Roast"};
	
	public String[] getBroadNames() {return broadNames;}
	public String[] getPizzaNames() {return pizzaNames;}
	public String[] getSandwichNames() {return sandwichNames;}
	
	public int indexBroadNames(String s) {
		for(int i=0; i<broadNames.length; i++) {
			if(broadNames[i].equals(s)) {return i;}
		}
		return -1;
	}

	public int indexPizzaNames(String s) {
		for(int i=0; i<pizzaNames.length; i++) {
			if(pizzaNames[i].equals(s)) {return i;}
		}
		return -1;
	}
	
	public int indexSandwichNames(String s) {
		for(int i=0; i<sandwichNames.length; i++) {
			if(sandwichNames[i].equals(s)) {return i;}
		}
		return -1;
	}
	
}
