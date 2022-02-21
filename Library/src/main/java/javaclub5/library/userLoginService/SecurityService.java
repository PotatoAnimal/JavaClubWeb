package javaclub5.library.userLoginService;

public interface SecurityService {
    String findLoggedInLogin();

    void autoLogin(String username, String password);
}
