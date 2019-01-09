package com.itcst.web.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.domain.Order;
import com.itcast.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private IOrderService service;
//@RequestMapping("/find.do")
//    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "4") int size){
//        List<Order> all = service.findAll();
//        ModelAndView view=new ModelAndView();
//         PageInfo info=new PageInfo(all);
//        view.addObject("ordersList",info);
//        view.setViewName("orders-list");
//        return view;
//    }

    @RequestMapping("/find.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "4") int size){
        List<Order> all = service.findAll( page,size);
        ModelAndView view=new ModelAndView();
        PageInfo info=new PageInfo(all);
        view.addObject("ordersList",info);
        view.setViewName("orders-list1");
        return view;
    }

     @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id){
         System.out.println(id);
        ModelAndView view=new ModelAndView();
       Order order =service.findById(id);

       view.addObject("orders",order);
       view.setViewName("orders-show");
        return view;
     }
}
