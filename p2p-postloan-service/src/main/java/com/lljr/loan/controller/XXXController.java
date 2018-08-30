//package com.lljr.loan.controller;
//
//import io.goudai.starter.id.generator.zookeeper.IdGenerator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author tianhuan
// * @date 2018-08-30 14:51
// **/
//@RestController
//public class XXXController {
//    @Autowired
//    IdGenerator idGenerator;
//
//    @GetMapping("idString")
//    public String idString() {
//        return idGenerator.nextIdAsString();
//    }
//
//    @GetMapping("idLong")
//    public Long idLong() {
//        return idGenerator.nextIdAsLong();
//    }
//}
