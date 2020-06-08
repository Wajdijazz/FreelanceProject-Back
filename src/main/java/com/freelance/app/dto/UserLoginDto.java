package com.freelance.app.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
/**
 * This class to do the login of each user
 * 
 * @author WAJDI
 *
 */
public class UserLoginDto {
	
	private String email;
    private String password;


}
