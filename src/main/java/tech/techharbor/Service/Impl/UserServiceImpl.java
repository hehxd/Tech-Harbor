package tech.techharbor.Service.Impl;

import org.springframework.stereotype.Service;
import tech.techharbor.Model.Exceptions.UserNotFoundException;
import tech.techharbor.Model.UserTableModel;
import tech.techharbor.Repository.UserTableRepository;
import tech.techharbor.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserTableRepository userTableRepository;

    public UserServiceImpl(UserTableRepository userTableRepository) {
        this.userTableRepository = userTableRepository;
    }

    @Override
    public UserTableModel findById(Integer id) {
        return this.userTableRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
    }

    @Override
    public UserTableModel create(String name, String username, String email, String password, String phoneNumber) {
        UserTableModel user = new UserTableModel(username, name, email, password, phoneNumber);
        return this.userTableRepository.save(user);
    }

    @Override
    public UserTableModel update(Integer id, String name, String username, String email, String password, String phoneNumber) {
        UserTableModel user = this.userTableRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setNameUser(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        return this.userTableRepository.save(user);
    }

    @Override
    public UserTableModel findByUsername(String username) {
        return this.userTableRepository.findByUsername(username);
    }

    @Override
    public void delete(Integer id) {
        this.userTableRepository.deleteById(id);
    }
}
