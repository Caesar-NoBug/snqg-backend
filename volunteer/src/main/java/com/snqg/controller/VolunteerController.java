package com.snqg.controller;

import com.snqg.domain.response.children.ChildrenVO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
@RequestMapping("/children")
public class VolunteerController {

    @PostMapping("/login/{code}")
    public ChildrenVO login(@PathVariable String code) {

    }
}
