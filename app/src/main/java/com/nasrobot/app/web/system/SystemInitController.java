package com.nasrobot.app.web.system;


import com.nasrobot.app.mapstructs.MapStructs;
import com.nasrobot.app.services.init.NasRobotInitService;
import com.nasrobot.app.vo.request.InitConfigRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/system")
@Slf4j
public class SystemInitController {

    private final NasRobotInitService nasRobotInitService;
    private final MapStructs mapStructs;

    public SystemInitController(NasRobotInitService nasRobotInitService, MapStructs mapStructs) {
        this.nasRobotInitService = nasRobotInitService;
        this.mapStructs = mapStructs;
    }

    @PostMapping("isInited")
    public boolean isInited() {
        return nasRobotInitService.isInited();
    }

    @PostMapping("init")
    public boolean init(@Valid @RequestBody InitConfigRequest request) {
        try {
            nasRobotInitService.init(mapStructs.toEntity(request));
            return true;
        } catch (Exception e) {
            log.error("[system] 初始化失败", e);
            return false;
        }
    }
}
