package org.example.service;

import org.example.entity.Account;
import org.example.entity.Client;
import org.example.enums.AccountType;
import org.example.exception.MyException;
import org.example.repository.AccountRepository;

import java.util.ArrayList;

public class AccountService implements AccountRepository, GeneratorService {
    private static final ArrayList<Account> accounts = AccountRepository.accounts;
    private final BranchService branchService;
    private final ClientService clientService;

    public AccountService(BranchService branchService, ClientService clientService) {
        this.branchService = branchService;
        this.clientService = clientService;
    }

    public Account createAccount(AccountType type, int branchId, String clientId) throws MyException {
        branchService.getBranchById(branchId);
        Client objClient = clientService.getClientById(clientId);

        String number = generateAccNumber(branchId);
        String cbu = generateCBU();
        Account objAccount = new Account(number, cbu, type, String.valueOf(branchId), clientId);
        accounts.add(objAccount);
        objClient.addAccount(objAccount);

        return objAccount;
    }

    public Account getAccountByNumber(String accountNumber) throws MyException {
        for (Account objAccount : accounts) {
            if (objAccount.getNumber().equals(accountNumber)) {
                return objAccount;
            }
        }
        throw new MyException("Cuenta no encontrada.");
    }

    public Account getAccountByCBU(String accountCBU) throws MyException {
        for (Account objAccount : accounts) {
            if (objAccount.getCbu().equals(accountCBU)) {
                return objAccount;
            }
        }
        throw new MyException("Cuenta no encontrada.");
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void changeAccountType(String accountNumber, AccountType type) throws MyException {
        Account objAccount = getAccountByNumber(accountNumber);
        AccountType accountType = null;

        switch (objAccount.getType()) {
            case SAVINGS:
                accountType = AccountType.CHECKING;
                break;
            case CHECKING:
                accountType = AccountType.SAVINGS;
                break;
        }

        objAccount.setType(accountType);
    }

    public void deleteAccount(String accountNumber) throws MyException {
        Account objAccount = getAccountByNumber(accountNumber);
        accounts.remove(objAccount);
    }
}
