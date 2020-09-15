// package vtc;

// import static org.junit.Assert.assertTrue;

// import org.junit.Test;

// import vtc.dal.AccountDAL;
// import vtc.persistance.Account;

// /**
//  * Unit test for simple App.
//  */
// public class AccountFunctionTest {
//     @Test
//     public void LoginTest() {
//         int result;
//         int expected;
//         try {
//             result = new AccountDAL().check_account("hoangcuong", "123123");
//             expected = 2;
//             assertTrue(result == expected);
//             result = new AccountDAL().check_account(null, "123123");
//             expected = -1;
//             assertTrue(result == expected);
//             result = new AccountDAL().check_account("hoangcuong", null);
//             expected = -1;
//             assertTrue(result == expected);
//             result = new AccountDAL().check_account("hoanhcuong", "123123");
//             expected = -1;
//             assertTrue(result == expected);
//             result = new AccountDAL().check_account("hoangcuong", "eajh1244");
//             expected = -1;
//             assertTrue(result == expected);
//             result = new AccountDAL().check_account("HoangCuong", "12313");
//             expected = -1;
//             assertTrue(result == expected);
//         } catch (Exception e) {
//             // TODO: handle exception
//         }
//     }

//     @Test
//     public void InsertAccountTest() {
//         Account account = new Account();
//         int result;
//         int expected;
//         try {

//             account.setusername("newstaff");
//             account.setpassword("new123123");
//             account.setfirstname("hoang");
//             account.setlastname("cuong");
//             account.setbirthday("2001-09-20");
//             account.setphonenumber(915274663);
//             account.setemail("cuonghm111@gmail.com");
//             account.setposition("Staff");
//             account.setstarttime("2020-09-01");
//             result = new AccountDAL().insertaccount(account);
//             expected = 1;
//             assertTrue(result == expected);

//             account.setusername("newstaff");
//             account.setpassword("new123123");
//             account.setfirstname(null);
//             account.setlastname("cuong");
//             account.setbirthday(null);
//             account.setphonenumber((Integer) null);
//             account.setemail("cuonghm111@gmail.com");
//             account.setposition("Staff");
//             account.setstarttime("2020-09-01");
//             result = new AccountDAL().insertaccount(account);
//             expected = -1;
//             assertTrue(result == expected);

//             account.setusername("hoangcuong");
//             account.setpassword("new123123");
//             account.setfirstname("hoang");
//             account.setlastname("cuong");
//             account.setbirthday("2001-09-20");
//             account.setphonenumber(905974663);
//             account.setemail("cuonghm111@gmail.com");
//             account.setposition("Staff");
//             account.setstarttime("2020-09-01");
//             result = new AccountDAL().insertaccount(account);
//             expected = 0;
//             assertTrue(result == expected);

//         } catch (Exception e) {
//             // TODO: handle exception
//         }
//     }

//     @Test
//     public void UpdateAccountTest() {
//         Account account = new Account();
//         int result;
//         int expected;
//         try {
//             account.setAccountId(2);
//             account.setpassword("123123");
//             account.setfirstname("hoang");
//             account.setlastname("cuong");
//             account.setbirthday("2001-09-20");
//             account.setphonenumber(915974683);
//             account.setemail("cuonghm111@gmail.com");
//             account.setposition("Staff");
//             account.setstarttime("2020-09-01");
//             result = new AccountDAL().update(account);
//             expected = 1;
//             assertTrue(result == expected);

//             account.setAccountId(2);
//             account.setpassword("new123123");
//             account.setfirstname(null);
//             account.setlastname("cuong");
//             account.setbirthday(null);
//             account.setphonenumber((Integer) null);
//             account.setemail("cuonghm111@gmail.com");
//             account.setposition("Staff");
//             account.setstarttime("2020-09-01");
//             result = new AccountDAL().update(account);
//             expected = 0;
//             assertTrue(result == expected);

//         } catch (Exception e) {
//             // TODO: handle exception
//         }

//     }

//     @Test
//     public void UpdateAccountByIdTest() {
//         Account account = new Account();
//         int result;
//         int expected;
//         try {

//             account.setusername("123123");
//             account.setpassword("new123123");
//             account.setfirstname("hoang");
//             account.setlastname("cuong");
//             account.setbirthday("2001-09-20");
//             account.setphonenumber(915974633);
//             account.setemail("cuonghm@gmail.com");
//             account.setposition("Staff");
//             account.setstarttime("2020-09-01");
//             result = new AccountDAL().updateById(account, 2);
//             expected = 1;
//             assertTrue(result == expected);

//             account.setpassword("123123");
//             account.setfirstname(null);
//             account.setlastname("cuong");
//             account.setbirthday(null);
//             account.setphonenumber((Integer) null);
//             account.setemail("cuonghm111@gmail.com");
//             account.setposition("Staff");
//             account.setstarttime("2020-09-01");
//             result = new AccountDAL().updateById(account, 2);
//             expected = 0;
//             assertTrue(result == expected);
//         } catch (Exception e) {
//             // TODO: handle exception
//         }
//     }

// }
