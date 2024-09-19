# Carprj
Pro192 assignment(group 3)
## Scenario
The car showroom, named **Minh Trang BMW**, has a list of **BMW cars**. **BMW brands** are stored in a text file, named ***brands.txt***, and cars are stored in a text file, named ***cars.txt*** as following:
| File brands.txt                                          | Description            |
| -------------------------------------------------------- | ---------------------- |
|B7-2018, BMW 730Li (2018), Harman Kardon: 3.749</br> B7-MS, BMW 730Li M Sport, Harman Kardon: 4.319 </br>B7-MS20, BMW 730Li M Sport (2020), Harman Kardon: 4.369 </br>B7-PE, BMW 730Li Pure Excellence, Harman Kardon: 4.929 </br>B5-18, BMW 530i (2018), Alpine: 2.599 </br>B7019, BMW 530i (2019) , Alpine: 2.729 </br>BX4-18, BMW X4 xDrive20i (2018), Sony: 2.799 </br>BX4-17, BMW X4 xDrive20i (2019) , Sony: 2.899 </br>B3-GT18, BMW 320i GT (2018), Bose: 1,799 </br>B3-S19, BMW 320i Sportline (2019), Bose: 1.899 </br>B5-X19, BMW X5 xDrive40i XLine (2019), Bose: 4.199 </br>B5-X20, BMW X5 xDrive40i XLine (2020), Bose: 4.239  | Information in a line:<br>ID, brand name,sound brand: price|

| File Car.txt | Description |
| ------------ | ----------- |
| C01, B7-2018, red, F12345, E12345i<br> C02, B7-2018, black, F12346, E12346 <br>C03, B7-MS, orange, F12347, E12347 <br>C04, B7-MS20, white, F12348, E12348 <br>C05, B7-PE, pink, F12349, E12349 <br>C06, B5-18, pink, F12350, E12350 <br>C07, B5-X20, grey, F12351, E12351|Information of a line: <br> <ID, brandID, color, frame ID, engine ID> |
## Feature
 Product management program for a car showroom have this feature:
- List all brands
- Add a new brand
- Search a brand to the file, named brands.txt
- List all cars in ascending order of brand names
- List cars  based on a part of an input brand name
- Add a car
- Remove a car based on its ID
- Update a car based on its ID
- Save cars to file, named cars.txt
### Constaints
1.  **Constrains on brands:**
	a. Brand ID can not be duplicated.
	b. The brand name can not be blank.
	c. The sound manufacture can not be blank.
	d. The price must be a positive real number.
 2. **Constains on cars:**
	 a. Car ID can not be duplicated.
	 b. Brand ID must have existed and it must be inputted using a menu.
	 c. Color can not be blank.
	 d. Frame ID can not be blank and must be in the “F00000” format and can not be duplicated.
	 e. Engine ID can not be blank and must be in the “E00000” format and can not be duplicated.
## Download and running
### Download
**Download the project directly on github:**
Go to code button -> Download ZIP
**Git clone**
Open `terminal` or` cmd `or `gitBash` redirect to your code folder then run this command line:
```
git clone https://github.com/bachwilliams/Carprj.git
```
### Running
You can run on IDE support java

