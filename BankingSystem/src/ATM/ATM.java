package ATM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ATM {

	static String pathToCsv1 = "C:\\Users\\sharif\\Documents\\atm csv files\\userList.csv";
	static String pathToCsv2 = "C:\\Users\\sharif\\Documents\\atm csv files\\accountList.csv";
	private static List<user> userList;
	private static List<account> accountList;

	public static void main(String[] args) {

		// read accountList
		// list of accounts
    	setAccountList(Bank.readcsvaccount(pathToCsv2));

		// read userlist
		// String pathToCsv1 = "C:\\Users\\sharif\\Documents\\atm csv
		// files\\userList.csv";
   		setUserList(Bank.readcsvuser(pathToCsv1));

		// init Scanner
		Scanner sc = new Scanner(System.in);

		// init Bank
		// theBank = new Bank("State Bank Of India");

		// add a user, which also creates a Savings account
		// user aUser = theBank.addUser(UUID,firstName,lastName,pin);

		// add accounts for our user
		/*
		 * account2 newAccount = new account2(Acct_name, aUser, theBank);
		 * aUser.addAccount(newAccount); theBank.addAccount(newAccount);
		 */
		user curUser;

		// continue looping forever
		while (true) {

			// stay in login prompt until successful login
			curUser = mainMenuPrompt();

			// stay in main menu until user quits
			printUserMenu(curUser);

		}

	}

/*	public static List<user> readcsvuser(String pathToCsv) {
		BufferedReader csvReader = null;
		String row;
		List<user> userList = new ArrayList<user>();

		System.out.println("READING USER ");

		try {
			csvReader = new BufferedReader(new FileReader(pathToCsv));
			row = csvReader.readLine(); // skip the first line
			// Assuming the following order of cols: ID, Name, Fees

			while ((row = csvReader.readLine()) != null) {

				System.out.println(row);

				String[] data = row.split(",");

				int id = Integer.parseInt(data[0]);
				String firstname = data[1];
				String lastname = data[2];
				int pin = Integer.parseInt(data[3]);

				user s1 = new user(id, firstname, lastname, pin);

				for (account acc : accountList) {
					if (s1.getUUID() == acc.getUUID()) {
//						System.out.println(acc.getUUID() + "|" + s1.getUUID());
						s1.addAccount(acc);
					}

				}

				userList.add(s1);

				System.out.println("Check Account list " + s1.getAccountList());

//				for (String str : data)
//					System.out.print(str + " | ");
//				System.out.println();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				csvReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userList;
	}

	public static List<account> readcsvaccount(String pathToCsv) {
		BufferedReader csvReader = null;
		String row;
		List<account> accountList = new ArrayList<account>();

		System.out.println("READING ACCOUNTS");

		try {
			csvReader = new BufferedReader(new FileReader(pathToCsv));
			row = csvReader.readLine(); // skip the first line
			// Assuming the following order of cols: ID, Name, Fees

			while ((row = csvReader.readLine()) != null) {

				// System.out.println(row);

				String[] data = row.split(",");

				int id = Integer.parseInt(data[0]);
				int accNumber = Integer.parseInt(data[1]);
				String accType = data[2];
				int balance= Integer.parseInt(data[3]);

				account s1 = new account(id, accNumber, accType, balance);
				accountList.add(s1);

//				System.out.println(s1.getSummaryLine());  

//				for (String str : data)
//					System.out.print(str + " | ");
//				System.out.println();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				csvReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		System.out.println(accountList);
		return accountList;
	}

	public static user userLogin(int userID, int pin) {

//		List<user> userList = readcsvuser(pathToCsv1);

		// search through list of users
		for (user u : userList) {

			// if we find the user, and the pin is correct, return User object
			if (u.getUUID() == userID && u.getPin() == pin) {
				return u;
			}
		}
		return null;
	}

	/**
	 * Print the ATM's login menu.
	 * 
	 * @param theBank the Bank object whose accounts to use
	 * @param sc      the Scanner object to use for user input
	 */
	
	public static user mainMenuPrompt() {

		// inits
		int userID;
		int pin;
		user authUser;
		Scanner sc = new Scanner(System.in);

		// prompt user for user ID/pin combo until a correct one is reached
		do {

			System.out.printf("\n\nWelcome.\n\n");
			System.out.print("Enter user ID: ");
			userID = sc.nextInt();
			System.out.print("Enter pin: ");
			pin = sc.nextInt();

			// try to get user object corresponding to ID and pin combo
			authUser = Bank.userLogin(userID, pin);
			if (authUser == null) {
				System.out.println("Incorrect user ID/pin combination. " + "Please try again");
			}

		} while (authUser == null); // continue looping until we have a
									// successful login

		return authUser;

	}

	/**
	 * Print the ATM's menu for user actions.
	 * 
	 * @param theUser the logged-in User object
	 * @param sc      the Scanner object to use for user input
	 */
	public static void printUserMenu(user theUser) {

		// print a summary of the user's accounts
		//theUser.printAccountsSummary();
		Scanner sc = new Scanner(System.in);

		// init
		int choice;

		// user menu
		do {
			
			System.out.println();
			System.out.println("Welcome "+theUser.getFirstName());
			System.out.println("What would you like to do?");
			System.out.println("  1) Show account transaction history");
			System.out.println("  2) Withdraw");
			System.out.println("  3) Deposit");
			System.out.println("  4) Transfer");
			System.out.println("  5) Add new Account");
			System.out.println("  6) Accounts Summary");
			System.out.println("  7) Quit");
			System.out.println();
			System.out.print("Enter choice: ");
			choice = sc.nextInt();

			if (choice < 1 || choice > 7) {
				System.out.println("Invalid choice. Please choose 1-7.");
			}

		} while (choice < 1 || choice > 7);
		
		//theUser.printAccountsSummary();


		// process the choice
		switch (choice) {

		case 1:
			Bank.showTransHistory(theUser, sc);
			theUser.printAccountsSummary();
			break;
		case 2:
			theUser.printAccountsSummary();
		    Bank.withdrawFunds(theUser, sc);
			break;
		case 3:
			theUser.printAccountsSummary();
			Bank.depositFunds(theUser);
			break;
		case 4:
			theUser.printAccountsSummary();
			Bank.transferFunds(theUser);
			break;
		case 5:
			Bank.addNewAccount(theUser,sc);
			theUser.printAccountsSummary();
			break;
		case 6:
			theUser.printAccountsSummary();
			break;
		case 7:
			// gobble up rest of previous input
			sc.nextLine();
			break;
		}

		// redisplay this menu unless the user wants to quit
		if (choice != 7) {
			ATM.printUserMenu(theUser);
			
	
		}

	}

	public static List<account> getAccountList() {
		return accountList;
	}

	public static void setAccountList(List<account> accountList) {
		ATM.accountList = accountList;
	}

	public static List<user> getUserList() {
		return userList;
	}

	public static void setUserList(List<user> userList) {
		ATM.userList = userList;
	}
}	

