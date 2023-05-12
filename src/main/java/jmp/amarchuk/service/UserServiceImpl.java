package jmp.amarchuk.service;


import jmp.amarchuk.dao.UserDao;
import jmp.amarchuk.model.User;

import java.util.List;

/**
 * UserService implementation - which contains user and booking-related functionality accordingly.
 *
 * @author Anastasiya Marchuk
 *
 */
public class UserServiceImpl implements UserService {

    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(long userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userDao.getUsersByName(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        //return userDao.updateUser(user);
        User userUpdated=userDao.updateUser(user);
        if(userUpdated==null){
            throw new NullPointerException("Error updating user "+user);
        }
        return userUpdated;
    }

    @Override
    public boolean deleteUser(long userId) {
        return userDao.deleteUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

//    public void preloadUsers(MultipartFile file) {
//        UserDto userDto = null;
//        try {
//            userDto = new Jackson(file).loaderXmlFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        List<User> users = userDto.getUsers();
//        userDao.preloadUsers(users);
//    }
}
