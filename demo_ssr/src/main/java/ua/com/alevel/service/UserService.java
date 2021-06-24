package ua.com.alevel.service;

import org.springframework.data.domain.Page;
import ua.com.alevel.persistence.entity.User;

import java.util.Map;

public interface UserService {

    void create(User user);
    void update(User user);
    void delete(Integer id);
    User find(Integer id);
    Page<User> find(Map<String, String> params);
}
