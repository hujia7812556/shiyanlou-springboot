
package com.shiyanlou.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        // 保存实体类
        userRepository.save(user);
        // 去除异常
//         int shiyanlou = 1 / 0;

        // 修改密码
        user.setPassword("123456");
        // 重新保存，更新记录
        return userRepository.save(user);
    }
}

