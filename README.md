# 🚗 Car Dealership

This project is a Java console application that simulates a car dealership inventory system. Users can browse, search, add, and remove vehicles. All vehicle data is stored in a text file and updates automatically with each change.

---

## 📚 Features Included

### 1. 🏠 Main Menu
- Offers a menu with options such as:
  - View All Vehicles
  - Search by Make and Model
  - Search by Year, Color, Type, Mileage, or Price
  - Add a New Vehicle
  - Remove a Vehicle
  - Exit the application

### 2. 🔍 Search Filters
- Each search option prompts the user for input (e.g., price range, color, etc.)
- Displays only the matching vehicles from the inventory
- Helps narrow down results based on user preferences

### 3. ➕ Add / ➖ Remove Vehicles
- Users can add a new vehicle by entering all required details (VIN, year, make, model, etc.)
- Vehicles can be removed using their VIN
- All changes are saved immediately to the `inventory.txt` file

---

## ✨ Interesting Code Highlight

```java
public void removeVehicle(int vin) {
    for (int i = 0; i < inventory.size(); i++) {
        if (inventory.get(i).getVin() == vin) {
            inventory.remove(i);
            break;
        }
    }
}
```
## 💡 Why it's interesting
This method loops through the dealership's inventory and removes a vehicle based on its VIN. It uses a simple for loop and break to stop after the first match, which is a great example of efficient removal without causing issues while iterating through a list.
