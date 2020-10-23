package ATM;


import java.util.ArrayList;

public class account {
	

	private String accType;

	private int uuid;

	private int accountNumber;

//	private user holder;
	
	private int balance = 0 ; 

	private ArrayList<Transaction> transactions;
	
	public account(int uuid, int accNumber, String accType, int balance) {
		
		// set the account number and type
		this.accType = accType;
		this.accountNumber=accNumber;
		this.uuid=uuid;
		this.balance=balance;

	//	this.holder = holder;
		
		
		
		// get next account UUID
		//this.uuid = theBank.getNewAccountUUID();
		
		// init transactions
		this.transactions = new ArrayList<Transaction>();
		
	}
	

	/**
	 * Get the account number.
	 * @return	the uuid
	*/ 
	public int getUUID() {
		return this.uuid;
	}
	
	/**
	 * Add a new transaction in this account.
	 * @param amount	the amount transacted
	 */
	public void addTransaction(double amount) {
		
		// create new transaction and add it to our list
		Transaction newTrans = new Transaction(amount, this);
		this.transactions.add(newTrans);
		
	}
	
	public void addTransaction(double amount, String memo) {
		
		// create new transaction and add it to our list
		Transaction newTrans = new Transaction(amount, memo, this);
		this.transactions.add(newTrans);
		 balance += amount ;
		
	}
	
	// deposit 
	
	
	// withdraw 
	
	
	// transfer ->> consult bank and get back the toAccount Object  
	
	/**
	 * Get the balance of this account by adding the amounts of the 
	 * transactions.
	 * @return	the balance value
	 */
	public double getBalance() {
		
//		double balance = 0;
//		for (Transaction t : this.transactions) {
//			balance += t.getAmount();
//		}
		return balance;
		
	}
	
	/**
	 * Get summary line for account
	 * @return	the summary line
	 */
	public String getSummaryLine() {
		
		// get the account's balance
		double balance = this.getBalance();
		
		// format summary line depending on whether balance is negative
		if (balance >= 0) {
			return String.format("%s : $%.02f : %d", this.uuid, balance, 
					this.accountNumber);
		} else {
			return String.format("%s : $(%.02f) : %d", this.uuid, balance, 
					this.accountNumber);
		}
		
	}
	
	/**
	 * Print transaction history for account
	 */
	public void printTransHistory() {
		
		System.out.printf("\nTransaction history for account %s\n", this.accountNumber);
		for (int t = this.transactions.size()-1; t >= 0; t--) {
			System.out.println(this.transactions.get(t).getSummaryLine());
		}
		System.out.println();
		
	}


	public int getAccountID() {
		// TODO Auto-generated method stub
		return accountNumber;
	}

}

