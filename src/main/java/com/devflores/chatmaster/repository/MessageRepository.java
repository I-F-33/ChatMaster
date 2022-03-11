package com.devflores.chatmaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devflores.chatmaster.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	@Query(value = "SELECT * FROM Messages WHERE channel_id = ?", nativeQuery = true)
    List<Message> findAllByChannelId(Long channelId);
}
