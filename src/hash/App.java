package hash;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	
	private static final byte[] SALT = {-123, 45, 67, 89, -10, 12, -123, 45, 67, 89, -10, 12};
	
	public static void main(String[] args) 
	{
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		// create some sample students
		students.add(new Student("wengjie2000@gmail.com", "A1234567"));
		students.add(new Student( "jane.smith@example.com", "B1234567"));
		
		// hash each student's sensitive data
		for (Student s : students) {
			String saltedData = s.getSensitiveData() + new String(SALT, StandardCharsets.UTF_8); // append the fixed salt to the student data
			String hashedData = Hasher.sha256_salted(saltedData, SALT); // compute the salted SHA-256 hash
			
			s.setHashedData(hashedData); // store the hash value in the student object
			
			System.out.println("Student " + s.getName() + " hashed data: " + hashedData);
		}
		
		// prompt the user for login credentials
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter email:");
		String email = scanner.nextLine();
		System.out.print("Enter password:");
		String password = scanner.nextLine();
		
		// hash the user input
		String saltedData = email + password + new String(SALT, StandardCharsets.UTF_8); // append the fixed salt to the input data
		String hashedData = Hasher.sha256_salted(saltedData, SALT); // compute the salted SHA-256 hash
		System.out.println(" hashed data: " + hashedData);
		
		// compare the hashed input with the hashed data of each student
		boolean found = false;
		for (Student s : students) {
			if (s.getHashedData().equals(hashedData)) {
				System.out.println("Login successful for student " + s.getName());
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Login failed: invalid email or password");
		}
	}

}

class Student {
	private String email;
	private String password;
	private String hashedData;
	
	public Student(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getSensitiveData() {
		return email + password;
	}
	
	public String getName() {
		return email;
	}
	
	public String getHashedData() {
		return hashedData;
	}
	
	public void setHashedData(String hashedData) {
		this.hashedData = hashedData;
	}
}