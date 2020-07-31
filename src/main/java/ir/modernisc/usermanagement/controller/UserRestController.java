package ir.modernisc.usermanagement.controller;

import ir.modernisc.usermanagement.service.dto.UserDTO;
import ir.modernisc.usermanagement.service.iservice.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/user")
public class UserRestController {

    private final IUserService userService;

    @GetMapping(value = "/{id}")
    ResponseEntity<UserDTO.Info> get(@PathVariable Long id) {
        return new ResponseEntity<>(userService.get(id), HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    ResponseEntity<List<UserDTO.Info>> list() {
        return new ResponseEntity<>(userService.list(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<UserDTO.Info> create(@RequestBody UserDTO.Create request) {
        return new ResponseEntity<>(userService.create(request), HttpStatus.CREATED);
    }

    @PutMapping()
    ResponseEntity<UserDTO.Info> update(@RequestBody UserDTO.Update request) {
        return new ResponseEntity<>(userService.update(request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
