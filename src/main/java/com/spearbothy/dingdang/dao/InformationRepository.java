package com.spearbothy.dingdang.dao;

import com.spearbothy.dingdang.entity.InformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * InformationRepository
 */
@Repository
public interface InformationRepository extends JpaRepository<InformationEntity,Long> {

    @Query(value = " select * from t_information  where type=1? order by browseCount", nativeQuery = true)
    List<InformationEntity> getInfosByType(int type);

}
