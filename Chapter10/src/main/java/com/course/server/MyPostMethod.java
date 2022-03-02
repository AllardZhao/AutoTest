package com.course.server;


import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/", description = "这是我全部的post请求")
// 类上加了路径映射，类里所有方法的路径映射前缀都会自动加上
@RequestMapping("/v1")
public class MyPostMethod {

    // 这个变量是用来装cookies信息
    private static Cookie cookie;

    /**
     * 用户登录成功获取到cookies
     * 然后再访问其他接口获取到列表
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String userName,
                        @RequestParam(value = "passWord", required = true) String passWord)
    {
        if (userName.equals("xiaoKang") && passWord.equals("123456")){
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "恭喜你登录成功了！";
        }
        // 没有登录成功
        return "用户名或者是密码错误！";
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                                                @RequestBody User u){
        User user;
        // 获取cookies
        Cookie[] cookies =request.getCookies();
        // 验证cookies是否合法
        for(Cookie c: cookies){
            // "=="是比对的地址，equals()值比对
            if (c.getName().equals("login")  && c.getValue().equals("true")
                    && u.getUserName().equals("xiaoKang")
                    && u.getPassWord().equals("123456") ){
                // 验证通过之后返回用户列表
                user = new User();
                user.setName("xiaoMing");
                user.setAge("18");
                user.setSex("man");
               return user.toString();
            }
        }
        return "参数不合法";
    }

}
