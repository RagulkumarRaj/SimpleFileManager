package mainApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Command.Command;
import Command.Ls;
import Command.Mkdir;
import Utilities.CommandLineProcessor;

public class FileManager {
	static FileWriter fw;
	static BufferedWriter bw;
	private static int count = 0;
	private static Map<String, Command> commandList;

	static {
		try {
			fw = new FileWriter(new File("F:\\List.txt"));
			bw = new BufferedWriter(fw);
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialize() {

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while (true) {

			String input = sc.nextLine();

		}

		File fil = new File("F:");
		System.out.println(fil.getAbsolutePath());
		CommandLineProcessor processor = new CommandLineProcessor(args);
		processor.addCommands("-c");
		processor.addCommands("-s");
		processor.addCommands("-d");
		processor.addCommands("-i");
		processor.processArgs();

		FileManager manager = new FileManager();

		manager.initializeCommnand(processor);

		System.out.println(System.getProperty("user.dir"));
		File file = new File(args[0]);

		new Thread(new FileIndexer("F:")).start();
		manager.readCommand();

	}

	public void readCommand() {
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.println("Please nter a command");
		String command = sc.next();
		new Ls().execute();

	}

	public void initializeCommnand(CommandLineProcessor processor) {
		HashMap<String, String> mapping = (HashMap) processor
				.getCommandValueMapping();
		commandList = new HashMap<String, Command>();
		commandList.put("ls", new Ls());
		commandList.put("mkdir", new Mkdir(mapping.get("-i")));
	}
}
