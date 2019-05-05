package com.iot.iotcloud.library.account.model.viewmodel;

import com.iot.iotcloud.library.account.model.po.User;
import com.iot.iotcloud.library.model.viewmodel.BaseViewModel;

import java.util.Date;

/**
 * 用户视图模型
 * @author Ge Jian Feng
 * @version 1.0.0
 */
public final class UserViewModel extends BaseViewModel {

    /**
     * 索引
     */
    protected String id;

    /**
     * 用户邮箱
     */
    protected String mail;

    /**
     * 密码
     */
    protected String password;

    /**
     * 用户名
     */
    protected String userName;

    /**
     * 手机
     */
    protected String mobile;

    /**
     * 最后登陆ip
     */
    protected String lastLoginIp;

    /**
     * 最后登陆时间
     */
    protected Date lastLoginTime;

    /**
     * 获取索引
     * @return 索引
     */
    public String getId() {
        return id;
    }

    /**
     * 设置索引
     * @param id 待设置索引
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用户邮箱
     * @return 用户邮箱
     */
    public String getMail() {
        return mail;
    }

    /**
     * 设置用户邮箱
     * @param mail 待设置用户邮箱
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 获取用户密码
     * @return 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     * @param password 待设置用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户名
     * @return 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     * @param userName 待设置用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户手机
     * @return 用户手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置用户手机
     * @param mobile 待设置用户手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取最后登陆ip
     * @return 最后登陆ip
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 设置最后登陆ip
     * @param lastLoginIp 待设置最后登陆ip
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * 获取最后登陆时间
     * @return 最后登陆时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后登陆时间
     * @param lastLoginTime 待设置最后登陆时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取用户视图信息
     * @param entity 用户实体记录
     * @return 用户视图信息
     */
    public static UserViewModel getUserViewModel(User entity) {
        if (entity == null) {
            return null;
        }

        UserViewModel _ret = new UserViewModel();
        _ret.setId(entity.getId());
        _ret.setMail(entity.getMail());
        _ret.setUserName(entity.getUserName());
        _ret.setPassword(entity.getPassword());
        _ret.setMobile(entity.getMobile());
        _ret.setLastLoginIp(entity.getLastLoginIp());
        _ret.setLastLoginTime(entity.getLastLoginTime());
        return _ret;
    }

}
