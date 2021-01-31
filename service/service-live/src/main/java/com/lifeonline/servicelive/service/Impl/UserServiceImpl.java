package com.lifeonline.servicelive.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lifeonline.servicelive.mapper.UserMapper;
import com.lifeonline.servicelive.model.User;
import com.lifeonline.servicelive.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author HHY
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
