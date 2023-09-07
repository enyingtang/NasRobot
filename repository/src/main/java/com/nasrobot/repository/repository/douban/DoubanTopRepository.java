package com.nasrobot.repository.repository.douban;

import com.nasrobot.repository.entity.douban.DoubanTop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoubanTopRepository extends CrudRepository<DoubanTop, Long> {
}
