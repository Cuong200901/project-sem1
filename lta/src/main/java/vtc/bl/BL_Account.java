package vtc.bl;

import vtc.dal.*;
public class BL_Account {
    DAL_Account dal_account = new DAL_Account();
    public String login(String username, String password)
    {
        return dal_account.check_account(username,password);
    }
}