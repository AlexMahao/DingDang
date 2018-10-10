package com.spearbothy.dingdang.dao;

import com.spearbothy.dingdang.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CommentRepository
 */
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {
}
