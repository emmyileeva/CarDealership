package com.dealership.ui;


import com.dealership.data.DealershipFileManager;
import com.dealership.model.Dealership;
import com.dealership.model.Vehicle;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership("inventory.txt");
    }

    public void display() {
        init();

        String choice = "";

        while (!choice.equals("exit")) {
            System.out.println("Welcome to the Dealership!");
            System.out.println("1. View all vehicles");
            System.out.println("2. Search by make and model");
            System.out.println("3. Search by year");
            System.out.println("4. Search by color");
            System.out.println("5. Search by mileage");
            System.out.println("6. Search by type");
            System.out.println("7. Search by price");
            System.out.println("8. Add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("Type 'exit' to quit.");

            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    processAllVehiclesRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetByPriceRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                default:
                    if (!choice.equals("exit")) {
                        System.out.println("Invalid choice, please try again.");
                    }
            }
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.printf("%d %d %s %s %s %s %d %.2f\n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice());
            }
        }
    }

    private void processAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void processGetByPriceRequest() {
        System.out.println("Enter minimum price:");
        double minPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter maximum price:");
        double maxPrice = Double.parseDouble(scanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehicles);
    }

    private void processGetByMakeModelRequest() {
        System.out.println("Enter make:");
        String make = scanner.nextLine();
        System.out.println("Enter model:");
        String model = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    private void processGetByYearRequest() {
        System.out.println("Enter minimum year:");
        int minYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter maximum year:");
        int maxYear = Integer.parseInt(scanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehicles);
    }

    private void processGetByColorRequest() {
        System.out.println("Enter color:");
        String color = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    private void processGetByMileageRequest() {
        System.out.println("Enter minimum mileage:");
        int minMileage = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter maximum mileage:");
        int maxMileage = Integer.parseInt(scanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayVehicles(vehicles);
    }

    private void processGetByVehicleTypeRequest() {
        System.out.println("Enter vehicle type:");
        String vehicleType = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);
    }

    private void processAddVehicleRequest() {
        System.out.println("Enter VIN:");
        int vin = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter year:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter make:");
        String make = scanner.nextLine();
        System.out.println("Enter model:");
        String model = scanner.nextLine();
        System.out.println("Enter vehicle type:");
        String vehicleType = scanner.nextLine();
        System.out.println("Enter color:");
        String color = scanner.nextLine();
        System.out.println("Enter mileage:");
        int odometer = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter price:");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);

        // Save the vehicle to file
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);
        System.out.println("Vehicle added successfully.");
    }

    private void processRemoveVehicleRequest() {
        System.out.println("Enter VIN of vehicle to remove:");
        int vin = Integer.parseInt(scanner.nextLine());

        dealership.removeVehicle(vin);

        // Save the vehicle to file
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);
        System.out.println("Vehicle removed successfully.");
    }

}

