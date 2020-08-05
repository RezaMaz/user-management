package ir.modernisc.usermanagement;

import ir.modernisc.usermanagement.entity.User;
import ir.modernisc.usermanagement.repository.UserDAO;
import ir.modernisc.usermanagement.service.dto.UserDTO;
import ir.modernisc.usermanagement.service.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestUserService {

    @InjectMocks
    UserService userService;
    @Mock
    UserDAO userDAO;
    @Mock
    ModelMapper modelMapper;

    @Before
    public void setUp() {
        UserDTO.Info info = new UserDTO.Info();
        info.setId(1L);
        info.setFirstName("Reza");
        info.setLastName("Mazloom");
        info.setAge(30);

        when(modelMapper.map(any(), any())).thenReturn(info);
    }

    @Test
    public void getAllUsersTest() {

        User userOne = new User();
        userOne.setId(1L);
        userOne.setFirstName("Reza");
        userOne.setLastName("Mazloom");
        userOne.setAge(30);

        when(userDAO.findById(1L)).thenReturn(java.util.Optional.of(userOne));

        UserDTO.Info returnedUser = userService.get(1L);

        assertEquals("Reza", returnedUser.getFirstName());
        verify(userDAO).findById(1L);
    }

}
