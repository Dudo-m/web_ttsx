package com.edu.dao;

import com.edu.entity.Address;
import com.edu.entity.User;

public interface UserDao extends BaseDao<User> {

    public User selectUserByAccount(String user_account);

    Address findAddressByUId(int user_id);

    boolean insertAddress(Address address);

    boolean updateAddress(Address address);
}
