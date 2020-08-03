package ir.modernisc.usermanagement;

import ir.modernisc.usermanagement.repository.UserDAO;
import ir.modernisc.usermanagement.service.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestUserService {

    @InjectMocks
    UserService userService;
    @Mock
    UserDAO userDAO;

    @Test
    public void getAllUsersTest() {

    }

}
