package com.edu.service;

import com.edu.entity.Address;
import com.edu.entity.User;

public interface UserService {
    boolean register(User user);

    User login(String user_account);

    User selectUserById(int user_id);

    Address showAddressByUId(int user_id);

    boolean addAddress(Address address);

    boolean upadteAddress(Address address);
}
