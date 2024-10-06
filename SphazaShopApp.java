import java.util.Scanner;

public class SphazaShopApp{
	public static void main(String[] args){
		//declare variables
		int choice, qty, qtyAtI, qtyAtJ;
		double unitPrice, amountMade, unitPriceAtI, unitPriceAtJ, amountMadeFromItemAtI, amountMadeFromItemAtJ;
		char response = 'N';
		boolean tryAgain = false;
		String username, password, item, code, itemAtI, itemAtJ, codeAtI, codeAtJ;
		Scanner sc = new Scanner(System.in);
		String[] items = {"Brown Bread", "White Bread", "Atchar", "Eggs", "Milk", "Colgate"};
		String[] codes = {"BB", "WB", "AR", "EG", "MK", "CO"};
		int[] quantities	   = {10, 20, 25, 40, 5, 35};
		double[] unitPrices = {15.50, 12.50, 16.79, 99.99, 38.99, 16.00};
		double[] amountMadePerItem = {15.50, 12.50, 16.79, 99.99, 38.99, 16.00};
		
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
								   "2 - update stock" + "\n" +
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
							
							for(int i = 0; i < items.length; i++){
								item = items[i];
								code = codes[i];
								qty = quantities[i];
								unitPrice = unitPrices[i];
								
								System.out.println("\nDetails of item " + (i + 1) + "\n" +
												   "Item: " + item + "\n" +
												   "Code: " + code + "\n" +
												   "Quantity: " + qty + "\n" +
												   "Unit price: R" + unitPrice);
							}
							break;
						case 2:
							System.out.println("\nUpdate stock...");
							
							System.out.print("Please enter item code: ");
							code = sc.next();
							
							//check if code is existent
							int index = 0;
							while((index < items.length) && (!codes[index].equals(code))){
								index++;
							}
							
							if(index != items.length){
								//item found. get quantity at the inde						
								System.out.print("Update quantity by how much? ");
								qty = sc.nextInt();
								
								//determine new quantity
								qty = qty + quantities[index];
								
								//store
								quantities[index] = qty;
							} else {
								System.out.println("\nItem code " + code + " not found");
							}
							
							break;
						case 3:
							System.out.println("\nView best selling stock item...");
							
							//sort the items first
							for(int i = 0; i < amountMadePerItem.length -1; i++){
								for(int j = i + 1; j < amountMadePerItem.length; j++){
									amountMadeFromItemAtI = amountMadePerItem[i];
									amountMadeFromItemAtJ = amountMadePerItem[j];
									
									if(amountMadeFromItemAtI < amountMadeFromItemAtJ){
										amountMadePerItem[i] = amountMadeFromItemAtJ;
										amountMadePerItem[j] = amountMadeFromItemAtI;
										
										itemAtI = items[i];
										itemAtJ = items[j];
										
										codeAtI = codes[i];
										codeAtJ = codes[j];
										
										qtyAtI = quantities[i];
										qtyAtJ = quantities[j];
										
										unitPriceAtI = unitPrices[i];
										unitPriceAtJ = unitPrices[j];
										
										//swap										
										items[i] = itemAtJ;
										items[j] = itemAtI;
										
										codes[i] = codeAtJ;
										codes[j] = codeAtI;
										
										quantities[i] = qtyAtJ;
										quantities[j] = qtyAtI;
										
										unitPrices[i] = unitPriceAtJ;
										unitPrices[j] = unitPriceAtI;
									}
								}
							}
							
							//best selling item
							item = items[0];
							code = codes[0];
							amountMade = amountMadePerItem[0];
							
							System.out.println("\nDetails of best selling item " + "\n" +
												   "Item: " + item + "\n" +
												   "Code: " + code + "\n" +
												   "Amount made: R" + amountMade);
							break;
						case 4:
							System.out.println("\nView least selling stock item...");
							
							//sort the items first
							for(int i = 0; i < amountMadePerItem.length -1; i++){
								for(int j = i + 1; j < amountMadePerItem.length; j++){
									amountMadeFromItemAtI = amountMadePerItem[i];
									amountMadeFromItemAtJ = amountMadePerItem[j];
									
									if(amountMadeFromItemAtI < amountMadeFromItemAtJ){
										amountMadePerItem[i] = amountMadeFromItemAtJ;
										amountMadePerItem[j] = amountMadeFromItemAtI;
										
										itemAtI = items[i];
										itemAtJ = items[j];
										
										codeAtI = codes[i];
										codeAtJ = codes[j];
										
										qtyAtI = quantities[i];
										qtyAtJ = quantities[j];
										
										unitPriceAtI = unitPrices[i];
										unitPriceAtJ = unitPrices[j];
										
										//swap										
										items[i] = itemAtJ;
										items[j] = itemAtI;
										
										codes[i] = codeAtJ;
										codes[j] = codeAtI;
										
										quantities[i] = qtyAtJ;
										quantities[j] = qtyAtI;
										
										unitPrices[i] = unitPriceAtJ;
										unitPrices[j] = unitPriceAtI;
									}
								}
							}
							
							//best selling item
							item = items[items.length -1];
							code = codes[items.length -1];
							amountMade = amountMadePerItem[items.length -1];
							
							System.out.println("\nDetails of least selling item " + "\n" +
												   "Item: " + item + "\n" +
												   "Code: " + code + "\n" +
												   "Amount made: R" + amountMade);
							break;
						case 5:
							System.out.println("\nView total amount made...");
							double tot = 0;
							
							for(int i = 0; i < amountMadePerItem.length; i++){
								amountMade = amountMadePerItem[i];
								tot =  tot + amountMade;
							}
							
							System.out.println("The total amount made today is R" + tot);
							
							break;
						default:
							System.out.println("\n" + choice + " is invalid.");
					}
					
					//display menu again
					System.out.print("\nPlease select one of the following options: " + "\n" +
									   "1 - view current stock" + "\n" +
									   "2 - update stock" + "\n" +
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
