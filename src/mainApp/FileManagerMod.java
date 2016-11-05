package mainApp;

import java.util.Scanner;

import Utilities.Inputparser;

public class FileManagerMod {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String command = sc.nextLine();

			Inputparser parser = new Inputparser();
			parser.parseInput(command);

		}
	}
}
