package com.sarohi.vehicle.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/customer")
    String getCustomerString();

}
