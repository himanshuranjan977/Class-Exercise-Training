package com.gl.microservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    private String serverCommunication(String serviceName) {
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceName);
        
        return serviceInstance.getUri().toString();
    }

    @PostMapping("/course/add")
    public String addCourse(String name, Double fees) {
    	RestTemplate rt =new RestTemplate();
        String serviceName = "Course-Micro-Service"; // must match Eureka service ID
        String serviceUrl = serverCommunication(serviceName);

        // call microservice
        Course course = new Course(name,fees,null);
        rt.postForEntity(serviceUrl + "/course/add", course, Course.class);

        return "Course added successfully";
    }
}

