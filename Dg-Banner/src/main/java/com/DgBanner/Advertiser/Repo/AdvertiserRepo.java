package com.DgBanner.Advertiser.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DgBanner.Advertiser.Entities.Advertiser;

@Repository
public interface AdvertiserRepo extends JpaRepository<Advertiser,Integer> {

}
