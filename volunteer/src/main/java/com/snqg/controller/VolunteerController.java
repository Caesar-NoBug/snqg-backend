package com.snqg.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
@RequestMapping("/children")
public class ChildrenController {

    @PostMapping("/login/{code}")
    public ChildrenVO login(@PathVariable String code) {

    }
}
