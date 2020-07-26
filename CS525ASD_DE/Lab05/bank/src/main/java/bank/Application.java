package bank;

import java.util.Collection;

import bank.command.DepositCommand;
import bank.command.HistoryList;
import bank.command.TransferFundsCommand;
import bank.command.WithdrawCommand;
import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.IAccountService;



public class Application {
	public static void main(String[] args) {
		IAccountService accountService = new AccountService();

		HistoryList hlist = new HistoryList();

		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		//use account 1;
//		accountService.deposit(1263862, 240);
		DepositCommand depositCommand1 = new DepositCommand(accountService.getAccountDAO(), 1263862, 240);
		depositCommand1.execute();
		hlist.addCommand(depositCommand1);
//		accountService.deposit(1263862, 529);
		DepositCommand depositCommand2 = new DepositCommand(accountService.getAccountDAO(), 1263862, 529);
		depositCommand2.execute();
		hlist.addCommand(depositCommand2);
//		accountService.withdraw(1263862, 230);
		WithdrawCommand withdrawCommand = new WithdrawCommand(accountService.getAccountDAO(), 1263862, 230);
		withdrawCommand.execute();
		hlist.addCommand(withdrawCommand);
		hlist.undo();
		//use account 2;
//		accountService.deposit(4253892, 12450);
		DepositCommand depositCommand3 = new DepositCommand(accountService.getAccountDAO(), 1263862, 529);
		depositCommand3.execute();
		hlist.addCommand(depositCommand3);
//		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		TransferFundsCommand transferFundsCommand = new TransferFundsCommand(accountService.getAccountDAO(), 4253892, 1263862, 100, "payment of invoice 10232");
		transferFundsCommand.execute();
		hlist.addCommand(transferFundsCommand);
		hlist.undo();
		hlist.redo();
		hlist.redo();
		// show balances
		
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
	}

}


