package com.nasrobot.app.web.system;


import com.nasrobot.app.services.init.NasRobotInitService;
import com.nasrobot.app.vo.request.InitConfigRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/system")
public class SystemInitController {

    @Autowired
    private NasRobotInitService nasRobotInitService;

    @PostMapping("isInited")
    public boolean isInited() {
        return nasRobotInitService.isInited();
    }

    @PostMapping("init")
    public boolean init(InitConfigRequest request) {
        return nasRobotInitService.init(request);
    }
}
