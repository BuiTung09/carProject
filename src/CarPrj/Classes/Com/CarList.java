package CarPrj.Classes.Com;

import java.io.File;
import java.util.*;
import java.io.*;

public class CarList extends ArrayList<Car> {

	private BrandList brandList;
	Car car;
	List<Car> carlist;
	Scanner scanner = new Scanner(System.in);

	public CarList() {
		super();
	}

	public CarList(BrandList bList) {
		this.brandList = bList;
	}

//	public boolean loadFromFile(String filename) throws IOException {
//	
//	}
	public boolean loadFromFile(String filename) {
		File f = new File(filename);
		if (!f.exists()) {
			return false;
		} else {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(f));
				String line;
				while ((line = reader.readLine()) != null) {
					String[] parts = line.split(",");
					String carID = parts[0];
					String brandID = parts[1];
					String color = parts[2];
					String frameID = parts[3];
					String engineID = parts[4];
					int pos = brandList.searchID(brandID);
					Brand brand = brandList.get(pos);
					Car car = new Car(carID, brand, color, frameID, engineID);
					this.add(car);
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
	}

	public boolean saveToFile(String fname) {

		FileWriter fileWriter = null;
		boolean c = false;
		File f = new File(fname);

		try {
			if (f.isFile() && f.canWrite()) {
				fileWriter = new FileWriter(f);
				PrintWriter pw = new PrintWriter(fileWriter);
				for (int i = 0; i < this.size(); i++) {
					pw.println(this.get(i).toString());
				}
				c = true;
				System.out.println("Save successfull!");
				fileWriter.close();
				pw.close();

			}

		} catch (Exception e) {
			e.printStackTrace();
			c = false;
		}
		return c;
	}

	public int searchID(String carID) {
		int N = this.size();
		for (int i = 0; i < N; i++) {
			if (this.get(i).getCarID().equalsIgnoreCase(carID.trim())) {
				return i;
			}
		}
		return -1;
	}

	public int searchFrame(String fID) {
		int N = this.size();
		for (int i = 0; i < N; i++) {
			if (this.get(i).getFrameID() == fID) {
				return i;
			}
		}
		return -1;
	}

	public int searchEngine(String eID) {
		int N = this.size();
		for (int i = 0; i < N; i++) {
			if (this.get(i).getEngineID() == eID) {
				return i;
			}
		}
		return -1;
	}

	public void addCar() {
		String carID, color, frameID, engineID, brandID;
		boolean checkCarID = false;
		do {
			System.out.print("Input car ID: ");
			carID = scanner.nextLine();
			for (int i = 0; i < this.size(); i++) {
				if (carID.equals(this.get(i).getCarID())) {
					checkCarID = true;
					System.out.println("This car ID is existed. Try another one!");
					break;
				} else {
					checkCarID = false;
				}
			}
		} while (checkCarID == true);

		//Create a menu for choosing a brand
		Brand brand = Menu.ret_getChoice(brandList);
		do {
			System.out.print("Input color: ");
			color = scanner.nextLine();
			if (color.equals("") != true) {
				break;
			}
			System.out.println("The color must not be blank. Try again !");
		} while (true);
		do {
			System.out.print("Input frame ID: ");
			frameID = scanner.nextLine();
			if ((frameID.matches("F\\d{5}")) && (searchFrame(frameID) == -1)) {
				break;
			}
			System.out.println("The frame ID must be in F00000 format and not be duplicated. Try again !");
		} while (true);
		do {
			System.out.print("Input engine ID: ");
			engineID = scanner.nextLine();
			if ((engineID.matches("E\\d{5}")) && (searchEngine(engineID) == -1)) {
				break;
			}
			System.out.println("The engine ID must be in E00000 format and not be duplicated. Try again !");
		} while (true);
		Car m = new Car(carID, brand, color, frameID, engineID);
		this.add(m);
		System.out.println("The new car has been added.");
	}

	public void printBasedBrandName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a brand name to print all element of brand: ");
		String brand = sc.nextLine().toUpperCase();
		int count = 0;
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).getBrand().getBrandName().indexOf(brand) != -1) {
				System.out.println(this.get(i).getBrand().getBrandName() + this.get(i).getCarID() + ", " + this.get(i).getBrand().getBrandID() + ", " + this.get(i).getFrameID() + ", " + this.get(i).getEngineID());
				count++;
			}
		}
		if (count == 0) {
			System.out.println("No car is detected!");
		}
	}

	public boolean removeCar() {
		System.out.println("Enter ID of the car you want to remove: ");
		Scanner sc1 = new Scanner(System.in);
		String carID = sc1.nextLine();
		int pos = searchID(carID);

		if (pos < 0) {
			System.out.println("No car detected");
			return false;
		}
		this.remove(pos);
		System.out.println("Removed car at location " + pos);
		return true;
	}

	//Update a car base on it's ID
	public boolean updateCar() {
		String carID, color, frameID, engineID, brandID;
		Scanner scanner = new Scanner(System.in);
		int pos;
		String updatedID;
		System.out.print("Input car ID to updated: ");
		updatedID = scanner.nextLine();
		pos = searchID(updatedID);
		if (pos >= 0) {
			Brand brand = Menu.ret_getChoice(brandList);

			do {
				System.out.print("Input color: ");
				color = scanner.nextLine();
				if (color.equals("") != true) {
					break;
				}
				System.out.println("The color must not be null. Try again !");
			} while (true);
			do {
				System.out.print("Input frame ID: ");
				frameID = scanner.nextLine();
				if ((frameID.matches("F\\d{5}")) && (searchFrame(frameID) == -1)) {
					break;
				}
				System.out.println("The frame ID must be in F0000 format and not be duplicated. Try again !");
			} while (true);
			do {
				System.out.print("Input engine ID: ");
				engineID = scanner.nextLine();
				if ((engineID.matches("E\\d{5}")) && (searchEngine(engineID) == -1)) {
					break;
				}
				System.out.println("The engine ID must be in E00000 format and not be duplicated. Try again !");
			} while (true);
			this.get(pos).setUpdatedCar(brand, color, frameID, engineID);
			return true;
		} else {
			System.out.println("Car ID not existed !");
		}
		return false;
	}

	public void listCars() {
		Collections.sort(this, new Comparator<Car>() {
			@Override
			public int compare(Car o1, Car o2) {
				return o1.getBrand().getBrandName().compareTo(o2.getBrand().getBrandName());
			}
		});
		int N = this.size();
		System.out.printf("%6s%9s%9s%9s%11s\n", "CAR ID", "BRAND ID", "COLOR", "FRAMEID", "ENGINE ID");
		for (int i = 0; i < N; i++) {
			System.out.println(this.get(i).screenString());
		}
	}
}
