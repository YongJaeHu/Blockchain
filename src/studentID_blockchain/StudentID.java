package studentID_blockchain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class StudentID implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public final int SIZE = 10;
    
    public String merkleRoot = "0";
    
    public String getMerkleRoot() {
    	return merkleRoot;
    }
    
    public void complete() {
    	MerkleTree mt = MerkleTree.getInstance(dataLst);
    	mt.build();
    	this.merkleRoot = mt.getRoot();
    }
    
    public List<String> getTranxLst() {
        return dataLst;
    }
    
    public List<String> dataLst = new ArrayList<>();
    
    public void add(String tranx) {
        if( dataLst.size() < SIZE )
            dataLst.add(tranx);
    }
    
    @Override
    public String toString() {
        return "Student ID [merkleRoot=" + merkleRoot + ", dataLst=" + dataLst + "]";
    }

}
