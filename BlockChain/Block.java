import java.util.Date;

public class Block {
	
	public String hash;
	public String previousHash;
	private String data;
	private long timestamp;
	
	//Block constructor
	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timestamp = new Date().getTime();
		this.hash = calculateHash(); //this can ony be set after the other values have been set
	}
	
	//function to calculate hash using SHA-256
	public String calculateHash() {
		String calculatedHash = StringUtil.applySha256(
			previousHash +
			Long.toString(timestamp) +
			data
		);
		return calculatedHash;
	}
}