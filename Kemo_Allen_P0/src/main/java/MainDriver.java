import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.presentation.ShopFront;
import com.revature.repository.ShopDAO;
import com.revature.repository.ShopDAOImpl;
import com.revature.service.ShopService;

public class MainDriver {
	
	private static ShopDAO shopDao;
	private static ShopService shopService;
	private static ShopFront shopFront;
	private static Scanner scan;
	
	public static void main(String[] args) {
		ShopDAOImpl sd = new ShopDAOImpl();
		
		shopDao = new ShopDAOImpl();
		shopService = new ShopService(shopDao);
		shopFront = new ShopFront(shopService);
		scan = new Scanner(System.in);
		
		boolean runApp = true;
		boolean runMenu = true;
		String input0;
		
		System.out.println("\tWelcome to Allen's Sword Emporium!\n");
		
		//log everyone out
		
		do {
			do {
				runMenu = shopFront.displayMainMenu();
				
			}while(runMenu);
			
			System.out.println("Would you like to go again? (y/n)");
			
			input0 = scan.nextLine();
			
			if(input0.equalsIgnoreCase("y")) {
				runApp = true;
			}
			else {
				runApp = false;
			}
			
		}while(runApp);
		
		scan.close();
		
	}

}
