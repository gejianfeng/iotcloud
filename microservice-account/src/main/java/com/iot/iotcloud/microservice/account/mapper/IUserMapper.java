package com.iot.iotcloud.microservice.account.mapper;

import com.iot.iotcloud.library.account.model.po.User;
import com.iot.iotcloud.library.account.model.viewmodel.UserViewModel;
import com.iot.iotcloud.library.dal.mapper.IBaseMapper;
import org.apache.ibatis.annotations.*;

/**
 * 用户数据映射接口
 * @author Ge Jian Feng
 * @version 1.0.0
 */
@Mapper
public interface IUserMapper extends IBaseMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "mail", column = "mail"),
            @Result(property = "password", column = "password"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "lastLoginIp", column = "last_login_ip"),
            @Result(property = "lastLoginTime", column = "last_login_time")
    })
    @Select("SELECT * FROM t_user WHERE id = #{id} and is_deleted = false")
    UserViewModel getUserViewModelById(String id);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "mail", column = "mail"),
            @Result(property = "password", column = "password"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "lastLoginIp", column = "last_login_ip"),
            @Result(property = "lastLoginTime", column = "last_login_time"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "modifiedTime", column = "modified_time"),
            @Result(property = "createdBy", column = "created_by"),
            @Result(property = "modifiedBy", column = "modified_by")
    })
    @Select("SELECT * FROM t_user WHERE id = #{id}::uuid and is_deleted = false")
    User getUserById(String id);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "mail", column = "mail"),
            @Result(property = "password", column = "password"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "lastLoginIp", column = "last_login_ip"),
            @Result(property = "lastLoginTime", column = "last_login_time")
    })
    @Select("SELECT * FROM t_user WHERE mail = #{mail} and is_deleted = false")
    UserViewModel getUserViewModelByMail(String mail);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "mail", column = "mail"),
            @Result(property = "password", column = "password"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "lastLoginIp", column = "last_login_ip"),
            @Result(property = "lastLoginTime", column = "last_login_time"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "modifiedTime", column = "modified_time"),
            @Result(property = "createdBy", column = "created_by"),
            @Result(property = "modifiedBy", column = "modified_by")
    })
    @Select("SELECT * FROM t_user WHERE mail = #{mail} and is_deleted = false")
    User getUserByMail(String mail);

    @Insert("INSERT INTO t_user(" +
            "id," +
            "mail, " +
            "password, " +
            "user_name, " +
            "mobile, " +
            "created_time, " +
            "modified_time, " +
            "created_by, " +
            "modified_by, " +
            "last_login_ip, " +
            "last_login_time, " +
            "is_deleted) " +
            "VALUES(" +
            "uuid_generate_v4()," +
            "#{mail}, " +
            "#{password}, " +
            "#{userName}, " +
            "#{mobile}, " +
            "#{createdTime}, " +
            "#{modifiedTime}, " +
            "#{createdBy}, " +
            "#{modifiedBy}, " +
            "#{lastLoginIp}, " +
            "#{lastLoginTime}, " +
            "#{isDeleted})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertUser(User entity);

    @Update("UPDATE t_user set is_deleted = #{isDeleted}, modified_by = #{modifiedBy}, modified_time = #{modifiedTime} where id = #{id}::uuid")
    void deleteUser(User entity);

    @Update("UPDATE t_user set " +
            "mail = #{mail}, " +
            "password = #{password}, " +
            "user_name = #{userName}, " +
            "mobile = #{mobile}, " +
            "created_time = #{createdTime}, " +
            "modified_time = #{modifiedTime}, " +
            "created_by = #{createdBy}, " +
            "modified_by = #{modifiedBy}, " +
            "last_login_ip = #{lastLoginIp}, " +
            "last_login_time = #{lastLoginTime}" +
            "WHERE id = #{id}::uuid")
    void updateUser(User entity);
}
