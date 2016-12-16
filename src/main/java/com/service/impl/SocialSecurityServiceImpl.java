package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.YoSocialSecurityInfoMapper;
import com.model.YoSocialSecurityInfo;
import com.service.ISocialSecurityService;
@Service
public class SocialSecurityServiceImpl implements ISocialSecurityService{
  @Autowired
  private YoSocialSecurityInfoMapper socialSecurityMapper;
  public List<YoSocialSecurityInfo> selectByPropertities(YoSocialSecurityInfo socialSecurity){
	  return socialSecurityMapper.selectByPropertities(socialSecurity);
  }
}
