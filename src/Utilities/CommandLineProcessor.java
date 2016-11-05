package Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enumerations.Mode;

public class CommandLineProcessor {
	private static boolean initiliazed = false;
	private static Mode mode;
	static {
		if (!isInitialized()) {
			initiliazed = true;
			mode = Mode.Local;
		}
	}

	private static Boolean isInitialized() {
		return initiliazed;
	}

	private final String commandLineString[];
	private Map<String, String> commandValueMapping;
	private final List<String> acceptableCommandList;

	public CommandLineProcessor(String[] commandLineString) {
		super();
		this.commandLineString = commandLineString;
		acceptableCommandList = new ArrayList<String>();
	}

	public void addCommands(String command) {
		acceptableCommandList.add(command);
	}

	public void processArgs() {
		commandValueMapping = new HashMap<String, String>();

		for (String parameter : acceptableCommandList) {
			for (int i = 0; i < commandLineString.length - 1; i++) {
				if (commandLineString[i].equals(parameter)) {
					commandValueMapping.put(commandLineString[i],
							commandLineString[i + 1]);
					i++;
				}
			}
		}

	}

	public String getCommandValue(String comamnd) {
		return commandValueMapping.get(comamnd);
	}

	public Map getCommandValueMapping() {
		return commandValueMapping;
	}

}
