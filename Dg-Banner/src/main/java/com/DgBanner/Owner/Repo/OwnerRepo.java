package com.DgBanner.Owner.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DgBanner.Owner.Entities.Owner;


@Repository
public interface OwnerRepo extends JpaRepository<Owner, Integer> {


}
