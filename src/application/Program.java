package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites.enums.WorkerLevel;
import entities.Department;
import entities.HourContract;
import entities.Worker;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String nameWorker = sc.nextLine();
		System.out.print("Level: ");
		String levelWorker = sc.nextLine();
		System.out.print("Base salary: ");
		Double baseSalary = sc.nextDouble();

		Worker worker = new Worker(nameWorker, WorkerLevel.valueOf(levelWorker), baseSalary,
				new Department(departmentName));

		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter contract #" + (i + 1) + " data:");
			System.out.print("Date(DD/MM/YYYY): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Value per hours: ");
			double valuePerHors = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();

			HourContract contract = new HourContract(date, valuePerHors, hours);
			worker.addContratc(contract);

		}

		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		sc.close();
	}
}
