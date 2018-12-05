import java.util.HashMap;
import java.util.List;

/**
 * This class represents the backend for managing all 
 * the operations associated with FoodItems
 * 
 * @author sapan (sapan@cs.wisc.edu)
 */
public class FoodData implements FoodDataADT<FoodItem> {
    
    // List of all the food items.
    private List<FoodItem> foodItemList;

    // Map of nutrients and their corresponding index
    private HashMap<String, BPTree<Double, FoodItem>> indexes;
    
    
     /**
     * Public constructor
     */
    public FoodData() {
        foodItemList = new ArrayList<>();
        indexes = new HashMap<String, BPTree<Double,FoodItem>>();
    }
    
    
    /*
     * (non-Javadoc)
     * @see skeleton.FoodDataADT#loadFoodItems(java.lang.String)
     */
    @Override
    public void loadFoodItems(String filePath) {
        Path pathToFile = Paths.get(filePath);
        
        //create a buffered reader using try with resources
        try(BufferedReader reader = Files.newBufferedReader(pathToFile)){
        		
        	//read the first line of the file
        		String line = reader.readLine();
        		
        	//read all lines of the file
        		while(line != null) {
        			//split the string in to an array of values using the comma as a delimiter
        			
        			String[] foodArray = line.split(",");
        			FoodItem food = new FoodItem(foodArray[0], foodArray[1]);
        			
        			//add the nutrients to the food object
        			food.addNutrient(foodArray[2], Double.parseDouble(foodArray[3]));
        			food.addNutrient(foodArray[4], Double.parseDouble(foodArray[5]));
        			food.addNutrient(foodArray[6], Double.parseDouble(foodArray[7]));
        			food.addNutrient(foodArray[8], Double.parseDouble(foodArray[9]));
        			food.addNutrient(foodArray[10], Double.parseDouble(foodArray[11]));
        			
        			foodItemList.add(food);
        			line = reader.readLine();
        		}
        	
        } catch (IOException e) {
			e.printStackTrace();
		}
    }

    /*
     * (non-Javadoc)
     * @see skeleton.FoodDataADT#filterByName(java.lang.String)
     */
    @Override
    public List<FoodItem> filterByName(String substring) {
    		//create a list object to store the filtered items
        List<FoodItem> filteredItems = new ArrayList<>();
        
        //for loop to parse through all the food objects 
        for(int i = 0; i<foodItemList.size(); i++ ) {
        		FoodItem food = foodItemList.get(i);
        		//if the food's name contains the substring, it is added to the filtered list
        		if(food.getName().toLowerCase().contains(substring.toLowerCase())) {
        			filteredItems.add(food);
        		}
        }
        return filteredItems;
       
    }

    /*
     * (non-Javadoc)
     * @see skeleton.FoodDataADT#filterByNutrients(java.util.List)
     */
    @Override
    public List<FoodItem> filterByNutrients(List<String> rules) {
        // TODO : Complete
        return null;
    }

    /*
     * (non-Javadoc)
     * @see skeleton.FoodDataADT#addFoodItem(skeleton.FoodItem)
     */
    @Override
    public void addFoodItem(FoodItem foodItem) {
        // TODO : Complete
    }

    /*
     * (non-Javadoc)
     * @see skeleton.FoodDataADT#getAllFoodItems()
     */
    @Override
    public List<FoodItem> getAllFoodItems() {
        // TODO : Complete
        return null;
    }

}
