package com.cy.store.controller;

import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cy.store.controller.BaseController.OK;

//@Controller //交给spring来管理
@RestController//等效于@Controller+@ResponseBody
@RequestMapping("users")//申请样的请求会被拦截
public class UserController extends BaseController{ //要继承！！
    @Autowired
    private IUserService userService;
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
}
