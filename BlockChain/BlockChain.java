public class BlockChain {
	
	public static void main(String[] args) {
		Block genesisBlock = new Block("first block", "0");
		System.out.println("Hash for block 1: " + genesisBlock.hash);
		
		Block secondBlock = new Block("second block", "0");
		System.out.println("Hash for block 2: " + secondBlock.hash);
		
		Block thirdBlock = new Block("third block", "0");
		System.out.println("Hash for block 3: " + thirdBlock.hash);
	}
}