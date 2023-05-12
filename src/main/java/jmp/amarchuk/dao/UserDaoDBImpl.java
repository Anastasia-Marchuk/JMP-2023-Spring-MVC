package jmp.amarchuk.dao;

import jmp.amarchuk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User DAO object for the domain model (User).
 *
 * @author Anastasiya Marchuk
 *
 */
@Repository
public class UserDaoDBImpl implements UserDao {
    @Autowired
    private List<User> users;

    @Override
    public User getUserById(long userId) {
        return users.stream().filter(o -> o.getId()==userId).findAny().get();
    }

    @Override
    public User getUserByEmail(String email) {
        return users.stream().filter(o -> o.getEmail().equals(email)).findAny().get();
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return users.stream().filter(o -> o.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public User createUser(User user) {
        long id =users.size()+1;
        for (int i = 0; i < users.size(); i++) {
            if (id==users.get(i).getId()){
                id++;
            }
        }
        user.setId(id);
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        for (User u: users) {
            if(u.getId()==user.getId()){
                int index=users.indexOf(u);
                users.set(index,user);
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean deleteUser(long userId) {
        return users.remove(users.stream().filter(o -> o.getId() == userId).collect(Collectors.toList()).get(0));
    }

    @Override
    public int size() {
        return users.size();
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void preloadUsers(List<User> list) {
        users.addAll(list);
    }

    public int sizeUsers() {
        return users.size();
    }
}
