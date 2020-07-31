package ir.modernisc.usermanagement.web;

import ir.modernisc.usermanagement.service.dto.UserDTO;
import ir.modernisc.usermanagement.service.iservice.IUserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.primefaces.event.RowEditEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Controller
@SessionScope
public class UserFormController {

    private final IUserService userService;
    private final ModelMapper modelMapper;
    private List<UserDTO.Info> userList;
    private List<UserDTO.Create> items;

    @PostConstruct
    public void init() {
        userList = userService.list();
        items = new ArrayList<>();
        items.add(new UserDTO.Create());
    }

    public void delete(UserDTO.Info user) {
        userService.delete(user.getId());
        userList = userService.list();
        FacesMessage msg = new FacesMessage("User Deleted",
                user.getFirstName() + " " + user.getLastName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowEdit(RowEditEvent<UserDTO.Info> event) {
        userService.update(modelMapper.map(event.getObject(), UserDTO.Update.class));
        FacesMessage msg = new FacesMessage("User Edited",
                event.getObject().getFirstName() + " " + event.getObject().getLastName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel() {
        FacesMessage msg = new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void add() {
        items.add(new UserDTO.Create());
    }

    public void onAddAll() {
        items.forEach(userService::create);
        init();
    }

}
