package com.iot.iotcloud.microservice.account.dao;

import com.iot.iotcloud.library.account.model.po.User;
import com.iot.iotcloud.library.account.model.viewmodel.UserViewModel;
import com.iot.iotcloud.library.dal.dao.IBaseDao;

/**
 * 用户访问数据对象接口
 * @author Ge Jian Feng
 * @version 1.0.0
 */
public interface IUserDao extends IBaseDao {

    /**
     * 通过索引获取用户记录
     * @param id 用户索引
     * @return 用户信息
     */
    User getUserById(String id);

    /**
     * 通过电子邮件获取用户记录
     * @param mail 电子邮件地址
     * @return 用户信息
     */
    User getUserByMail(String mail);

    /**
     * 添加用户
     * @param entity 用户记录
     * @return 用户视图信息
     */
    UserViewModel addUser(User entity);

    /**
     * 修改用户记录
     * @param entity 带修改用户记录
     * @return 用户视图信息
     */
    UserViewModel modifyUser(User entity);

    /**
     * 删除用户记录
     * @param entity 待删除用户记录
     * @return 删除结果
     */
    boolean deleteUser(User entity);

    /**
     * 分布式锁上锁(mail)
     * @param mail 待锁定mail
     * @return 锁定结果
     */
    boolean lockMail(String mail);

    /**
     * 分布式锁解锁(mail)
     * @param mail 待解锁mail
     */
    void unlockMail(String mail);

    /**
     * 分布式锁上锁(id)
     * @param id 待锁定id
     * @return 锁定结果
     */
    boolean lockId(String id);

    /**
     * 分布式锁解锁(id)
     * @param id 待解锁id
     */
    void unlockId(String id);
}
