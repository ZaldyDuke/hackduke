import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	private static List<Restaurant> myRestaurantList;
	private static List<Person> myAttendees;
	
	public static void main(String[]args){
		//make restaurants
		addRestaurants();
		
		//get all persons and put in list
		addPersons();
		
		//getQuote
		getQuote(); //get quote with the most popular food type
		getQuote("Sandwich"); //get quote with given food type

	}
	
	private static void addRestaurants() {
		myRestaurantList = new ArrayList<Restaurant>();
		File file = new File("src/menus/jimmyjohns.txt");
		ReadMenu readMenu = new ReadMenu(file);
		readMenu.parseMenu();		
		myRestaurantList.add(readMenu.getMyRestaurant());
		file = new File("src/menus/dominos.txt");
		readMenu = new ReadMenu(file);
		readMenu.parseMenu();		
		myRestaurantList.add(readMenu.getMyRestaurant());
	}
	
	private static void addPersons() {
		myAttendees = new ArrayList<Person>();
		myAttendees.add( new Person() );
		myAttendees.add( new Person(Arrays.asList(2,0), Arrays.asList(2,1,0,1,0,2,2), Arrays.asList(2,2,1,0,1,2,1)) );
		myAttendees.add( new Person(Arrays.asList(2,2), Arrays.asList(1,2,1,0,0,0,0), Arrays.asList(2,2,1,0,1,2,1)) );
		myAttendees.add( new Person(Arrays.asList(2,1), Arrays.asList(0,0,1,0,0,0,0), Arrays.asList(2,2,1,0,1,2,1)) );
	}
	
	private static void getQuote() {
		Quote myQuote = new Quote();
		String broadFavorite = myQuote.getBroadFavorite(myAttendees);
		System.out.println("Favorite Broad Type: " + broadFavorite);
		String quote = myQuote.getQuote(myAttendees, broadFavorite, myRestaurantList);
		System.out.println(quote);
	}
	
	private static void getQuote(String broadType) {
		Quote myQuote = new Quote();
		System.out.println("Chosen Broad Type: " + broadType);
		String quote = myQuote.getQuote(myAttendees, broadType, myRestaurantList);
		System.out.println(quote);
	}
	
	
}