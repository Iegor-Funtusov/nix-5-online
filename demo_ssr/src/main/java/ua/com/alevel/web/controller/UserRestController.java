package ua.com.alevel.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.web.data.PageData;
import ua.com.alevel.web.data.UserData;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    public final UserFacade userFacade;

    public UserRestController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping
    public ResponseEntity<PageData<UserData>> findAll(WebRequest request) {
        return ResponseEntity.ok(userFacade.find(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserData> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(userFacade.find(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody UserData userData) {
        userFacade.create(userData);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@RequestBody UserData userData, @PathVariable Integer id) {
        userData.setId(id);
        userFacade.update(userData);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        userFacade.delete(id);
        return ResponseEntity.ok(true);
    }
}
