package ua.com.alevel.facade;

import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.web.data.PageData;
import ua.com.alevel.web.data.UserData;

public interface UserFacade {

    void create(UserData userData);
    void update(UserData userData);
    void delete(Integer id);
    UserData find(Integer id);
    PageData<UserData> find(WebRequest request);
}
