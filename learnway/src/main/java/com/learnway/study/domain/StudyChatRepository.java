package com.learnway.study.domain;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StudyChatRepository extends JpaRepository<ChatRoom, Integer> {

}
