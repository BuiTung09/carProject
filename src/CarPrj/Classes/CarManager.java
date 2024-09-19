package CarPrj.Classes;

import CarPrj.Classes.Com.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarManager {

	public static void main(String[] args) throws IOException { 
		ArrayList<String> options = new ArrayList<>();
		options.add("List all brands");
		options.add("Add a new brand");
		options.add("Search a brand based on its ID");
		options.add("Update a brand");
		options.add("Save brands to the file, named brands.txt");
		options.add("List all cars in ascending order of brand names");
		options.add("List cars based on a part of an input brand name");
		options.add("Add a car");
		options.add("Remove a car based on its ID");
		options.add("Update a car based on its ID");
		options.add("Save cars to file, named cars.txt");
		options.add("Exit");

		BrandList blist = new BrandList();
		String projectPath = System.getProperty("user.dir");             
		blist.loadFromFile(projectPath + "\\src\\CarPrj\\Brands.txt"); 
		CarList clist = new CarList(blist);                            
		clist.loadFromFile(projectPath + "\\src\\CarPrj\\Cars.txt");  

		int choice = 0;
		do {
			System.out.println("\nCar managing Program");
			choice = Menu.int_getChoice(options);
			switch (choice) {
				case 1:
					blist.listBrands();
					break;
				case 2:
					blist.addBrand();
					break;
				case 3: {
					Scanner sc = new Scanner(System.in);
					System.out.print("Enter the ID you want to search :");
					String ID = sc.nextLine();
					blist.searchID1(ID);
					break;
				}
				case 4:
					blist.updateBrand();
					break;
				case 5:
					blist.saveToFile(projectPath + "\\src\\CarPrj\\Brands.txt");
					break;
				case 6:
					clist.listCars();
					break;
				case 7:
					clist.printBasedBrandName();
					break;
				case 8:
					clist.addCar();
					break;
				case 9:
					clist.removeCar();
					break;
				case 10:
					clist.updateCar();
					break;
				case 11:
					clist.saveToFile(projectPath + "\\src\\CarPrj\\Cars.txt");
					break;
				default:
					System.out.println("Bye!");
			}
		} while (choice > 0 && choice <= 11);
	}
}
