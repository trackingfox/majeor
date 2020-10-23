package ATM;

import java.util.ArrayList;

public class user {

	/**
	 * The first name of the user.
	 */
	private String firstName;
	
	/**
	 * The last name of the user.
	 */
	private String lastName;
	
	/**
	 * The ID number of the user.
	 */
	private int uuid;
	
	/**
	 * The hash of the user's pin number.
	 */
	private int pin;
	
	/**
	 * The list of accounts for this user.
	 */
	private ArrayList<account> accounts;
	
	/**
	 * Create new user
	 * @param firstName	the user's first name
	 * @param lastName	the user's last name
	 * @param pin				the user's account pin number (as a String)
	 * @param theBank		the bank that the User is a customer of
	 */
	public user (int uuid,String firstName, String lastName, int pin) {
		
		// set user's name
		this.firstName = firstName;
		this.lastName = lastName;
		this.pin=pin;
		this.uuid = uuid;
		
		this.accounts=new ArrayList<account>();

		
		// store the pin's MD5 hash, rather than the original value, for 
		// security reasons
		/*try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			this.pinHash = md.digest(pin.getBytes());
		} catch (Exception e) {
			System.err.println("error, caught exeption : " + e.getMessage());
			System.exit(1);
		}*/
		
		
		// create empty list of accounts
		//this.accounts = new ArrayList<account2>();
		
		// print log message
//		System.out.printf("New user %s, %s with ID %s created.\n", lastName, firstName, this.uuid);
		
	}
	
	/**
	 * Get the user ID number
	 * @return	the uuid
	 */
	public int getUUID() {
		return this.uuid;
	}
	
	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	/**
	 * Add an account for the user.
	 * @param anAcct	the account to add
	 */
	public void addAccount(account anAcct) {
		this.accounts.add(anAcct);
	}
	
	/**
	 * Get the number of accounts the user has.
	 * @return	the number of accounts
	 */
//	public int numAccounts() {
//		return this.accounts.size();
//	}
//	
	/**
	 * Get the balance of a particular account.
	 * @param acctIdx	the index of the account to use
	 * @return			the balance of the account
	 */
//	public double getAcctBalance(int acctIdx) {
//		return this.accounts.get(acctIdx).getBalance();
//	}
//	
	/**
	 * Get the UUID of a particular account.
	 * @param acctIdx	the index of the account to use
	 * @return			the UUID of the account
	 */
//	public String getAcctUUID(int acctIdx) {
//		return this.accounts.get(acctIdx).getUUID();
//	}
	
	/**
	 * Print transaction history for a particular account.
	 * @param acctIdx	the index of the account to use
	 */
	public void printAcctTransHistory(account selection) {
		selection.printTransHistory();  // Correct but not efficient
	}
	
	/**
	 * Add a transaction to a particular account.
	 * @param acctIdx	the index of the account
	 * @param amount	the amount of the transaction
	 * @param memo		the memo of the transaction
	 */
	public void addAcctTransaction(account acc, double amount, String memo) {
		
		// check if account is in users accounts list --> use hashmap
		if (accounts.contains(acc))
			acc.addTransaction(amount, memo);
		else 
			System.out.println("You dont have access to this account. Sorry!");
	}
	
	/**
	 * Check whether a given pin matches the true User pin
	 * @param aPin	the pin to check
	 * @return		whether the pin is valid or not
	 */
	/*public boolean validatePin(String aPin) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return MessageDigest.isEqual(md.digest(aPin.getBytes()), 
					this.pinHash);
		} catch (Exception e) {
			System.err.println("error, caught exeption : " + e.getMessage());
			System.exit(1);
		}
		
		return false;
	}
	
	/**
	 * Print summaries for the accounts of this user.
	 */
	public void printAccountsSummary() {
		
		System.out.printf("\n\n%s's accounts summary\n", this.firstName);
		for (int a = 0; a < this.accounts.size(); a++) {
			System.out.printf("%d) %s\n", a+1, 
					this.accounts.get(a).getSummaryLine());
		}
		System.out.println();
		
	}

	public String getFirstName() {
		return firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	

	public ArrayList<account> getAccountList() {
		// TODO Auto-generated method stub
		return accounts;
	}
}
