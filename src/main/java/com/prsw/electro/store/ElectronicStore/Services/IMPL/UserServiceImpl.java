package com.prsw.electro.store.ElectronicStore.Services.IMPL;

import com.prsw.electro.store.ElectronicStore.Entities.User;
import com.prsw.electro.store.ElectronicStore.Repositories.UserRepository;
import com.prsw.electro.store.ElectronicStore.Services.UserService;
import com.prsw.electro.store.ElectronicStore.dtos.UserDto;
import com.prsw.electro.store.ElectronicStore.exceptions.UserNotFoundEXception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * @param userDto
     * @return
     */
    @Override
    public UserDto CreateUser(UserDto userDto) {

        String userId = UUID.randomUUID().toString();
        userDto.setUserId(userId);

        User user = dtoTOUser(userDto);
        User saveUser = userRepository.save(user);

        UserDto newDto = UserToDto(saveUser);
        return newDto;
    }




    /**
     * @param userDto
     * @param userId
     * @return
     */
    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        User ExistingUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("USer not found"));
        
        ExistingUser.setName(userDto.getName());
        ExistingUser.setEmail(userDto.getEmail());
        ExistingUser.setAbout(userDto.getAbout());
        ExistingUser.setImageName(userDto.getImageName());
        ExistingUser.setPassword(userDto.getPassword());

        User updateduser = userRepository.save(ExistingUser);

        return UserToDto(updateduser) ;
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public UserDto deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundEXception("user not found with id " +userId));

        UserDto userDto = UserToDto(user);
        userRepository.delete(user);

        return userDto;
    }

    /**
     * @return
     */
    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users
                .stream()
                .map(user->new UserDto(user.getName(), user.getUserId(), user.getAbout(), user.getEmail(),user.getImageName(), user.getGender(),user.getPassword()))
                .toList();
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public UserDto getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundEXception("User not found with id " + userId));
        return UserToDto(user);
    }

    /**
     * @param email
     * @return
     */
    @Override
    public UserDto getUserByemail(String email) {
        UserDto user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundEXception("USer not found with given email id"));
        return user;
    }

    /**
     * @param keyword
     * @return
     */
    @Override
    public List<UserDto> searchUser(String keyword) {
        return List.of();
    }

    //MApper method

    private User dtoTOUser(UserDto userDto) {

        User user = User.builder()
                .userId(userDto.getUserId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .about(userDto.getAbout())
                .gender(userDto.getGender())
                .imageName(userDto.getImageName())
                .build();


        return  user;
    }


    private UserDto UserToDto(User saveUser) {

        UserDto newdto = UserDto.builder()
                .userId(saveUser.getUserId())
                .name(saveUser.getName())
                .email(saveUser.getEmail())
                .password(saveUser.getPassword())
                .about(saveUser.getAbout())
                .gender(saveUser.getGender())
                .imageName(saveUser.getImageName())
                .build();
        return newdto;
    }
}
