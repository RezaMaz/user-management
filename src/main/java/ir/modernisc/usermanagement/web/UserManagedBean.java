package ir.modernisc.usermanagement.web;

import ir.modernisc.usermanagement.service.dto.UserDTO;
import ir.modernisc.usermanagement.service.iservice.IUserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Scope(value = "session")
@Component(value = "userManagedBean")
public class UserManagedBean {

    private final IUserService userService;

    public List<UserDTO.Info> search() {
        return userService.list();
    }

}
