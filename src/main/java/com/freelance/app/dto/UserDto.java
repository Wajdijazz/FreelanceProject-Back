package com.freelance.app.dto;

import lombok.Builder;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
/**
 * All Dto class to get Data from Front
 * 
 * @author WAJDI
 *
 */
public class UserDto  {

	private Long userId;

	private String email;

	private String password;

	private String confirmedPassword;

	private boolean isActive;

	private Long personId;

	private Long companyClientId;

}