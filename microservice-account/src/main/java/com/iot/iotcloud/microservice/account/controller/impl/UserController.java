package com.iot.iotcloud.microservice.account.controller.impl;

import com.iot.iotcloud.library.account.model.dto.UserDTO;
import com.iot.iotcloud.library.account.model.viewmodel.UserViewModel;
import com.iot.iotcloud.library.common.utility.LogUtility;
import com.iot.iotcloud.library.common.utility.StringUtility;
import com.iot.iotcloud.library.core.controller.impl.BaseController;
import com.iot.iotcloud.library.model.dto.CommonResponseDTO;
import com.iot.iotcloud.microservice.account.controller.IUserController;
import com.iot.iotcloud.microservice.account.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器实现
 * @author Ge Jian Feng
 * @version 1.0.0
 */
@RestController
@RequestMapping("account-api/v1")
public class UserController extends BaseController implements IUserController {

    /**
     * 用户服务
     */
    @Autowired
    protected IUserService userService;

    /**
     * 日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    @RequestMapping(value = "user", method = RequestMethod.POST, produces = "application/json")
    public CommonResponseDTO<UserViewModel> addUser(@RequestBody  UserDTO request) {
        CommonResponseDTO<UserViewModel> _response = new CommonResponseDTO<>();

        try {
            UserViewModel _userViewModel = userService.addUser(request);

            if (_userViewModel == null) {
                throw new RuntimeException("添加用户失败");
            }
            else {
                _response.setResult("success");
                _response.setData(_userViewModel);
            }
        } catch(Exception ex) {
            _response.setResult(ex.getMessage());
            LogUtility.logError(logger, ex.getMessage(), request, ex);
        }

        return _response;
    }

    @Override
    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT, produces = "application/json")
    public CommonResponseDTO<UserViewModel> modifyUser(@PathVariable String id, @RequestBody UserDTO request) {
        CommonResponseDTO<UserViewModel> _response = new CommonResponseDTO<>();

        try {
            UserViewModel _userViewModel = userService.modifyUser(id, request);

            if (_userViewModel == null) {
                throw new RuntimeException("修改用户失败");
            }
            else {
                _response.setResult("success");
                _response.setData(_userViewModel);
            }
        } catch(Exception ex) {
            _response.setResult(ex.getMessage());
            LogUtility.logError(logger, (StringUtility.isNullOrEmpty(id) ? ex.getMessage() : (ex.getMessage() + " | " + id)), request, ex);
        }

        return _response;
    }

    @Override
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public CommonResponseDTO<Object> deleteUser(@PathVariable String id) {
        CommonResponseDTO<Object> _response = new CommonResponseDTO<>();

        try {
            boolean _bSuccess = userService.deleteUser(id);

            if (_bSuccess) {
                _response.setResult("success");
            }
            else {
                throw new RuntimeException("删除用户失败");
            }
        } catch(Exception ex) {
            _response.setResult(ex.getMessage());
            LogUtility.logError(logger, (StringUtility.isNullOrEmpty(id) ? ex.getMessage() : (ex.getMessage() + " | " + id)) , ex);
        }

        return _response;
    }
}
