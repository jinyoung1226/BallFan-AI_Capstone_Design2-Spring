package BallFan.controller;

import BallFan.dto.response.BaseResponse;
import BallFan.dto.auth.SignInDTO;
import BallFan.dto.auth.SignInRequest;
import BallFan.dto.auth.SignUpRequest;
import BallFan.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private static final String SIGN_UP_SUCCESS_MESSAGE = "회원가입 성공";
    private final AuthService authService;

    @PostMapping("/signUp")
    public ResponseEntity<BaseResponse> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        authService.signUp(signUpRequest);
        return new ResponseEntity<>(BaseResponse.builder()
                .message(SIGN_UP_SUCCESS_MESSAGE)
                .build(), HttpStatus.OK);
    }

    @PostMapping("/signIn")
    public ResponseEntity<SignInDTO> signIn(@Valid @RequestBody SignInRequest signInRequest) {
        SignInDTO signInDTO = authService.signIn(signInRequest);
        return new ResponseEntity<>(signInDTO, HttpStatus.OK);
    }

    @PostMapping("/signOut")
    public void signOut(@RequestHeader(name = "Authorization") String authorizationHeader) {
        authService.signOut(authorizationHeader);
    }
}
