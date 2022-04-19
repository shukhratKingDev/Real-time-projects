package company.registrationandlogin_realtimeproject.service;

import company.registrationandlogin_realtimeproject.entity.token.ConfirmationToken;
import company.registrationandlogin_realtimeproject.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository tokenRepository;
    public void saveConfirmationToke(ConfirmationToken token){
        tokenRepository.save(token);
    }

public Optional<ConfirmationToken> getToken(String token){
        return tokenRepository.findByToken(token);
}
public int setConfirmedAt(String token){
        return tokenRepository.updateConfirmedAt(token, LocalDateTime.now());
}

}
