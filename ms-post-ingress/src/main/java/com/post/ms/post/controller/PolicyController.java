package com.post.ms.post.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/privacy")
public class PolicyController {

    @GetMapping
    public String privacy() {
        return """
        Privacy Policy
        
        This application is created for educational purposes.
        No personal data is stored or shared with third parties.
        Data received from Meta APIs is used only for demonstration and analysis.
        Contact: mamedlinuran0006@gmail.com
        """;
    }
}
