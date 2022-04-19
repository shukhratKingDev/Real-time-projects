package company.registrationandlogin_realtimeproject.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
