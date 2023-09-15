package com.nasrobot.repository.repository.douban;

import com.nasrobot.repository.entity.douban.DoubanWantWatch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoubanWantWatchRepository extends CrudRepository<DoubanWantWatch, String> {
}
