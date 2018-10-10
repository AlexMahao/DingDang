package com.spearbothy.dingdang.dao;

import com.spearbothy.dingdang.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
