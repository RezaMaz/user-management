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
public class UserController {

    private final IUserService iUserService;

    @GetMapping(value = "/{id}")
    ResponseEntity<UserDTO.Info> get(@PathVariable Long id) {
        return new ResponseEntity<>(iUserService.get(id), HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    ResponseEntity<List<UserDTO.Info>> list() {
        return new ResponseEntity<>(iUserService.list(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<UserDTO.Info> create(@RequestBody UserDTO.Create request) {
        return new ResponseEntity<>(iUserService.create(request), HttpStatus.CREATED);
    }

    @PutMapping()
    ResponseEntity<UserDTO.Info> update(@RequestBody UserDTO.Update request) {
        return new ResponseEntity<>(iUserService.update(request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        iUserService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
