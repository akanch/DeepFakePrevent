import java.util.Date;

public class Block {
	
	public String hash;
	public String previousHash;
	private String data;
	private long timeStamp;
	
	//Block constructor
	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timestamp = new Date().getTime();
		this.hash = calculateHash(); //this can ony be set after the other values have been set
	}
	
	//function to calculate hash using SHA-256
	public calculateHash() {
		String calculatedHash = StringUtil.apply256(
			previousHash +
			Long.toString(timestamp) +
			date
		);
		return calculatedHash;
	}
}