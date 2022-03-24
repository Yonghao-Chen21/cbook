package com.careerit.cbook.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {
	private Long cid;
	private String name;
	private int status;
	private String email;
	private Date dob;
	private String mobile;
}
