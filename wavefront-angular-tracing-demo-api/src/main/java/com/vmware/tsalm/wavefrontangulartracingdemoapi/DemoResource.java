package com.vmware.tsalm.wavefrontangulartracingdemoapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoResource {

    @GetMapping("/hello")
    ResponseEntity<String> fetchHelloWorld() {
        return ResponseEntity.ok("Hello Angular");
    }
}
