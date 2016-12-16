package com.service;

import java.util.List;

import com.model.YoSocialSecurityInfo;

public interface ISocialSecurityService {
	public List<YoSocialSecurityInfo> selectByPropertities(YoSocialSecurityInfo socialSecurity);
}
