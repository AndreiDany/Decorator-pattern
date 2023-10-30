
public class Main {

	public static void main(String[] args) {
		
		FileDatasource file = new FileDatasource("testFile.txt");
		
		Decorator decorator = new Decorator(file);
		
		decorator.encrypt("YourEncryptionKey");

	}

}
