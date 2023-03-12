package account.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastname;
    @NotEmpty
    private String email;


    @NotEmpty
    private String password;

}
