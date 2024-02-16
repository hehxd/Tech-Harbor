package tech.techharbor.Service;


import tech.techharbor.Model.UserTableModel;

public interface UserService {

    UserTableModel findById(Integer id);

    UserTableModel create(String name, String username, String email, String password, String phoneNumber);

    UserTableModel update(Integer id, String name, String username, String email, String password, String phoneNumber);

    UserTableModel findByUsername(String username);

    void delete(Integer id);
}
