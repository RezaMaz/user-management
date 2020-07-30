package ir.modernisc.usermanagement.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserDTO {

    private String firstName;
    private String lastName;
    private Integer age;

    @Getter
    @Setter
    public static class Info extends UserDTO {

        private Long id;
        private Integer version;
    }

    @Getter
    @Setter
    public static class Create extends UserDTO {
    }

    @Getter
    @Setter
    public static class Update extends UserDTO {
        @NotNull
        private Long id;
    }

    @Getter
    @Setter
    public static class Delete extends UserDTO {
        @NotNull
        private Long id;
    }
}
