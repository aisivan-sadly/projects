package com.example.JavaLabSpringCloudWeb;

import com.example.JavaLabSpringCloudWeb.model.Course;
import com.example.JavaLabSpringCloudWeb.service.CourseService;
import com.example.JavaLabSpringCloudWeb.source.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
public class WebController {

    public Integer user_id = null;

    @Autowired
    public CourseService autoRepairService;

    @Autowired
    public Sender sender;

    @GetMapping("/autoRepair/{id}")
    public ResponseEntity<String> getautoRepair(@PathVariable int id) {
        return new ResponseEntity<String>(autoRepairService.getautoRepair(id).toString(),null,HttpStatus.OK);
    }

    @GetMapping("/autoRepair")
    public ResponseEntity<String> getAllautoRepair() {
        List<autoRepair> autoRepair = autoRepairService.getAllautoRepair();
        StringBuilder stringBuilder = new StringBuilder();
        for (Course autoRepair : autoRepair){
            stringBuilder.append(autoRepair.briefDescription());
        }
        return new ResponseEntity<>(stringBuilder.toString(), HttpStatus.OK);
    }

    @PostMapping("/autoRepair/{id}/subscribe")
    public ResponseEntity<String> subscribe(@PathVariable int id) {
        if (user_id == null) return new ResponseEntity<>("You're not signed in!", HttpStatus.OK);
        if (autoRepairService.getautoRepair(id) == null) return new ResponseEntity<>("No such auto repair", HttpStatus.OK);
        sender.ask_to_sub(user_id, id);
        return new ResponseEntity<>("Sent subscription request", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("user_id") int user_id, @RequestParam("code") int code){
        String result = "";
        if (sender.login(user_id,code)) {
            result = "Success";
            this.user_id = user_id;
        } else {
            result = "Wrong code";
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/subscriptions")
    public ResponseEntity<String> autoRepairSubscriptions(){
        if (user_id == null) return new ResponseEntity<>("You're not signed in!", HttpStatus.OK);
        List<Integer> subscriptions = sender.get_subscriptions(user_id);
        List<Course> autoRepairs =  courseService.autoRepair(subscriptions);
        StringBuilder stringBuilder = new StringBuilder();
        for (AutoRepair autoRepaire : autoRepair) {
            stringBuilder.append(autoRepair.briefDescription());
        }
        return new ResponseEntity<>(stringBuilder.toString(), HttpStatus.OK);
    }
}
