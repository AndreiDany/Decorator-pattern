
import java.util.zip.Deflater;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Decorator {

	DataSource dataSource;
	
	public Decorator(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void encrypt(String encryptionKey) {
		try {

			String data = dataSource.read(dataSource.getFilePath());

            Cipher cipher = Cipher.getInstance("AES");
            SecretKey secretKey = new SecretKeySpec(encryptionKey.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = cipher.doFinal(data.getBytes("UTF-8"));

            dataSource.write(dataSource.getFilePath(), new String(encryptedData, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void compress() {
		try {

			String data = dataSource.read(dataSource.getFilePath());

            Deflater deflater = new Deflater();
            deflater.setInput(data.getBytes("UTF-8"));
            deflater.finish();
            byte[] compressedData = new byte[data.length()];
            int compressedSize = deflater.deflate(compressedData);

            dataSource.write(dataSource.getFilePath(), new String(compressedData, 0, compressedSize, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
