package com.careerit.cbook.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class userProfileDTO {
	private Long uid;
	private String name;
	private String email;

}
