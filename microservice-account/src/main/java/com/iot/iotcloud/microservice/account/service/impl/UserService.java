package com.iot.iotcloud.microservice.account.service.impl;

import com.iot.iotcloud.library.account.model.dto.UserDTO;
import com.iot.iotcloud.library.account.model.po.User;
import com.iot.iotcloud.library.account.model.viewmodel.UserViewModel;
import com.iot.iotcloud.library.common.utility.StringUtility;
import com.iot.iotcloud.library.core.service.impl.BaseService;
import com.iot.iotcloud.microservice.account.dao.IUserDao;
import com.iot.iotcloud.microservice.account.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户服务接口实现
 * @author Ge Jian Feng
 * @version 1.0.0
 */
@Service
public class UserService extends BaseService implements IUserService {

    /**
     * 用户数据连接对象
     */
    @Autowired
    protected IUserDao userDao;

    @Override
    public UserViewModel addUser(UserDTO request) {
        if (request == null) {
            throw new RuntimeException("请求为空");
        }

        if (StringUtility.isNullOrEmpty(request.getMail()) || StringUtility.isNullOrEmpty(request.getPassword())) {
            throw new RuntimeException("用户邮箱与密码不能为空");
        }

        if (!userDao.lockMail(request.getMail())) {
            throw new RuntimeException("该账号正在被操作，请稍后尝试");
        }

        UserViewModel _ret = null;

        try {
            User _entity = userDao.getUserByMail(request.getMail());

            if (_entity != null) {
                throw new RuntimeException("该邮箱已注册");
            }

            Date _now = new Date();

            _entity = new User();
            _entity.setMail(request.getMail());
            _entity.setPassword(request.getPassword());
            _entity.setMobile(request.getMobile());
            _entity.setUserName(request.getUserName());
            _entity.setCreatedTime(_now);
            _entity.setModifiedTime(_now);
            _entity.setDeleted(false);

            _ret = userDao.addUser(_entity);

            if (_ret == null) {
                throw new RuntimeException("创建用户失败");
            }

        } catch(Exception ex) {
            userDao.unlockMail(request.getMail());
            throw new RuntimeException(ex);
        }

        return _ret;
    }

    @Override
    public UserViewModel modifyUser(String id, UserDTO request) {
        if (StringUtility.isNullOrEmpty(id) || request == null) {
            throw new RuntimeException("请求为空");
        }

        if (StringUtility.isNullOrEmpty(request.getPassword())) {
            throw new RuntimeException("无效请求参数");
        }

        User _entity = userDao.getUserById(id);

        if (_entity == null) {
            throw new RuntimeException("待修改用户不存在");
        }

        if (!userDao.lockMail(_entity.getMail())) {
            throw new RuntimeException("该账号正在被操作，请稍后尝试");
        }

        if (!userDao.lockId(id)) {
            userDao.unlockMail(_entity.getMail());
            throw new RuntimeException("该账号正在被操作，请稍后尝试");
        }

        UserViewModel _ret = null;

        try {
            Date _now = new Date();
            _entity.setPassword(request.getPassword());
            _entity.setMobile(request.getMobile());
            _entity.setUserName(request.getUserName());
            _entity.setModifiedTime(_now);

            _ret = userDao.modifyUser(_entity);
        } catch(Exception ex) {
            userDao.unlockMail(_entity.getMail());
            userDao.unlockId(id);
            throw new RuntimeException(ex);
        }

        return _ret;
    }

    @Override
    public boolean deleteUser(String id) {
        if (StringUtility.isNullOrEmpty(id)) {
            throw new RuntimeException("待删除用户索引为空");
        }

        User _entity = userDao.getUserById(id);

        if (_entity == null) {
            throw new RuntimeException("待删除用户不存在");
        }

        if (!userDao.lockMail(_entity.getMail())) {
            throw new RuntimeException("该账号正在被操作，请稍后尝试");
        }

        if (!userDao.lockId(id)) {
            userDao.unlockMail(_entity.getMail());
            throw new RuntimeException("该账号正在被操作，请稍后尝试");
        }

        boolean _bSuccess = false;

        try {
            Date _now = new Date();
            _entity.setDeleted(true);
            _entity.setModifiedTime(_now);

            _bSuccess = userDao.deleteUser(_entity);
        } catch(Exception ex) {
            userDao.unlockMail(_entity.getMail());
            userDao.unlockId(id);
            throw new RuntimeException(ex);
        }

        return _bSuccess;
    }
}
