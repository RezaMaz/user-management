package ir.modernisc.usermanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "C_FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "C_LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "N_AGE")
    private Integer age;

    @Version
    @Column(name = "N_VERSION", nullable = false)
    private Integer version;

}
