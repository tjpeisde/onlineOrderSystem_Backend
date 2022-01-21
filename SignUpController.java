package com.tjpeisde.onlineordersystem.controller;

import com.tjpeisde.onlineordersystem.entity.Customer;
import org.springframework.http.HttpStatus;
import com.tjpeisde.onlineordersystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SignUpController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)

    @ResponseStatus(HttpStatus.CREATED)
    //不管成不成功都会返回CREATED 的code
    public void signUp(@RequestBody Customer customer){
        customerService.signUp(customer);
        System.out.println(customer.getFirstName());
        // @RequestBody 主动帮忙converse 到class 上
        // 以前用的HttpServletRequest request
        //@ResponseStatus(HttpStatus.CREATED)
        // 不管成不成功都会返回CREATED 的code
        // eg：
        //public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //       用HttpServletRequest 自己converse到call
        //        response.setContentType("application/json");
        //        ObjectMapper mapper = new ObjectMapper();
        //        Customer customer= new Customer();
        //  自己设定返回值
        // response.setStatus(500);

    }



}
