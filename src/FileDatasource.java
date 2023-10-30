import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDatasource implements DataSource {

	private String filePath;
	
	public FileDatasource(String filePath) {
        this.filePath = filePath;
    }
	
	public String getFilePath() {
		return filePath;
	}

	@Override
	public String read(String filePath) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			StringBuilder content = new StringBuilder();
			
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                System.out.println(line);
            }
            return content.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
		return "Error";
	}

	@Override
	public void write(String filePath, String content) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
			
            writer.write(content);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
