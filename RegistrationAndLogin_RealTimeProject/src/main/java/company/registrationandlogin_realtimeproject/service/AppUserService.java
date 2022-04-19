package company.registrationandlogin_realtimeproject.service;

import company.registrationandlogin_realtimeproject.entity.AppUser;
import company.registrationandlogin_realtimeproject.entity.token.ConfirmationToken;
import company.registrationandlogin_realtimeproject.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MESSAGE="user with email %s not found";
    private final AppUserRepository userRepository;
    private final ConfirmationTokenService tokenService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()->new
                UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE,email)));
    }
    public String signUpUser(AppUser user){
        boolean exists=userRepository.findByEmail(user.getEmail()).isPresent();
        if (exists) {
          throw new IllegalStateException("This email already taken");
        }
       String encodedPassword=bCryptPasswordEncoder
               .encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        //TODO : SEND CONFIRMATION TOKEN

String token=UUID.randomUUID().toString();
        ConfirmationToken confirmationToken=new ConfirmationToken(
token, LocalDateTime.now(),LocalDateTime.now().plusMinutes(15),
                user);
        tokenService.saveConfirmationToke(confirmationToken);
        //TODO: send email
        return token;
    }

    public int enableAppUser(String email) {
        return userRepository.enableAppUser(email);
    }
}
