package com.iot.iotcloud.library.account.model.dto;

import com.iot.iotcloud.library.model.dto.RequestDTO;

import java.util.Date;

/**
 * 用户DTO
 * @author Ge Jian Feng
 * @version 1.0.0
 */
public final class UserDTO extends RequestDTO {

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
}
