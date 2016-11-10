package com.service.impl;

import com.model.AskForLeave;
import com.service.IAskLeaveService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ma on 2016/10/15.
 */
@Transactional
@Service
public class IAskLeaveServiceImpI implements IAskLeaveService {
   @Override
   public List<AskForLeave> selectByExample() {
      return selectByExample();
   }
}
