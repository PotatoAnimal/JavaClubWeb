package javaclub5.library.userLoginService;

import javaclub5.library.dao.UserDao;
import javaclub5.library.dto.UserDTO;
import javaclub5.library.models.User;
import javaclub5.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO user = (UserDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty");
        if (user.getLogin().length() < 3 || user.getLogin().length() > 30) {
            errors.rejectValue("login", "Size.user.username");
        }
        if (userDao.findByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.user.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.user.password");
        }

        if (!user.getPassword().equals(user.getPassword())) {
            errors.rejectValue("password", "Diff.userForm.password");
        }
    }
}
