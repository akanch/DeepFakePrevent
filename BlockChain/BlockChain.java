import java.util.Arrays;
import java.util.ArrayList;

public class BlockChain {
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	
	public static void main(String[] args) {	
		//add our blocks to the blockchain ArrayList:
		blockchain.add(new Block("first block", "0"));		
		blockchain.add(new Block("second block",blockchain.get(blockchain.size()-1).hash)); 
		blockchain.add(new Block("third block",blockchain.get(blockchain.size()-1).hash));
		
		System.out.println(Arrays.toString(blockchain.toArray()));
	}
	
	//this function checks the chain is valid
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