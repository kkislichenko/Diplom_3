package api;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistration {
    private String email;
    private String password;
    private String name;
}
