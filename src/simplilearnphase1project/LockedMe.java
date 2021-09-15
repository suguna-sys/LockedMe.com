package simplilearnphase1project;

import java.io.IOException;
import java.util.Scanner;

public class LockedMe {
	
	// Print stars
	
	public void printStars() {
		int i = 0;
		while(i < 10) {
			System.out.print("*");
			i++;
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		WelcomeScreen welcome_screen = new WelcomeScreen();
		FileHandling file_handling = new FileHandling();
		LockedMe lockedMe = new LockedMe();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		welcome_screen.welcomeScreen();
		lockedMe.printStars();
		String file_name;
		boolean innerStatus = true;
		boolean status = true;
		
		while(status) {
			welcome_screen.optionScreen();
			lockedMe.printStars();
			System.out.println("Please select an option what you want do : ");
			int choice = scanner.nextInt();
			
			// Switch statement
			
			switch(choice) {
			case 1:
				file_handling.displayFiles();
				break;
				
			case 2:
				innerStatus = true;
				while(innerStatus) {
					welcome_screen.innerOptionScreen();
					lockedMe.printStars();
					System.out.println();
					System.out.println("Please enter your choice : ");
					int innerChoice = scanner.nextInt();
					
					// Inner Switch statement
					
					switch(innerChoice) {
					case 1:
						System.out.println("Please enter file name : ");
						file_name = scanner.next();
						scanner.nextLine();
						file_handling.createFile(file_name);
						lockedMe.printStars();
						System.out.println();
						System.out.println("If you want to add something in file please yes or no (Y/N) or (y/n) :");
						char innerAction = scanner.next().charAt(0);
						scanner.nextLine();
						
						while(true) {
							if(innerAction == 'y' || innerAction == 'Y') {
								System.out.println("Please enter what you want to add in file : ");
								String data = scanner.next();
								scanner.nextLine();
								file_handling.write(file_name, data);
								break;
							}
							if(innerAction == 'n' || innerAction == 'N') {
								break;
							}
							
							else {
								System.out.println("Please select a correct option (Y/N) or (y/n) : ");
								innerAction = scanner.next().charAt(0);
								scanner.nextLine();
							}
						}
						
						break;
						
						
					case 2:
						System.out.println("Please enter the file name which you want to delete : ");
						file_name = scanner.next();
						scanner.nextLine();
						file_handling.deleteFile(file_name);
						lockedMe.printStars();
						System.out.println();
						break;
						
					case 3:
						System.out.println("Please enter file name which you want to search : ");
						file_name = scanner.next();
						scanner.nextLine();
						file_handling.searchFile(file_name);
						lockedMe.printStars();
						System.out.println();
						break;
						
					case 4:
						innerStatus = false;
						break;
						
					default:
						System.out.println("Please choose a correct option !");
						lockedMe.printStars();
						System.out.println();
						break;
						
					// End inner switch statement
					}
				}
				break;
				
			case 3:
				System.out.println("Application closed successfully ! ");
				lockedMe.printStars();
				System.out.println();
				System.exit(0);
				break;
				
			default:
				System.out.println("Please select a correct option !");
				lockedMe.printStars();
				System.out.println();
				break;
			}
		}
	}
}