package com.mgmetehan.springswagger.controller;

import com.mgmetehan.springswagger.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "User Rest Api", description = "User Rest Service")
public class UserController {

    private List<User> userList = new ArrayList<>();

    @PostConstruct
    public void init() {
        userList.add(new User(1L, "Metehan", "Gultekin", "1234"));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Server error")})

    @ApiOperation(value = "List of User")
    @GetMapping({"/users"})
    public List<User> getStudentList() {
        return new ArrayList<>(userList);
    }

    @ApiOperation(value = "New User Adding method", notes = "Use this method carefully")
    @PostMapping
    public ResponseEntity<User> save(@RequestBody @ApiParam(value = "user") User user) {
        userList.add(user);
        return ResponseEntity.ok(user);
    }

}
