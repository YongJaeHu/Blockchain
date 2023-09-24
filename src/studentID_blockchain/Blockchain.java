package studentID_blockchain;

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
		public static String masterFolder = "src/studentID_master/";
		public static String fileName = masterFolder+"StudentID_chain.bin";
		public static final String LEDGER_FILE = masterFolder + "StudentID_Ledger.txt";
		
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
			db.add(newBlock);
			persist();
		}
		
		/**
		 * get()
		 */
		public static LinkedList<Block> get()
		{
			try( FileInputStream fin = new FileInputStream(fileName); 
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
		private static void persist() 
		{
			try (FileOutputStream fout = new FileOutputStream (fileName);
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
	            Files.write(Paths.get(LEDGER_FILE), chain.getBytes(), StandardOpenOption.CREATE);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}


}
