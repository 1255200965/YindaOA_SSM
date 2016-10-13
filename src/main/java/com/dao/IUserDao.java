package com.dao;

/**
 * Created by ma on 2016/10/13.
 */

import java.util.List;
import com.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;


@MapperScan
@Repository
public interface IUserDao {
     List<User> findAllUser();
}
