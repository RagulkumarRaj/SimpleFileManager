package Command;

import java.io.File;

public class Ls implements Command{

	@Override
	public void execute() {
		String dir = System.getProperty("user.dir");	
		File file = new File(dir);
		File[] fileList = file.listFiles();
		for(File item : fileList)
		{
			System.out.println(item.getAbsolutePath());
		}
	}
	

}
