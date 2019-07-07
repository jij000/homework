package edu.mum.cs544.bank.logging;

import org.springframework.stereotype.Repository;

@Repository
public class Logger implements ILogger {

	public void log(String logstring) {
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);
	}
}
