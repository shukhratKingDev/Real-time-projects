package company.registrationandlogin_realtimeproject.controller;

import company.registrationandlogin_realtimeproject.entity.AppUser;
import company.registrationandlogin_realtimeproject.entity.model.RegistrationRequest;
import company.registrationandlogin_realtimeproject.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
@AllArgsConstructor
public class RegistrationController {
    RegistrationService registrationService;
    @PostMapping()
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
    @GetMapping("/confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }
}
