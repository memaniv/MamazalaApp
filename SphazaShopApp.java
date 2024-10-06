import java.util.Scanner;

public class SphazaShopApp{
	public static void main(String[] args){
		//declare variables
		int choice;
		char response = 'N';
		boolean tryAgain = false;
		String username, password;
		Scanner sc = new Scanner(System.in);
		
		do {		
			//prompt for password
			System.out.print("\nPlease enter username: ");
			username = sc.next();
			System.out.print("Please enter password: ");
			password = sc.next();
			
			if(username.equals("owner") && password.equals("123")){
				System.out.println("\nWelcome Mamazala...");
				
				//display menu
				System.out.print("\nPlease select one of the following options: " + "\n" +
								   "1 - view current stock" + "\n" +
								   "2 - update stock" +
								   "3 - view best selling stock item" + "\n" +
								   "4 - view least selling stock item" + "\n" +
								   "5 - view total amount made" + "\n" +
								   "6 - exit" + "\n" + 							   
								   "Your choice: ");
				choice = sc.nextInt();
				
				while(choice != 6){
					switch(choice){
						case 1:
							System.out.println("\nView stock...");
							break;
						case 2:
							System.out.println("\nUpdate stock...");
							break;
						case 3:
							System.out.println("\nView best selling stock item...");
							break;
						case 4:
							System.out.println("\nView least selling stock item...");
							break;
						case 5:
							System.out.println("\nView total amount made...");
							break;
						default:
							System.out.println("\n" + choice + " is invalid.");
					}
					
					//display menu again
					System.out.print("\nPlease select one of the following options: " + "\n" +
									   "1 - view current stock" + "\n" +
									   "2 - update stock" +
									   "3 - view best selling stock item" + "\n" +
									   "4 - view least selling stock item" + "\n" +
									   "5 - view total amount made" + "\n" +
									   "6 - exit" + "\n" + 							   
									   "Your choice: ");
					choice = sc.nextInt();
				}
			} else if(username.equals("employee") && password.equals("123")){
				System.out.println("\nWelcome...");
				
				//display menu
				System.out.print("\nPlease select one of the following options: " + "\n" +
								   "1 - sell items" + "\n" +
								   "2 - exit" + "\n" + 							   
								   "Your choice: ");
				choice = sc.nextInt();
				
				while(choice != 2){
					if(choice == 1){
						//sell
						System.out.println("\nSell items...");
					} else {
						System.out.println("\n" + choice + " is invalid.");
					}
					
					//display menu again
					System.out.print("\nPlease select one of the following options: " + "\n" +
									   "1 - sell items" + "\n" +
									   "2 - exit" + "\n" + 							   
									   "Your choice: ");
					choice = sc.nextInt();
				}
			} else {
				System.out.println("\nInvalid login details.");
				System.out.print("Do you want to try again? Y/N: ");
				response = Character.toUpperCase(sc.next().charAt(0));
				
				if(response == 'Y'){
					tryAgain = true;
				} else {
					tryAgain = false;
				}
			}
		} while(tryAgain);
		
		System.out.println("\nGoodBye!!!");
	}
}
