package com.service.impl;

import com.dao.AskForLeaveMapper;
import com.model.AskForLeave;
import com.model.AskForLeaveExample;
import com.service.IAskLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ma on 2016/10/15.
 */
@Transactional
@Service
public class AskLeaveServiceImpl implements IAskLeaveService {
   @Autowired
   public AskForLeaveMapper askForLeaveMapper;

//   @Autowired
//   public AskForLeaveMapper askForLeaveMapper;

   @Override
   public List<AskForLeave> selectByExample() {
      return askForLeaveMapper.selectByExample();
   }
   public List<AskForLeave> selectByExample(AskForLeaveExample example) {
      return askForLeaveMapper.selectByExample(example);
   }
}
