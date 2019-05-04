package com.iot.iotcloud.microservice.account.dao.impl;

import com.iot.iotcloud.library.account.model.po.User;
import com.iot.iotcloud.library.account.model.viewmodel.UserViewModel;
import com.iot.iotcloud.library.common.utility.StringUtility;
import com.iot.iotcloud.library.dal.dao.impl.BaseDao;
import com.iot.iotcloud.microservice.account.dao.IUserDao;
import com.iot.iotcloud.microservice.account.mapper.IUserMapper;
import com.iot.iotcloud.microservice.account.repository.IRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 用户访问数据对象实现
 * @author Ge Jian Feng
 * @version 1.0.0
 */
@Component
public class UserDao extends BaseDao implements IUserDao {

    /**
     * Redis数据仓库
     */
    @Autowired
    protected IRedisRepository redisRepository;

    /**
     * 用户数据库映射
     */
    @Resource
    protected IUserMapper userMapper;

    @Override
    public User getUserById(String id) {
        if (StringUtility.isNullOrEmpty(id)) {
            return null;
        }

        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByMail(String mail) {
        if (StringUtility.isNullOrEmpty(mail)) {
            return null;
        }

        return userMapper.getUserByMail(mail);
    }

    @Override
    public UserViewModel addUser(User entity) {
        if (entity == null) {
            return null;
        }

        userMapper.insertUser(entity);
        UserViewModel _ret = UserViewModel.getUserViewModel(entity);
        return _ret;
    }

    @Override
    public UserViewModel modifyUser(User entity) {
        if (entity == null) {
            return null;
        }
        userMapper.updateUser(entity);
        UserViewModel _ret = UserViewModel.getUserViewModel(entity);
        return _ret;
    }

    @Override
    public boolean deleteUser(User entity) {
        if (entity == null || StringUtility.isNullOrEmpty(entity.getId())) {
            return false;
        }
        userMapper.deleteUser(entity);
        return true;
    }

    @Override
    public boolean lockMail(String mail) {
        if (StringUtility.isNullOrEmpty(mail)) {
            return false;
        }

        String _key = "user:mail:" + mail;

        return redisRepository.setNx(_key, true, 10, TimeUnit.SECONDS);
    }

    @Override
    public void unlockMail(String mail) {
        if (StringUtility.isNullOrEmpty(mail)) {
            return;
        }

        String _key = "user:mail:" + mail;
        redisRepository.delete(_key);
    }

    @Override
    public boolean lockId(String id) {
        if (StringUtility.isNullOrEmpty(id)) {
            return false;
        }

        String _key = "user:id:" + id;

        return redisRepository.setNx(_key, true, 10, TimeUnit.SECONDS);
    }

    @Override
    public void unlockId(String id) {
        if (StringUtility.isNullOrEmpty(id)) {
            return;
        }

        String _key = "user:id:" + id;
        redisRepository.delete(_key);
    }
}
