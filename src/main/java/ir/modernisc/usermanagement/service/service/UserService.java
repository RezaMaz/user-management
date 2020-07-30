package ir.modernisc.usermanagement.service.service;

import ir.modernisc.usermanagement.entity.User;
import ir.modernisc.usermanagement.repository.UserDAO;
import ir.modernisc.usermanagement.service.dto.UserDTO;
import ir.modernisc.usermanagement.service.exception.NotFoundException;
import ir.modernisc.usermanagement.service.iservice.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    private final ModelMapper modelMapper;
    private final UserDAO userDAO;

    @Transactional(readOnly = true)
    @Override
    public UserDTO.Info get(Long id) {
        final Optional<User> byId = userDAO.findById(id);
        final User user = byId.orElseThrow(() -> new NotFoundException(User.class));
        return modelMapper.map(user, UserDTO.Info.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDTO.Info> list() {
        final List<User> all = userDAO.findAll();
        return modelMapper.map(all, new TypeToken<List<UserDTO.Info>>() {
        }.getType());
    }

    @Transactional
    @Override
    public UserDTO.Info create(UserDTO.Create request) {
        final User user = modelMapper.map(request, User.class);

        return save(user);
    }

    @Transactional
    @Override
    public UserDTO.Info update(UserDTO.Update request) {
        final Optional<User> byId = userDAO.findById(request.getId());
        final User user = byId.orElseThrow(() -> new NotFoundException(User.class));

        User updating = new User();
        modelMapper.map(user, updating);
        modelMapper.map(request, updating);

        return save(updating);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDAO.deleteById(id);
    }

    private UserDTO.Info save(User user) {
        final User saved = userDAO.saveAndFlush(user);
        return modelMapper.map(saved, UserDTO.Info.class);
    }

}
