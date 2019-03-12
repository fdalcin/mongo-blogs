package br.com.mongoblogs.service;

import br.com.mongoblogs.model.User;
import br.com.mongoblogs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(User user, String passwordConfirm, boolean edit) throws Exception{
        if(!edit){
            user.setId(null);
        }

        user.setGrantedAuthorities(getDefaultAuthority());

        userValidate(user,passwordConfirm, edit);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    private List<GrantedAuthority> getDefaultAuthority(){
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        return authorities;
    }

    private void userValidate(User user, String passwordConfirm, boolean edit) throws Exception{
        if(user.getPassword() == null || user.getUsername() == null || user.getFirstname() == null || user.getLastname() == null){
            throw new Exception("All field's required.");
        }
        if(user.getPassword().length() < 8){
            throw new Exception("Password must be at least 8 characters.");
        }
        if(!user.getPassword().equals(passwordConfirm)){
            throw new Exception("Password's are diverged.");
        }
        if(user.getAuthorities() == null || user.getAuthorities().size() == 0){
            throw new Exception("Please, set authorities for this user.");
        }
        if(!edit && userRepository.findByUsername(user.getUsername()) != null){
            throw new Exception("This username already in use.");
        }
    }

}
