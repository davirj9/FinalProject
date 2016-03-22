package br.com.project.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AutenticaLogin {
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	
	public boolean login(String username, String password){
		
		try {
			
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
			Authentication authentication = authenticationManager.authenticate(token);
			
			if(authentication.isAuthenticated()){
				SecurityContextHolder.getContext().setAuthentication(authentication);
				return true;
			}
		}catch (BadCredentialsException bce){
			bce.printStackTrace();
			return false;
		}
		return false;
	}
	
	public void logout(){
		SecurityContextHolder.getContext().setAuthentication(null);
	}
	public SecurityUser getUserLogged(){
		return (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

}
