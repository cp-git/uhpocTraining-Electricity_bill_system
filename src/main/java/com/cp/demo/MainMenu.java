package com.cp.demo;

import java.util.Scanner;

import com.cp.demo.contoller.DemoController;
import com.cp.demo.exception.CPException;
import com.cp.inv.util.DBManager;

public class MainMenu {

	public MainMenu() {
//		initCache();
	}

	public static void main(String[] args) throws CPException {

		while (true) {
			System.out.println("============= Main Menu ============");
			System.out.println("1. Create Department Store");
			System.out.println("2. Add New Consumer");
			System.out.println("3. Generate Electrcity Bill");
			System.out.println("4. Exit");
			Scanner sc1 = new Scanner(System.in);
			int option = sc1.nextInt();
			switch (option) {
			case 1:
				DemoController dc = new DemoController();
				dc.CreatConnection();
				break;
			case 2:
				break;

			case 3:
				break;
			case 4:
				DBManager dbm = DBManager.getDBManager();
				dbm.cleanPool();
				sc1.close();
				System.exit(0);
				break;
			case 5:
				System.out.println("Please enter options between 1 to 4 ");
				break;
			}
		}

	}

}
