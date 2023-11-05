package com.cy.store.controller;

import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;

import static com.cy.store.controller.BaseController.OK;

//@Controller //交给spring来管理
@RestController//等效于@Controller+@ResponseBody
@RequestMapping("users")//申请样的请求会被拦截
public class UserController extends BaseController{ //要继承！！
    @Autowired
    private IUserService userService;


    /**
     *注册和登录是两种接收数据的方式：
     * 1.注册的请求处理方法的参数列表是pojo类型来接收前端的数据，SpringBoot会将前端的url中的参数名和pojo类的属性名进行比较，找到对应的属性，将值注入到对应的属性中
     * 2.登录的请求处理方法的参数列表是非pojo类型,直接传参
     */
    @RequestMapping("reg")//user下的reg可以拦截到此方法当中/**http://localhost:8080/users/reg?username=zzy521&password=123*/
//    @ResponseBody//表示此方法的响应结果以json格式进行数据的相应给到前端
    public JsonResult<Void> reg(User user){
//        //创建相应结果对象
//        JsonResult<Void> result = new JsonResult<>();
//        try {
            userService.reg(user);
//            result.setState(200);
//            result.setMessage("用户注册成功");
//        } catch (UsernameDuplicatedException e) {
//            result.setState(4000);
//            result.setMessage("用户名被占用");
//        } catch (InsertException e){
//            result.setState(5000);
//            result.setMessage("注册时产生未知的异常");
//        }
        return new JsonResult<>(OK);

    }
    @RequestMapping("login")
    public JsonResult<User> login(String username,String password){
        User user = userService.login(username,password);
        return new JsonResult<User>(OK,user);
    }
}
