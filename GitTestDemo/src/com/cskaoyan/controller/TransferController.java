package com.cskaoyan.controller;

import com.production.service.impl.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class TransferController {
    @Autowired
    TransferServiceImpl transferService;
    @RequestMapping("/transfer")
    public ModelAndView transfer(String from,String to,String money)
    {
        boolean transfer =false;
        try {
            transfer = transferService.transfer(from, to, money);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView=new ModelAndView();
        if (transfer)
        {
            modelAndView.setViewName("/success.jsp");
        }
        else
        {
            modelAndView.setViewName("/fail.jsp");
        }
        return modelAndView;
    }
}
