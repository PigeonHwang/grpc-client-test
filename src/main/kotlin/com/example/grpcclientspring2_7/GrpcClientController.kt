package com.example.grpcclientspring2_7

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class GrpcClientController {
    @Autowired
    lateinit var grpcClientService: GrpcClientService

    @GetMapping("/ping")
    fun ping(): String {
        return grpcClientService.sendMessage()
    }
}