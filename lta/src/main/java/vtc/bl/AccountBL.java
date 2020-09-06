package vtc.bl;

import vtc.persistance.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vtc.dal.AccountDAL;

public class AccountBL {
    static List<Account> accountsList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    AccountDAL dal_account = new AccountDAL();

    public List<Account> getAll() {
        return AccountDAL.getAll();
    }

    public List<Account> getById(int id) {
        return AccountDAL.getById(id);
    }

    public int login(String username, String password) {
        return dal_account.check_account(username, password);
    }

    public boolean addAccount(Account Account) {
        return AccountDAL.insertaccount(Account) > 0;
    }

    public boolean Update(Account Account) throws SQLException {
        return dal_account.update(Account) > 0;
    }

   
}