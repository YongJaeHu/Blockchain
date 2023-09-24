package studentID_blockchain;

import java.io.Serializable;

import hash.Hasher;



public class Block implements Serializable{
	
	private static int blockCount; // static variable to keep track of block count

	public Header blockHeader;
    public Header getBlockHeader() {
        return blockHeader;
    }

    /* composition relationship */
    public Block(String previousHash, String merkleRoot) {
        super();
        long now = System.currentTimeMillis();
        /* construct part object upon object construction */
        this.blockHeader = new Header();
        this.blockHeader.setPreviousHash(previousHash);
        this.blockHeader.setTimestamp(now);
        this.blockHeader.setIndex(++blockCount); // set the index to the current block count
        //hashing with sha256 - the input is joined with previousHash+now
        String currentHash = Hasher.sha256( 
                String.join("+", previousHash, String.valueOf(now), merkleRoot) );
        this.blockHeader.setCurrentHash(currentHash);
    }
    
    /* composition relationship - inner class definition for part object*/
    public class Header implements Serializable{
    	
        //data member
    	
        public int id;
        public String currentHash, previousHash;
        public long timestamp;     
        @Override
        public String toString() {
            return "Header [id=" + id + ", currentHash=" + currentHash + ", previousHash=" + previousHash
                    + ", timestamp=" + timestamp + "]";
        }
        
        //getset methods
        public String getCurrentHash() {
            return currentHash;
        }
        public void setCurrentHash(String currentHash) {
            this.currentHash = currentHash;
        }
        public String getPreviousHash() {
            return previousHash;
        }
        public void setPreviousHash(String previousHash) {
            this.previousHash = previousHash;
        }
        public long getTimestamp() {
            return timestamp;
        }
        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
        public int getIndex() {
            return id;
        }
        public void setIndex(int id) {
            this.id = id;
        }
    }
    
    /* aggregation relationship */
    public StudentID tranxLst;
    public void setTranxLst(StudentID tranxLst) {
        this.tranxLst = tranxLst;
    }
    public StudentID getTransaction() {
        return tranxLst;
    }
    
    @Override
    public String toString() {
        return "Block [blockHeader=" + blockHeader + ", StudentIDLst=" + tranxLst + "]";
    }   
}
