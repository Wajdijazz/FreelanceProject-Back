package com.freelance.app.services.implementation;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.freelance.app.dto.UserDetailDto;
import com.freelance.app.dto.UserDto;
import com.freelance.app.entities.Role;
import com.freelance.app.entities.User;
import com.freelance.app.exceptions.ApplicationException;
import com.freelance.app.exceptions.ResourceNotFoundException;
import com.freelance.app.repositories.RoleRepository;
import com.freelance.app.repositories.UserRepository;
import com.freelance.app.services.ICompanyClientService;
import com.freelance.app.services.IPersonService;
import com.freelance.app.services.IUserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements IUserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	private IPersonService personService;
	private ICompanyClientService companyClientService;

	@Qualifier("getJavaMailSendeGmail")
	public JavaMailSender emailSendergmail;

	@Qualifier("getJavaMailSenderYahoo")
	public JavaMailSender emailSenderYahoo;

	private static final String jwtSecret = "JWTSecretKey";

	private static final int jwtExpiration = 86400;

	// create Admin methode to save company and user and person in same time

	@Override
	public User createUser(UserDto userDto) throws MessagingException {
		if (userRepository.findByEmail(userDto.getEmail()) != null)
			throw new ResourceNotFoundException("User already exists");
		if (!userDto.getPassword().equals(userDto.getConfirmedPassword()))
			throw new ResourceNotFoundException("Please confirm your password");
		User userToSave = User.builder().email(userDto.getEmail())
				.password(passwordEncoder.encode(userDto.getPassword()))
				.person(personService.getPersonById(userDto.getPersonId()))
				.companyClient(companyClientService.getCompanyById(userDto.getCompanyClientId())).isActive(true)
				.build();
		userToSave.setRoles(affectRoleToUser(userDto));
		sendMail("", userDto.getEmail(), userDto.getPassword());
		return userRepository.save(userToSave);
	}

	@Override
	public User getUserById(Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new ApplicationException("This user with Id" + userId + "not exist"));
	}

	@Override
	public void sendMail(String messageToSend, String email, String password) throws MessagingException {
		String tokenGenerated = Jwts.builder().setSubject(email).setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpiration * 1000))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
		MimeMessage messageGmail = emailSendergmail.createMimeMessage();
		MimeMessage messageYahoo = emailSenderYahoo.createMimeMessage();

		boolean multipart = true;
		MimeMessageHelper helperGmail = new MimeMessageHelper(messageGmail, multipart, "utf-8");
		MimeMessageHelper helperYahoo = new MimeMessageHelper(messageYahoo, multipart, "utf-8");

		String htmlMsg = "<h3>Welcome to be a part of our clients</h3>" + "<p>To to authenticate :  </p>"
				+ "<p>your login : </p>" + email + "<p>your password : </p>" + password
				+ "<p> To change your password click here : " + "http://localhost:4200/reset/" + tokenGenerated;

		messageGmail.setContent(htmlMsg, "text/html");
		helperGmail.setTo(email);
		helperGmail.setSubject("Confirm registration");
		this.emailSendergmail.send(messageGmail);

		messageYahoo.setContent(htmlMsg, "text/html");
		helperYahoo.setTo(email);
		helperYahoo.setSubject("Confirm registration");
		this.emailSenderYahoo.send(messageYahoo);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Set<Role> affectRoleToUser(UserDto userDto) {
		Set<String> strRoles = userDto.getRole();
		Set<Role> roles = new HashSet<>();
		strRoles.forEach(role -> {
			switch (role) {
			case "SUPERADMIN":
				Role SuperAdminRole = roleRepository.findByRoleDescription("SUPERADMIN")
						.orElseThrow(() -> new ApplicationException("Fail! -> Cause: User Role not find."));
				roles.add(SuperAdminRole);
				break;

			case "ADMIN":
				Role AdminRole = roleRepository.findByRoleDescription("ADMIN")
						.orElseThrow(() -> new ApplicationException("Fail! -> Cause: User Role not find."));
				roles.add(AdminRole);
				break;

			case "GESTIONARY":
				Role GestionnaryRole = roleRepository.findByRoleDescription("GESTIONARY")
						.orElseThrow(() -> new ApplicationException("Fail! -> Cause: User Role not find."));
				roles.add(GestionnaryRole);
				break;

			case "USER":
				Role UserRole = roleRepository.findByRoleDescription("USER")
						.orElseThrow(() -> new ApplicationException("Fail! -> Cause: User Role not find."));
				roles.add(UserRole);
				break;

			case "AUDIT":
				Role AuditRole = roleRepository.findByRoleDescription("AUDIT")
						.orElseThrow(() -> new ApplicationException("Fail! -> Cause: User Role not find."));
				roles.add(AuditRole);
				break;
			}

		});
		return roles;
	}

	@Override
	public User updatePasswordUser(UserDto userDto) {
		User userToUpdate = userRepository.findByEmail(userDto.getEmail());
		if (!userDto.getPassword().equals(userDto.getConfirmedPassword()))
			throw new ResourceNotFoundException("Please confirm your password");
		userToUpdate.setPassword(passwordEncoder.encode(userDto.getPassword()));
		return userToUpdate;
	}

	@Override
	public UserDetailDto getUserInfoByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return UserDetailDto.builder().userId(user.getUserId()).companyName(user.getCompanyClient().getCompanyName())
				.userFirstName(user.getPerson().getFirstName()).userLastName(user.getPerson().getLastName())
				.userPhone(user.getPerson().getPhoneNumber())
				.companyWebSite(user.getCompanyClient().getCompanyWebSite())
				.build();
	}
	

}
