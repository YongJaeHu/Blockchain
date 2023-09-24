package coursedata;

import java.io.Serializable;

import hash.Hasher;
import studentID_blockchain.StudentID;



public class Block implements Serializable{
    public Header blockHeader;
    public Header getBlockHeader() {
        return blockHeader;
    }
    /* composition relationship */
    public Block(String previousHash) {
        super();
        long now = System.currentTimeMillis();
        /* construct part object upon object construction */
        this.blockHeader = new Header();
        this.blockHeader.setPreviousHash(previousHash);
        this.blockHeader.setTimestamp(now);
        //hashing with sha256 - the input is joined with previousHash+now
//        String currentHash = Hasher.sha256( 
//                String.join("+", previousHash, String.valueOf(now)) );
//        this.blockHeader.setCurrentHash(currentHash);
    }
    /* composition relationship - inner class definition for part object*/
    public class Header implements Serializable{
        //data member
        private int index;
        private String currentHash, previousHash;
        private long timestamp;
        
        @Override
        public String toString() {
            return "Header [index=" + index + ", currentHash=" + currentHash + ", previousHash=" + previousHash
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
        
        
    }
    
    /* aggregation relationship */
    public Course tranxLst;
    public void setTranxLst(Course tranxLst) {
        this.tranxLst = tranxLst;
    }
    public Course getTransaction() {
        return tranxLst;
    }
    
    @Override
    public String toString() {
        return "Block [blockHeader=" + blockHeader + ", tranxLst=" + tranxLst + "]";
    }
    
    
}
