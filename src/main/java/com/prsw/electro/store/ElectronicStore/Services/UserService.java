package com.prsw.electro.store.ElectronicStore.Services;

import com.prsw.electro.store.ElectronicStore.dtos.UserDto;

import java.util.List;

public interface UserService {

    //create

   UserDto CreateUser(UserDto userDto);
    //update

   UserDto updateUser(UserDto userDto,String userId);


    //Delete
   void deleteUser(String userId);


    //get all Users
   List<UserDto>getAllUsers();


    //get User by UserId
   UserDto getUserById(String userId);


    //get User by emailId
    UserDto getUserByemail(String email);


    // search User
   List<UserDto>searchUser(String keyword);


    // search User with
}
