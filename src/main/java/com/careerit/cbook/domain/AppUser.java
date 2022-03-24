package com.careerit.cbook.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUser {
	private Long uid;
	private String name;
	private String password;
	private String email;
	private Date dob;
	private String mobile;
}
