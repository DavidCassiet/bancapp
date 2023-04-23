package org.example.service;

import org.example.entity.Account;
import org.example.entity.Transaction;
import org.example.entity.Transfer;
import org.example.enums.TransactionType;
import org.example.exception.MyException;
import org.example.repository.TransactionRepository;

import java.util.ArrayList;

public class TransactionService implements TransactionRepository {
    private static final ArrayList<Transaction> transactions = TransactionRepository.transactions;
    private final AccountService accountService;
    private final BranchService branchService;

    public TransactionService(AccountService accountService, BranchService branchService) {
        this.accountService = accountService;
        this.branchService = branchService;
    }

    public void makeTransaction(TransactionType type, double amount, int branchId, String accountCBU) throws MyException {
        Account objAccount = accountService.getAccountByCBU(accountCBU);
        branchService.getBranchById(branchId);
        boolean transactionMade = false;

        if (type == TransactionType.DEPOSIT) {
            deposit(objAccount, amount);
            transactionMade = true;
        } else if (type == TransactionType.WITHDRAW) {
            if (withdraw(objAccount, amount)) {
                transactionMade = true;
            }
        }

        if (transactionMade) {
            Transaction objTransaction = createTransaction(type, amount, branchId, accountCBU);
            transactions.add(objTransaction);
            objAccount.addTransaction(objTransaction);
        }
    }

    public void makeTransaction(double amount, int branchId, String senderCBU, String recipientCBU) throws MyException {
        Account objSenderAcc = accountService.getAccountByCBU(senderCBU);
        Account objRecipientAcc = accountService.getAccountByCBU(recipientCBU);
        branchService.getBranchById(branchId);

        if (transfer(objSenderAcc, objRecipientAcc, amount)) {
            String id = String.valueOf(Math.round((Math.random() * 1000 + 1)));
            Transfer objTransfer = new Transfer(id, TransactionType.TRANSFER, amount, branchId, senderCBU, recipientCBU);

            transactions.add(objTransfer);
            objSenderAcc.addTransaction(objTransfer);
            objRecipientAcc.addTransaction(objTransfer);
        }
    }

    private Transaction createTransaction(TransactionType type, double amount, int branchId, String accountCBU) {
        String id = String.valueOf(Math.round((Math.random() * 1000 + 1)));
        Transaction objTransaction = new Transaction(id, type, amount, branchId, accountCBU);

        return objTransaction;
    }

    public Transaction getTransactionById(String transactionId) throws MyException {
        for (Transaction objTransaction : transactions) {
            if (objTransaction.getId().equals(transactionId)) {
                return objTransaction;
            }
        }
        throw new MyException("Transaccion no encontrada.");
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void deleteTransaction(String transactionId) throws MyException {
        Transaction objTransaction = getTransactionById(transactionId);
        transactions.remove(objTransaction);
    }

    private void deposit(Account objAccount, double amount) {
        double previousBalance = objAccount.getBalance();
        double finalBalance = previousBalance + amount;
        objAccount.setBalance(finalBalance);
    }

    private boolean withdraw(Account objAccount, double amount) {
        double previousBalance = objAccount.getBalance();

        if (previousBalance >= amount) {
            double finalBalance = previousBalance - amount;
            objAccount.setBalance(finalBalance);

            return true;
        }
        return false;
    }

    private boolean transfer(Account objSenderAcc, Account objRecipientAcc, double amount) {
        if (withdraw(objSenderAcc, amount)) {
            deposit(objRecipientAcc, amount);
            return true;
        }
        return false;
    }
}