/*	public static void withdrawFunds(user theUser, Scanner sc) {

		
		double amount;
		double acctBal;
		String memo;
		
		
		// show list of account

				int i = 1;
				HashMap<Integer, account> selection = new HashMap<Integer, account>();
				
				System.out.println(theUser.getAccountList());
				for (account acc : theUser.getAccountList()) {
					selection.put(i, acc);

					System.out.println(i + ": " + acc.getAccountID() + "," + acc.getBalance());
					++i;
				}

				// choose which account to withdraw from
				int select = 0;
				do {
					System.out.printf("Select the account to withdraw from.");
					select = sc.nextInt();
					if (select < 1 || select > selection.size()) {
						System.out.println(select + " --- Wrong selection");
					}
					System.out.println("You selected:" + select);
				} while (select < 1 && select > selection.size());


		

		// get amount to withdraw
		do {
			acctBal=selection.get(select).getBalance();
			System.out.printf("Enter the amount to withdraw (max $%.02f): $",acctBal);
			amount = sc.nextDouble();
			if (amount < 0) {
				System.out.println("Amount must be greater than zero.");
			} else if (amount > acctBal) {
				System.out.printf("Amount must not be greater than balance " + "of $%.02f.\n", acctBal);
			}
		} while (amount < 0 || amount > acctBal);

		// gobble up rest of previous input
		sc.nextLine();

		// get a memo
		System.out.print("Enter a memo: ");
		memo = sc.nextLine();

		// do the withdrawal
		theUser.addAcctTransaction(selection.get(select),-1 * amount, memo);

	}

	/**
	 * Process a fund deposit to an account.
	 * 
	 * @param theUser the logged-in User object
	 * @param sc      the Scanner object used for user input
	 */
