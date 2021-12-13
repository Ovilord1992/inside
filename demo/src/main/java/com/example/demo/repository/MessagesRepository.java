package com.example.demo.repository;

import com.example.demo.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface MessagesRepository extends CrudRepository<Message, Long> {
    Message findById(long id);
    List<Message> findTop10ByUserIdOrderByIdDesc(int id);
}
