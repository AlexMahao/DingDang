package com.spearbothy.dingdang.dao;

import com.spearbothy.dingdang.entity.InformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * InformationRepository
 */
@Repository
public interface InformationRepository extends JpaRepository<InformationEntity,Long> {

}
