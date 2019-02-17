package com.yanwuyu.controller;

import com.yanwuyu.service.InitServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping(name = "init类",value = {"/init"})
@Api(value = "init",description = "初始化数据接口")
public class InitController {
    @Autowired
    private InitServiceImpl initService;
    @ApiOperation(value = "init",notes = "初始化数据库的核心方法")
    @ApiResponses(value = {
            @ApiResponse(code = 404,message = "初始化错误"),
            @ApiResponse(code = 200,message = "初始化成功")
    })
    @RequestMapping(value ={"/init"},method =RequestMethod.POST)
    public ResponseEntity<Void> init(){


        initService.init();
        return new ResponseEntity<>(HttpStatus.OK);


    }
}
