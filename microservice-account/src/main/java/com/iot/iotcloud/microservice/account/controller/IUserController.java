package com.iot.iotcloud.microservice.account.controller;

import com.iot.iotcloud.library.account.model.dto.UserDTO;
import com.iot.iotcloud.library.account.model.viewmodel.UserViewModel;
import com.iot.iotcloud.library.core.controller.IBaseController;
import com.iot.iotcloud.library.model.dto.CommonResponseDTO;

/**
 * 用户控制器接口
 * @author Ge Jian Feng
 * @version 1.0.0
 */
public interface IUserController extends IBaseController {

    /**
     * 添加用户
     * @param request 添加用户DTO
     * @return 新建用户信息
     */
    CommonResponseDTO<UserViewModel> addUser(UserDTO request);

    /**
     * 修改用户
     * @param id 待修改用户索引
     * @param request 修改用户DTO
     * @return 修改后用户信息
     */
    CommonResponseDTO<UserViewModel> modifyUser(String id, UserDTO request);

    /**
     * 删除用户
     * @param id 待删除用户索引
     * @return 删除用户操作结果
     */
    CommonResponseDTO<Object> deleteUser(String id);
}
