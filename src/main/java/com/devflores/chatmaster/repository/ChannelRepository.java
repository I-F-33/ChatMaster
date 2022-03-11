package com.devflores.chatmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devflores.chatmaster.domain.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long>{

}
