package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entity.LogModel;
import repo.CustomerLogRepo;

@RestController
public class CustomerLogController {
    
    @Autowired
    private CustomerLogRepo customerLogRepo;

    @GetMapping("/checkIn")
    public LogModel checkIn(@RequestParam("name") String name){
        LogModel logModel = new LogModel(name, "IN");
        return customerLogRepo.save(logModel);
    }

    @GetMapping("/checkOut")
    public LogModel checkOut(@RequestParam("name") String name){
        LogModel logModel = new LogModel(name, "OUT");
        return customerLogRepo.save(logModel);
    }

    @GetMapping("/getLog")
    public List<LogModel> getLogByDate(@RequestParam("date") String date){
        return customerLogRepo.findByDate(date);
    }

    @GetMapping("/getAllLog")
    public List<LogModel> getAllLog(){
        return customerLogRepo.findAll();
    }

    @GetMapping("/check")
    public String greet(){
        return "hello";
    }
}
