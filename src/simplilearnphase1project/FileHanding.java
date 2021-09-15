package simplilearnphase1project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class FileHandling {
	
	// Method for create new file
	
	public void createFile(String fileName) {
		File file = new File("files//"+fileName);
		System.out.println(file.getAbsolutePath());
		if(file.exists()) {
			System.out.println("A file with this name already exists please try with another name !");
		} else {
			try {
				file.createNewFile();
				System.out.println("File with name " + fileName + " is created successfully !");
			} catch(IOException e) {
				System.out.println("An error has been occured : ");
				e.printStackTrace();
			}
		}
	}
	
	// Method for delete file
	
	public void deleteFile(String fileName) throws IOException {
		File file = new File("files//"+fileName);
		if(file.exists()) {
			file.delete();
			System.out.println("File deleted successfully !");
		} else {
			System.out.println("File with this name is not exists in this directory please try with correct name !");
		}
	}
	
	// Method for search file
	
	public void searchFile(String fileName) {
		File file = new File("files//"+fileName);
		if(file.exists()) {
			System.out.println("A file with same name found in this directory !");
		} else {
			System.out.println("No file found with this name in this directory !");
		}
	}
	
	// Method for display files in ascending order
	
	public void displayFiles() {
		File folder = new File("files//");
		
		File [] listOfFiles = folder.listFiles();
		
		//You can add if else statement for checking directory is empty or not
		// Taking the name of files in string array
		
		String [] fileNames = new String[listOfFiles.length];
		
		for(int i = 0; i < fileNames.length; i++) {
			fileNames[i] = listOfFiles[i].getName();
		}
		
		// Sorting file names
		
		for(int i = 0; i < fileNames.length; i++) {
			for(int j = i+1; j < fileNames.length; j++) {
				if(fileNames[i].compareTo(fileNames[j])>0) {
					String temp = fileNames[i];
					fileNames[i] = fileNames[j];
					fileNames[j] = temp;
				}
			}
		}
		
		// Printing file names
		
		for(int k = 0; k < fileNames.length; k++) {
			System.out.print(fileNames[k] + " ");
		}
		
		System.out.println();
	}
	
	// Method for write in file
	
	public void write(String fileName, String data) throws IOException {
		File file = new File("files//"+fileName);
		PrintWriter pw = new PrintWriter(new FileWriter(file, true));
		pw.print(data);
		pw.close();
	}
}
