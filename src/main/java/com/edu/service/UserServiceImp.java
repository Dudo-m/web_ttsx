package com.edu.service;

import com.edu.dao.UserDao;
import com.edu.dao.UserDaoImp;
import com.edu.entity.Address;
import com.edu.entity.User;

public class UserServiceImp implements UserService {

    UserDao userDao = new UserDaoImp();
    //注册方法
    @Override
    public boolean register(User user) {
        return userDao.insert(user);
    }

    @Override
    public User login(String user_account) {
        return userDao.selectUserByAccount(user_account);
    }

    @Override
    public User selectUserById(int user_id) {
        return userDao.findById(user_id);
    }

    @Override
    public Address showAddressByUId(int user_id) {
        return userDao.findAddressByUId(user_id);
    }

    @Override
    public boolean addAddress(Address address) {
        return userDao.insertAddress(address);
    }

    @Override
    public boolean upadteAddress(Address address) {
        return userDao.updateAddress(address);
    }
}
