package com.example.demo.service;

import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.repository.MessagesRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesService {
    @Autowired
    private MessagesRepository messagesRepository;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;

    public List<Message> messages(Message message) throws Exception {
        if (userDetailsService.loadUserByUsername(message.getUsername()) != null && message.getMessage().equals("history 10")){
            User user = userRepository.findByUserName(message.getUsername());
            return messagesRepository.findTop10ByUserIdOrderByIdDesc(user.getId());
        }
        if(userDetailsService.loadUserByUsername(message.getUsername()) != null){
            Message m = new Message();
            m.setUsername(message.getUsername());
            m.setMessage(message.getMessage());
            m.setUser(userRepository.findByUserName(message.getUsername()));
            messagesRepository.save(m);
            return List.of(m);
        }else {
            throw new Exception("message dont save");
        }
    }

}
