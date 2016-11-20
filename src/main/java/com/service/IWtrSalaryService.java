package com.service;

import com.model.OaWtrSalary;
import com.model.OaWtrSalaryExample;

import java.util.List;

/**
 * Created by ma on 2016/11/18.
 */
public interface IWtrSalaryService {


    public List<OaWtrSalary> selectByExample(OaWtrSalaryExample example);


    public int insert(OaWtrSalary record);
}
