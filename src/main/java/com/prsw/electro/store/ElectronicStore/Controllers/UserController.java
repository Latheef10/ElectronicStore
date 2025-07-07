package com.prsw.electro.store.ElectronicStore.Controllers;

import com.prsw.electro.store.ElectronicStore.Responses.APIResponse;
import com.prsw.electro.store.ElectronicStore.Services.UserService;
import com.prsw.electro.store.ElectronicStore.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class UserController {
    
    @Autowired
    UserService userService;
    
    @PostMapping("create")
    public ResponseEntity<UserDto>  createUSer(@RequestBody UserDto userDto){

        UserDto createUser = userService.CreateUser(userDto);

        return new ResponseEntity<>(createUser , HttpStatus.CREATED);
        
    }
    @GetMapping("users")
    public ResponseEntity<List<UserDto>>  getallUsers(){

        List<UserDto> allUsers = userService.getAllUsers();

        return new ResponseEntity<>(allUsers , HttpStatus.OK);

    }
    @PutMapping("/user/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId")  String userId){

        UserDto updateduser = userService.updateUser(userDto,userId);

        return ResponseEntity.ok(updateduser);

    }
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<APIResponse<Object>> deleteuser(@PathVariable("userId")  String userId){

        UserDto deleteUser = userService.deleteUser(userId);

        APIResponse<Object> res = APIResponse.builder()
                .timeStamp(LocalDate.now())
                .status(HttpStatus.OK)
                .message("User Deleted")
                .data(deleteUser)
                .build();

        return new ResponseEntity<>(res,HttpStatus.OK);


    }
    @GetMapping("user/{userId}")
    public ResponseEntity<APIResponse<UserDto>> getuser(@PathVariable("userId") String userId) {
        UserDto userById = userService.getUserById(userId);
        APIResponse<UserDto> res = APIResponse.<UserDto>builder()
                .timeStamp(LocalDate.now())
                .status(HttpStatus.OK)
                .message("user found")
                .data(userById)
                .build();

        return ResponseEntity.ok(res);
    }



}
