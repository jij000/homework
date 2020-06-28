package edu.miu.CS525DE.Lab01.c.DAO;

import edu.miu.CS525DE.Lab01.a.Address;
import edu.miu.CS525DE.Lab01.c.Domain.UserInfo;

public class UserInfoDAO {
    public void newUser(String name, String phone, String email, Address address) {
        new UserInfo();
    }
    public UserInfo getUserInfo(String id) {
        return new UserInfo();
    }
}
