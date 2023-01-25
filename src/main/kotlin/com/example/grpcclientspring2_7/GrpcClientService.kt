package com.example.grpcclientspring2_7

import com.example.grpcclienttest.model.protobuf.MyServiceGrpc
import com.example.grpcclienttest.model.protobuf.Req
import net.devh.boot.grpc.client.inject.GrpcClient
import org.springframework.stereotype.Service

@Service
class GrpcClientService {
    @GrpcClient("projectf-kotlin")
    lateinit var myService: MyServiceGrpc.MyServiceBlockingStub

    fun sendMessage(): String {
        return try {
            val response = this.myService
                .pingPong(
                    Req.newBuilder()
                        .setMessage("ping")
                        .build()
                )
            println(response)
            response.message
        } catch (e: Exception) {
            "error"
        }
    }
}