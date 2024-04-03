package com.DgBanner.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DgBanner.Entities.Slots;

@Repository
public interface SlotsRepo extends JpaRepository<Slots, Integer> {



}
