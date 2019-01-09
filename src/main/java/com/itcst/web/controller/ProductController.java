package com.itcst.web.controller;

import com.itcast.domain.Product;
import com.itcast.service.IProductService;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

import java.util.List;
@Controller
public class ProductController {
          @Autowired
   private IProductService service;

          @RequestMapping("/findAll.do")
   public ModelAndView findAll(){

       ModelAndView view=new ModelAndView();
       List<Product> all = service.findAll();
       view.addObject("productList",all);
       view.setViewName("product-list");

       return view;
   }
@RequestMapping("/save.do")
   public String save(Product product){
       service.save(product);
       return  "forward:findAll.do";
   }
}
