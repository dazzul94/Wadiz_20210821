package Hc;

import java.util.HashMap;
import java.util.Map.Entry;

public class Test6 {

	public static String firstUniqueProduct(String[] products) {

		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i < products.length; i++) {
			map.put(products[i], map.get(products[i]) != null?map.get(products[i])+1:1);
		}

		for(int i=0; i < products.length; i++) {
			if(map.get(products[i]) == 1) {
				return products[i];
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(firstUniqueProduct(new String[] { "Apple", "Computer", "Apple", "Computer"  }));
	}

}
