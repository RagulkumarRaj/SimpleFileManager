package mainApp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileIndexer implements Runnable{

	private String IndexLocation;
	private BufferedWriter bw;
	private FileWriter fw;
	
	public FileIndexer(String IndexLocation)
	{
	 this.IndexLocation=IndexLocation;
	 try {
		fw = new FileWriter(new File("F:\\List.txt"));
		bw = new BufferedWriter(fw);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	@Override
	public void run() {
		File file = new File(IndexLocation);
		try {
			deepListFiles(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deepListFiles(File file) throws IOException
	{
		if(file.listFiles() == null)
			return;
		File[] fileList = file.listFiles();
		for(File items : fileList)
		{   
			bw.write(items.getAbsolutePath());
			bw.write(items.getName()+"|"+items.getAbsolutePath()+"|"+items.length() + "\n");
			deepListFiles(items);
		}
	}

}
