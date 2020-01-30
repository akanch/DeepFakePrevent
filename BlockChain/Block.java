import java.util.Date;

public class Block {
	
	public String hash;
	public String previousHash;
	private String data;
	private long timestamp;
	private int nonce;
	
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
			Integer.toString(nonce) +
			data
		);
		return calculatedHash;
	}
	
	//function to mine each block
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //this creates a string with all zeroes that is difficulty-legnth
		while (!hash.substring(0, difficulty).equals(target)) {
			nonce++;
			hash = calculateHash();
		}
		System.out.println("Block Mined: " + hash);
	}
}