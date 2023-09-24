package coursedata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Course implements Serializable{
    private final int SIZE = 10;
    
    /* we will come back for creating merkle root in another session */
    private String merkleRoot = "0";
    
    private List<String> dataLst = new ArrayList<>();
    
    public void add(String tranx) {
        if( dataLst.size() < SIZE )
            dataLst.add(tranx);
    }
    public List<String> getTranxLst() {
        return dataLst;
    }
    @Override
    public String toString() {
        return "Course [merkleRoot=" + merkleRoot + ", dataLst=" + dataLst + "]";
    }
    
}
