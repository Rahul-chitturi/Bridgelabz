package com.bridgelabz.objectoriented.inventerymanagement.repository;

import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class InventryMangement {
	 private static void parseInventory(JSONObject inv) 
	    {
		    //Get employee website name
	        //Get employee object within list
	        JSONObject employeeObject = (JSONObject) inv.get("Inventory");
	         
	        String name = (String) employeeObject.get("Name");    
	        System.out.println("Name  : "+name);
	 
	 
	        String Weight = String.valueOf( employeeObject.get("Weight"));  
	        //int weight = Integer.parseInt(lastName);
	        System.out.println("Weight: "+Weight);
	         
	     
	        String Price = String.valueOf( employeeObject.get("PricePerKg"));  
		      //  int Price  =  Integer.parseInt(firstName);
		    System.out.println("Price : "+Price);
		    System.out.println();
	    }
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void json() {

try(FileReader reader = new FileReader("/home/rahul/git/BridgeLabZ/BridgeLab/InventryManagement.json") ){
  JSONParser ne = new JSONParser();
	Object obj =  ne.parse(reader);
  
  JSONArray arr = (JSONArray) obj;
  arr.forEach( emp -> parseInventory( (JSONObject) emp ) );
	JSONObject objOne = new JSONObject();
	JSONArray array = new JSONArray();
	
	objOne.put("Name", "Wheat");
	objOne.put("Weight", new Integer(50));
	objOne.put("PricePerKg", new Integer(70));
	JSONObject objoned = new JSONObject();
	objoned.put("Inventory", objOne );
	JSONObject objTwo = new JSONObject();
	
	objTwo.put("Name", "Rice");
	objTwo.put("Weight", new Integer(12));
	objTwo.put("PricePerKg", new Integer(45));
	JSONObject objTwod = new JSONObject();
	objTwod.put("Inventory", objTwo);
	JSONObject objThre = new JSONObject();
	
	objThre.put("Name", "Pulses");
	objThre.put("Weight", new Integer(18));
	objThre.put("PricePerKg", new Integer(102));
	JSONObject objThred = new JSONObject();
	objThred.put("Inventory", objThre);
	array.add(objoned);
	array.add(objTwod);
	array.add(objThred);
	
	
	FileWriter file =  new FileWriter("/home/rahul/git/BridgeLabZ/BridgeLab/InventryManagement.json" );
	file.write(array.toJSONString());
	file.flush();
	file.close();
}
catch (ParseException e) {
    e.printStackTrace();
}catch(Exception e) {
	e.printStackTrace();
}
}
}
