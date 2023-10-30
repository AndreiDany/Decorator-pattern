
public interface DataSource {

	public String getFilePath();
	
	public String read(String filePath);
	
	public void write(String filePath, String content);
}
