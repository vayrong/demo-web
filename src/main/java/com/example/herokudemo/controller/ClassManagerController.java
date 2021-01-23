package com.example.herokudemo.controller;

import com.example.herokudemo.models.Subject;
import com.example.herokudemo.models.User;
import com.example.herokudemo.pojo.SubjectDto;
import com.example.herokudemo.repositories.SubjectRepository;
import com.example.herokudemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ClassManagerController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SubjectRepository subjectRepository;

    @PostMapping("/subject/save")
    String saveSubject(@RequestBody SubjectDto subjectDto) {
        Subject subject = new Subject();
        subject.setName(subjectDto.getName());
        subjectRepository.save(subject);
        return "success";
    }

    @GetMapping("/user/add-subject")
    String userAddSubject(@RequestParam(name = "userId") Long userId,
                          @RequestParam(name = "subjectId") Long subjectId) {
        User user = userRepository.getOne(userId);
        Subject subject = subjectRepository.getOne(subjectId);
        user.getSubjectSet().add(subject);
        userRepository.save(user);
        return "success";
    }

    @GetMapping("/subject/get")
    String getSubject(@RequestParam(name = "subjectId") Long subjectId) {
        Subject subject = subjectRepository.getOne(subjectId);
        Set<User> userSet = subject.getUserSet();
        System.out.println(userSet.size());
        User user = userSet.iterator().next();
        System.out.println("User name" + user.getName());
        return user.getName();
    }
}
