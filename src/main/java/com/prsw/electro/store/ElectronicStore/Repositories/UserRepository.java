package com.prsw.electro.store.ElectronicStore.Repositories;

import com.prsw.electro.store.ElectronicStore.Entities.User;
import com.prsw.electro.store.ElectronicStore.dtos.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

   Optional<UserDto> findByEmail(String email);
   Optional<UserDto> findByEmailAndPassword(String email, String password);

}
