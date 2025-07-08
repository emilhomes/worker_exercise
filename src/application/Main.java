package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter department's name: ");
        String departmenteName = input.nextLine();
        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        String workerName = input.nextLine();
        System.out.println("Level: ");
        String workerLevel = input.nextLine();
        System.out.println("Base salary: ");
        double baseSalary = input.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departmenteName));

        System.out.print("How many contracts to this worker? ");
        int answer = input.nextInt();

        for(int i = 0; i < answer; i++) {
            System.out.println("Enter contract #" + (i + 1) + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(input.next());
            System.out.print("Value per hour: ");
            double valuePerHour = input.nextDouble();
            System.out.print("Duration (hours): ");
            int duration = input.nextInt();
            HourContract hourContract = new HourContract(contractDate, valuePerHour, duration);
            worker.addContracts(hourContract);
        }

        System.out.println();
        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = input.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartament().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));


        input.close();
    }


}
