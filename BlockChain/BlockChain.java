import java.util.Arrays;
import java.util.ArrayList;

public class BlockChain {
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 5;
	
	public static void main(String[] args) {	
		//add our blocks to the blockchain ArrayList:
		blockchain.add(new Block("First block", "0"));
		System.out.println("Trying to mine first block...");
		blockchain.get(0).mineBlock(difficulty);
			
		blockchain.add(new Block("Second block",blockchain.get(blockchain.size()-1).hash)); 
		System.out.println("Trying to mine second block...");
		blockchain.get(1).mineBlock(difficulty);
		
		blockchain.add(new Block("Third block",blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to mine third block...");
		blockchain.get(2).mineBlock(difficulty);
		
		System.out.println("\nBlockchain is valid: " + isChainValid());
		
		//print out the hashes of each block
		for (int i = 0; i < blockchain.size(); i++) {
			System.out.println("\nHash for block " + (i + 1) + ": " + blockchain.get(i).hash);
			System.out.println("Previous Hash for block " + (i + 1) + ": " + blockchain.get(i).previousHash);
		}
	}
	
	//this function checks if the chain is valid
	public static Boolean isChainValid() {
		Block currentBlock;
		Block previousBlock;
		
		for (int i = 1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//checks if the hash of the current block is correct
			if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
				System.out.println("Current hash value invalid");
				return false;
			}
			//checks if the previous hash value in the current block is valid
			if (!currentBlock.previousHash.equals(previousBlock.hash)) {
				System.out.println("Previous hash value invalid");
				return false;
			}
		}
		return true;
	}
}