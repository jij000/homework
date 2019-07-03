package edu.mum.cs544.bank.dao;

import edu.mum.cs544.bank.EntityManagerHelper;
import edu.mum.cs544.bank.domain.Account;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import java.util.Collection;

public class JPAAccountDAO implements IAccountDAO {
//    Collection<Account> accountlist = new ArrayList<Account>();

    public void saveAccount(Account account) {
        // System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
//        accountlist.add(account); // add the new
        EntityManagerHelper.getCurrent().persist(account);
    }

    public void updateAccount(Account account) {
        // System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
//        Account accountexist = loadAccount(account.getAccountnumber());
//        if (accountexist != null) {
//            accountlist.remove(accountexist); // remove the old
//            accountlist.add(account); // add the new
//        }
        EntityManagerHelper.getCurrent().merge(account);
    }

    public Account loadAccount(long accountnumber) {
        // System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
//        for (Account account : accountlist) {
//            if (account.getAccountnumber() == accountnumber) {
//                return account;
//            }
//        }
//        return null;
        TypedQuery<Account> query = EntityManagerHelper.getCurrent()
                .createQuery("from Account a " +
//                .createQuery("from Account a left join fetch a.entryList el " +
                "where a.accountnumber = :accountnumber", Account.class);
        EntityGraph<Account> graph =
                EntityManagerHelper.getCurrent().createEntityGraph(Account.class);
        graph.addAttributeNodes("entryList");
        query.setHint("javax.persistence.fetchgraph", graph);
        query.setParameter("accountnumber", accountnumber);
        return query.getSingleResult();
    }

    public Collection<Account> getAccounts() {
//        return accountlist;
        TypedQuery<Account> query = EntityManagerHelper.getCurrent()
                .createQuery("from Account a ", Account.class);
//                .createQuery("select distinct a from Account a left join fetch a.entryList el ", Account.class);
        EntityGraph<Account> graph =
                EntityManagerHelper.getCurrent().createEntityGraph(Account.class);
        graph.addAttributeNodes("entryList");
        query.setHint("javax.persistence.fetchgraph", graph);
        return query.getResultList();
    }

}
