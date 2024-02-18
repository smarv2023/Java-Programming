package ArrayList;

import java.util.ArrayList;

public class ArrayListCollection {

	public static void main(String[] args) {
		ArrayList<String> items = new ArrayList<String>();
		
		items.add("red");
		items.add(0, "yellow"); // you can indicate the index
		
		System.out.print("Display list contents with counter-controlled loop:");
		
		for (int i = 0; i < items.size(); i++)
			System.out.printf(" %s", items.get(i));
		
		
		// call a display method
		display(items, "%nDisplay list contents with enchanced for statement:");
		//add
		
		items.add("green");
		items.add("yellow");
		
		// call a display method
		display(items, "%nDisplay with two new elements:");
		
		// this will remove the first encounter from 0 - max
		items.remove("yellow");
		display(items, "%nRemove yellow:");
		
		// remove by index
		items.remove(1);
		display(items, "%nRemove the index 1 'green': ");
		
		System.out.println();
		// check if contains
		System.out.printf("\"red\" is %sin the list%n", items.contains("red") ? "" : "not ");
		
		System.out.printf("Size: %d", items.size());
	}
	
	public static void display(ArrayList<String> items, String header) {
		System.out.printf(header);
		
		for (String item : items)
			System.out.printf(" %s", item);
		
		System.out.println();
	}

}
