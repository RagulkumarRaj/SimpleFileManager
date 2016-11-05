package Utilities;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Command.Command;
import Command.Ls;
import Command.Mkdir;
import enumerations.Mode;

public class Inputparser {
	private static boolean initiliazed = false;
	private static Mode mode;
	private static Map<Mode, List> modeComamndeMappings;
	private static Map<String, Command> commandBinaryMappings;

	static {
		if (!isInitialized()) {
			initiliazed = true;
			mode = Mode.Local;
		}
	}

	public Inputparser() {

	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	private static Boolean isInitialized() {
		return initiliazed;
	}

	public void parseInput(String command) {
		if (command.contains("FileTransfer")) {
			setMode(Mode.FileTransfer);
		} else if (command.contains("Local")) {
			setMode(Mode.Local);
		} else if (command.contains("SQL")) {
			setMode(Mode.SQL);
			processQueries();
		} else {

		}

	}

	public void processQueries() {

	}

	public void loadCommandMappings() {
		List commandsForModeLocal = new ArrayList<String>();
		commandsForModeLocal.add("List");
		commandsForModeLocal.add("MakeDir");
		modeComamndeMappings = new EnumMap<Mode, List>(Mode.class);
		modeComamndeMappings.put(Mode.Local, commandsForModeLocal);
		modeComamndeMappings.put(Mode.FileTransfer, commandsForModeLocal);
	}

	public void loadCommandBinaryMappings() {
		commandBinaryMappings = new HashMap<String, Command>();
		commandBinaryMappings.put("List", new Ls());
		commandBinaryMappings.put("Mkdir", new Mkdir());
	}
}
