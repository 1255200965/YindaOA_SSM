package com.service;

import com.model.OaWtr;
import com.model.OaWtrExample;

import java.util.List;

/**
 * Created by ma on 2016/11/18.
 */
public interface IWtrService {
    public List<OaWtr> selectByExample(OaWtrExample example);

    public int insert(OaWtr record);
}
