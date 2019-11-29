package com.bridgelabz.objectoriented.inventerymanagement.Service.service_implementation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.objectoriented.inventerymanagement.Service.InventryInterface;
import com.bridgelabz.objectoriented.inventerymanagement.model.Inventry;
import com.bridgelabz.utility.Utility;

public class InventryImplementation implements InventryInterface {
	static long total = 0;
	static double pri = 0;

	@SuppressWarnings("unchecked")
	@Override
	public void addInventory() {
		try {
			Inventry inventory = new Inventry();
			FileReader reader = new FileReader("/home/rahul/git/BridgeLabZ/BridgeLab/InventryManagement.json");
			JSONParser ne = new JSONParser();
			Object obj = ne.parse(reader);

			JSONArray arr = (JSONArray) obj;

			FileWriter file = new FileWriter("/home/rahul/git/BridgeLabZ/BridgeLab/InventryManagement.json");

			JSONObject objOne = new JSONObject();

			System.out.println("Enter the name of the product");
			inventory.setName(Utility.inputString());// setting the name of the inventory

			objOne.put("Name", inventory.getName());
			System.out.println("Enter the weight");
			inventory.setWeight(Utility.inputInteger());

			objOne.put("Weight", inventory.getWeight());

			System.out.println("Enter the Price");
			inventory.setPrice(Utility.inputDouble());

			objOne.put("PricePerKg", inventory.getPrice());
			JSONObject objoned = new JSONObject();
			objoned.put("Inventory", objOne);
			arr.add(objoned);

			file.write(arr.toJSONString());
			file.flush();
			file.close();
		} catch (ParseException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public long totalWeight() {
		JSONArray org = readFile();
		total = 0;
		pri = 0;
		org.forEach(emp -> parseInventory((JSONObject) emp, 1));
		return total;
	}

	private static JSONArray readFile() {
		try (FileReader reader = new FileReader("/home/rahul/git/BridgeLabZ/BridgeLab/InventryManagement.json")) {
			JSONParser ne = new JSONParser();
			Object obj = ne.parse(reader);
			JSONArray arr = (JSONArray) obj;
			return arr;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONArray nulll = new JSONArray();
		return nulll;
	}

	private static void parseInventory(JSONObject inv, int n) {

		JSONObject employeeObject = (JSONObject) inv.get("Inventory");
		String Weight = String.valueOf(employeeObject.get("Weight"));
		long w = Long.parseLong(Weight);
		String Price = String.valueOf(employeeObject.get("PricePerKg"));
		double p = Double.parseDouble(Price);
		total = total + w;
		pri = pri + p;

	}

	@SuppressWarnings("unchecked")
	@Override
	public double totalPrice() {
		JSONArray org = readFile();
		total = 0;
		pri = 0;
		org.forEach(emp -> parseInventory((JSONObject) emp, 2));
		return pri * total;
	}

	private static void parseInventory(JSONObject inv) {

		JSONObject employeeObject = (JSONObject) inv.get("Inventory");
		String name = (String) employeeObject.get("Name");
		System.out.println("Name  : " + name);
		String Weight = String.valueOf(employeeObject.get("Weight"));
		System.out.println("Weight: " + Weight);
		String Price = String.valueOf(employeeObject.get("PricePerKg"));
		System.out.println("Price : " + Price);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void displayInventory() {
		JSONArray arr = readFile();
		arr.forEach(emp -> parseInventory((JSONObject) emp));
	}

	@Override
	public void removeInventory() {

		try {
			System.out.println("Enter the name to be remove");
			String userInputName = Utility.inputString();
			boolean result = true;
			FileReader reader = new FileReader("/home/rahul/git/BridgeLabZ/BridgeLab/InventryManagement.json");
			JSONParser ne = new JSONParser();
			JSONArray stored = (JSONArray) ne.parse(reader);
			for (int i = 0; i < stored.size(); i++) {
				JSONObject jsonObject = (JSONObject) stored.get(i);
				JSONObject jsonObject1 = (JSONObject) jsonObject.get("Inventory");
				if (userInputName.equals(jsonObject1.get("Name"))) {
					stored.remove(jsonObject);
					result = false;
					break;
				}

			}
			if (result) {
				System.out.println("Not Found ");
			} else {
				System.out.println("Succusefull.....");
			}
			try (FileWriter file = new FileWriter("/home/rahul/git/BridgeLabZ/BridgeLab/InventryManagement.json")) {
				file.write(stored.toJSONString());
				file.flush();
			}
		} catch (IOException | ParseException ex) {
			System.out.println("Error: " + ex);
		}

	}

	public static void save() {

		System.out.println("SuccuseFull.......");
	}
}
