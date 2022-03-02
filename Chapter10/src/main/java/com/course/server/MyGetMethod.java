package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {

    /**
     *  HttpServletRequest 装请求信息的类
     *  HttpServletResponse 装响应信息的类
     */

    // 设置访问路径和访问方法
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies", httpMethod = "GET")
    public String getCookies(HttpServletResponse response){

        // 添加Cookies信息
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }

    /**
     * 要求客户端携带cookies访问
     */
    @RequestMapping(value = "/getWithCookies", method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies访问", httpMethod = "GET")
    public String  StringWithCookies(HttpServletRequest request){

        Cookie[] cookies =request.getCookies();
        // 判断对象为空,等价XXX==null
        if (Objects.isNull(cookies)){
            return "你必须携带cookies信息来";
        }
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("login") &&
                    cookie.getValue().equals("true")){
                return "恭喜你访问成功";
            }
        }
        return "你必须携带cookies信息来";
    }

    /**
     * 开发一个需要携带参数才能访问的get请求
     * 方式一，url：key1=value1&key2=value2
     * 模拟获取商品列表接口
     */
    @RequestMapping(value = "/get-with-param", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带get才能访问的get请求方式一", httpMethod = "GET")
    public Map<String,Integer> myGetList1(@RequestParam  Integer start,
                                       @RequestParam Integer end)
    {   // 商品列表
        Map<String, Integer> myList = new HashMap<>();
        myList.put("皮鞋", 400);
        myList.put("衬衫", 1);
        myList.put("领带", 300);

        return myList;
    }
    /**
     * 开发一个需要携带参数才能访问的get请求
     *  方式二，url：ip:port/get-with-param/10/20
     *  与方式一不同点就是使用的访问路径有所区别
     *  模拟获取商品列表接口
     */
    @RequestMapping(value = "/get-with-param/{start}/{end}")
    @ApiOperation(value = "需要携带get才能访问的get请求方式二", httpMethod = "GET")
    public Map<String, Integer> myGetList2(@PathVariable Integer start,
                                          @PathVariable Integer end)
    {
        // 商品列表
        Map<String, Integer> myList = new HashMap<>();
        myList.put("皮鞋", 400);
        myList.put("衬衫", 1);
        myList.put("领带", 300);

        return myList;
    }

}
