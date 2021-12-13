package com.example.demo.controller;

import com.example.demo.entity.Message;
import com.example.demo.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class MessagesController {

    @Autowired
    private MessagesService messagesService;

    @PostMapping("/message")
    public List<Message> send(@RequestBody Message message) throws Exception {
        return messagesService.messages(message);
    }

}