/*	public static void depositFunds(user theUser) {

		double amount;
		String memo;
		Scanner sc = new Scanner(System.in);

		// show list of account

		int i = 1;
		HashMap<Integer, account> selection = new HashMap<Integer, account>();

		System.out.println(theUser.getAccountList());
		for (account acc : theUser.getAccountList()) {
			selection.put(i, acc);

			System.out.println(i + ": " + acc.getAccountID() + "," + acc.getBalance());
			++i;
		}

		// choose which account
		int select = 0;
		do {
			System.out.printf("Select the account to deposit to.");
			select = sc.nextInt();
			if (select < 1 || select > selection.size()) {
				System.out.println(select + " --- Wrong selection");
			}
			System.out.println("You selected:" + select);
		} while (select < 1 && select > selection.size());

		// // enter amount to deposit
		do {
			System.out.printf("Enter the amount to deposit: $");
			amount = sc.nextDouble();
			if (amount < 0) {
				System.out.println("Amount must be greater than zero.");
			}
		} while (amount < 0);

		// gobble up rest of previous input
		sc.nextLine();

		// get a memo
		System.out.print("Enter a memo: ");
		memo = sc.nextLine();

		// do the deposit
		theUser.addAcctTransaction(selection.get(select), amount, memo);

	}

	/**
	 * Show the transaction history for an account.
	 * 
	 * @param theUser the logged-in User object
	 * @param sc      the Scanner object used for user input
	 */
/*	public static void showTransHistory(user theUser, Scanner sc) {


		// get account whose transactions to print
		// show list of account

				int i = 1;
				HashMap<Integer, account> selection = new HashMap<Integer, account>();

				System.out.println(theUser.getAccountList());
				for (account acc : theUser.getAccountList()) {
					selection.put(i, acc);

					System.out.println(i + ": " + acc.getAccountID() + "," + acc.getBalance());
					++i;
				}

				// choose which account
				int select = 0;
				do {
					System.out.printf("Select the account for transaction history.");
					select = sc.nextInt();
					if (select < 1 || select > selection.size()) {
						System.out.println(select + " --- Wrong selection");
					}
					System.out.println("You selected:" + select);
				} while (select < 1 && select > selection.size());

		// print the transaction history
		theUser.printAcctTransHistory(selection.get(select));

	}
	
	
	
	
	
public static void transferFunds(user theUser) {

		
		
		double amount;
		String memo;
		Scanner sc = new Scanner(System.in);

		// show list of account

		int i = 1;
		HashMap<Integer, account> selection = new HashMap<Integer, account>();

		System.out.println(theUser.getAccountList());
		for (account acc : theUser.getAccountList()) {
			selection.put(i, acc);

			System.out.println(i + ": " + acc.getAccountID() + "," + acc.getBalance());
			++i;
		}

		// choose which account
		int select = 0;
		do {
			System.out.printf("Select the account to transfer from.");
			select = sc.nextInt();
			if (select < 1 || select > selection.size()) {
				System.out.println(select + " --- Wrong selection");
			}
			System.out.println("You selected:" + select);
		} while (select < 1 && select > selection.size());
		
		
		 int select1 = 0;
		do {
			System.out.printf("Select the account to deposit to.");
			select1 = sc.nextInt();
			if (select1 < 1 || select1 > selection.size()) {
				System.out.println(select + " --- Wrong selection");
			}
			System.out.println("You selected:" + select);
		} while (select1 < 1 && select1 > selection.size());


		// // enter amount to deposit
		do {
			System.out.printf("Enter the amount to deposit: $");
			amount = sc.nextDouble();
			if (amount < 0) {
				System.out.println("Amount must be greater than zero.");
			}
		} while (amount < 0);

		// gobble up rest of previous input
		sc.nextLine();

		// get a memo
		System.out.print("Enter a memo: ");
		memo = sc.nextLine();

	// finally, do the transfer
		   account fromAcct=selection.get(select);
		   account toAcct=selection.get(select1);
			theUser.addAcctTransaction(fromAcct, -1*amount, String.format(
					"Transfer to account %s", toAcct.getAccountID()));
			theUser.addAcctTransaction(toAcct, amount, String.format(
					"Transfer from account %s", fromAcct.getAccountID()));
			
		}



	//add new account

public static void addNewAccount(user theUser, Scanner sc)
{
	int accNumber;
	int balance;
	String accType;
	int id=theUser.getUUID();
	
	System.out.println("enter the acc number : ");
	accNumber=sc.nextInt();
	
	System.out.println("enter the acc balance : ");
	balance=sc.nextInt();
	
	System.out.println("enter the acc Type : ");
	accType=sc.nextLine();
	
	
	
	
	account s1 = new account(id, accNumber, accType, balance);
	theUser.getAccountList().add(s1);

	
	int i = 1;
	HashMap<Integer, account> selection = new HashMap<Integer, account>();

	System.out.println(theUser.getAccountList());
	for (account acc : theUser.getAccountList()) {
		selection.put(i, acc);

		System.out.println(i + ": " + acc.getAccountID() + "," + acc.getBalance());
		++i;
	}
	
	
	
	
	
}
	

}*/
