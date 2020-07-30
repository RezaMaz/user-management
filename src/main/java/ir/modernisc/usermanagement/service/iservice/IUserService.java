package ir.modernisc.usermanagement.service.iservice;

import ir.modernisc.usermanagement.service.dto.UserDTO;

import java.util.List;

public interface IUserService {

    UserDTO.Info get(Long id);

    List<UserDTO.Info> list();

    UserDTO.Info create(UserDTO.Create request);

    UserDTO.Info update(UserDTO.Update request);

    void delete(Long id);

}
