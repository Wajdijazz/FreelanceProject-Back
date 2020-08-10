package com.freelance.app.dto;

import java.util.Set;

import com.freelance.app.util.Autorized;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
/**
 * All Dto class to get Data from Front
 * 
 * @author WAJDI
 *
 */
public class UserDto {

	private Long userId;

	private String email;

	private String password;

	private String confirmedPassword;

	private Set<String> role;

	private boolean isActive;
	
	private String autorized;

	private Long personId;

	private Long companyClientId;

}
