package Command;

import java.io.File;
import java.io.IOException;

public class Mkdir implements Command{
	public Mkdir(String item) {
		super();
		this.item = item;
	}

	private String item;

	@Override
	public void execute() {
		File file = new File(item);
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
