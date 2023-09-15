package com.nasrobot.app.mapstructs;

import com.nasrobot.app.vo.request.InitConfigRequest;
import com.nasrobot.repository.entity.system.InitConfig;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructs {

    InitConfig toEntity(InitConfigRequest request);

}
