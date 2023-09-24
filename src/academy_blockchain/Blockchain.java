package academy_blockchain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;

import com.google.gson.GsonBuilder;


public class Blockchain {
	
		//data structure 
		private static LinkedList<Block> db = new LinkedList<>();
		
		public static final String MasterDir ="src/masterFile";
		// master-binary-file
	    public static final String MASTER_BLOCKCHAIN = MasterDir + "/Aca_Blockchain.txt";

	    // ledger-file
	    public static final String MASTER_LEDGER = MasterDir + "/Aca_Ledger.txt";
		//
		/**
		 *  singleton pattern
		 */
		private static Blockchain _instance;
	    public static Blockchain getInstance( String chainFile ) {
			if(_instance == null)
				_instance = new Blockchain( chainFile );
			return _instance;
		}
		
		public String chainFile;
		
		public Blockchain(String chainFile) {
			super();
			this.chainFile = chainFile;
			System.out.println("> Blockchain object is created!");
		}
		
		/**
		 * genesis()
		 */
		public static void genesis() 
		{
			Block genesis = new Block("0","0");
			db.add(genesis);
			persist();

		}
		
		/**
		 * nextBlock()
		 */
		public static void nextBlock(Block newBlock) 
		{
			db = get();
			newBlock.getBlockHeader().setId(db.getLast().getBlockHeader().getIndex() +1);
			db.add(newBlock);
			persist();
		}
		
		/**
		 * get()
		 */
		public static LinkedList<Block> get()
		{
			try( FileInputStream fin = new FileInputStream(MASTER_BLOCKCHAIN); 
				ObjectInputStream in = new ObjectInputStream( fin );
					){
				return (LinkedList<Block>)in.readObject();	
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
				
			}
		}

		/**
		 * persist()
		 */
		public static void persist() 
		{
			try (FileOutputStream fout = new FileOutputStream (MASTER_BLOCKCHAIN);
					ObjectOutputStream out = new ObjectOutputStream ( fout );)		
			{	
				out.writeObject(db);
				System.out.println( ">> Master file is updated!" );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		/**
		 * distribute()
		 */
		public static void distribute() {
			String chain = new GsonBuilder().setPrettyPrinting().create().toJson(db);
			System.out.println( chain );
			
			try {
	            Files.write(Paths.get( MASTER_LEDGER ), chain.getBytes(), StandardOpenOption.CREATE);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}

}
