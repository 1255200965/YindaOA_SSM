package com.service;

import com.model.YoItemChange;

import java.util.List;

public interface IItemChangeService {

    List<YoItemChange> selectByPropertities(YoItemChange itemChange);

}
