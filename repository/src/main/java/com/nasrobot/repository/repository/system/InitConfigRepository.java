package com.nasrobot.repository.repository.system;

import com.nasrobot.repository.entity.system.InitConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InitConfigRepository extends CrudRepository<InitConfig, Long> {
}
