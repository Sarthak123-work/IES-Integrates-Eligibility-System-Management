package com.IES.AuthServiceImpl;

import javax.validation.Valid;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.IES.AuthService.AuththenticationService;
import com.IES.AuthService.JwtService;
import com.IES.Config.AppConfig2;
import com.IES.DTO.changePassDTO;
import com.IES.DTO.loginResponseDTO;
import com.IES.DTO.loginreqDTO;
import com.IES.DTO.signUpDTO;
import com.IES.Entity.User;
import com.IES.Enum.Role;
import com.IES.Exception.UserAlreadyExisted;
import com.IES.Exception.UserNotExistwithEmail;
import com.IES.Exception.invalidPassword;
import com.IES.Repo.AuthenticationRepo;
import com.netflix.discovery.converters.Auto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuththenticationService {

    @Autowired
    private AuthenticationRepo authrepo;

    @Autowired
    private ModelMapper modelMapper; 
    
    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private PasswordEncoder passEnc;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    
    @Override
    public String signUp(@Valid signUpDTO sdtorequest) {
    	
    	User usr = authrepo.findByEmail(sdtorequest.getEmail());
        
        // 1. Check if user already exists
        if (usr != null) {
            throw new UserAlreadyExisted("User Already Existed");
        }

        // 2. Map DTO → Entity
        User user = modelMapper.map(sdtorequest, User.class);

        // 3. Assign default role
        user.setRole(Role.Citizen);
        user.setPwd(passEnc.encode(sdtorequest.getPwd()));
        
        User user2=authrepo.save(user);
        

        log.info("After user Persist:"+user2);

        return "User Registered Successfully!";
    }

	@Override
	public String login(@Valid loginreqDTO lgDTO) {
		
		
		
		User usr1=authrepo.findByEmail(lgDTO.getEmail());
		if(usr1==null) {
			log.warn("Email Invalid, User not found with this email");
			//custom exception to throw exception when value is passed as null
			
			throw new UserNotExistwithEmail("Email Invalid, User not found with this email");
			  
			
		}
		if(!passEnc.matches(lgDTO.getPwd(), usr1.getPwd())) {
			log.warn("Password Incorrect");
			
			throw new invalidPassword("Password is Incorrect");
		}
		
		
		 authenticationManager.authenticate(
		            new UsernamePasswordAuthenticationToken(
		                lgDTO.getEmail(),
		                lgDTO.getPwd()
		            )
		        );
		 
		 
		User usr2=authrepo.save(usr1);
		String token=jwtService.generateToken(usr2);
		
		
		
		return "Login Successfully!"+"\n"+lgDTO.getEmail()+"\n"+"Token:"+token;
	}

	@Override
	public String changePass(@Valid changePassDTO cpDTO) {
		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	    String loggedInEmail = auth.getName();
	    
	    
		User usr1=authrepo.findByEmail(cpDTO.getEmail());
		
		if(usr1==null) {
			log.warn("Email Invalid, User not found with this email");
			//custom exception to throw exception when value is passed as null
			
			throw new UserNotExistwithEmail("Email Invalid, User not found with this email");
			  
			
		}
		
		if(!passEnc.matches(cpDTO.getPwd(), usr1.getPwd())) {
			log.warn("Password Incorrect");
			
			throw new invalidPassword("Password is Incorrect");
		}
		
		usr1.setPwd(passEnc.encode(cpDTO.getPwdUpdated()));
		authrepo.save(usr1);
		return "Password updated successfully!";
		
		

	}
}
