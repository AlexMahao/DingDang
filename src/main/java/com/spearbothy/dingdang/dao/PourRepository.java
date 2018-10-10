package com.spearbothy.dingdang.dao;

import com.spearbothy.dingdang.entity.PourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PourRepository
 */
@Repository
public interface PourRepository extends JpaRepository<PourEntity,Long> {
}
