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
        // Add logic later
    }

    private void processGetByMakeModelRequest() {
        // Add logic later
    }

    private void processGetByYearRequest() {
        // Add logic later
    }

    private void processGetByColorRequest() {
        // Add logic later
    }

    private void processGetByMileageRequest() {
        // Add logic later
    }

    private void processGetByVehicleTypeRequest() {
        // Add logic later
    }

    private void processAddVehicleRequest() {
        // Add logic later
    }

    private void processRemoveVehicleRequest() {
        // Add logic later
    }

}

