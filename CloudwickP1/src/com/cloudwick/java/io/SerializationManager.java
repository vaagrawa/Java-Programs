package com.cloudwick.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationManager {

	public static void main(String[] args) throws FileExistsException {
		// TODO Auto-generated method stub
		serializedata();
		try {
			deserializedata();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void serializedata() throws FileExistsException {
		System.out.println(Thread.currentThread());
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			File f = new File("serialize.txt");
			if(f.exists()){
				throw new FileExistsException("File already found :P");
			}
			fos = new FileOutputStream("serialize.txt");
			
			//FileOutputStream is wrapped by the object output stream.
			out = new ObjectOutputStream(fos);
			//Set the input to new user object
			User obj = new User();
			obj.setAge(24);
			obj.setName("Vaibhav");
			//Serialize the obj object
			out.writeObject(obj);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fos!=null)
			{
				try {
					// First let the JVM write the contents to the file
					fos.flush();
					// Close the connection
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	private static void deserializedata() throws IOException, ClassNotFoundException {

		FileInputStream fin =new FileInputStream("serialize.txt");
		ObjectInputStream oin = new ObjectInputStream(fin);
		
		User obj1 = (User) oin.readObject();
		System.out.println("THe Age: "+obj1.getAge());
		System.out.println("the Name: "+ obj1.getName());
		oin.close();
		
	}

}
