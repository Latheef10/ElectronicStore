package com.prsw.electro.store.ElectronicStore.Repositories;

import com.prsw.electro.store.ElectronicStore.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
