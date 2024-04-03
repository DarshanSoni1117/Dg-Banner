package com.DgBanner.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DgBanner.Entities.Screen;

@Repository
public interface ScreenRepo extends JpaRepository<Screen, Integer> {

//	@Query(nativeQuery = true,value = "SELECT screen_detail.name,screen_detail.resolution,screen_detail.size,screen_detail.location ,screen_detail.is_active, media_preview.preview  FROM screen_detail,media_preview WHERE screen_detail.user_id = ?1 ,media_preview.screen_id=?2, screen_detail.id= ?2, slots_details.screen_id=?2 ")
//	Object[] gettingSpecificScreendetailsById(@Param("ownerId")int ownerId,@Param("screenId")int screenId);

	@Query(nativeQuery = true,value = "SELECT screen_detail.name, screen_detail.resolution, screen_detail.size, screen_detail.location, screen_detail.is_active FROM screen_detail WHERE screen_detail.user_id = :ownerId AND screen_detail.id = :screenId")
	Object[] gettingSpecificScreendetailsById(@Param("ownerId")int ownerId,@Param("screenId")int screenId);
	
	@Query(nativeQuery = true,value="SELECT slots_detail.id,slots_detail.user_id,slots_detail.interval, slots_detail.price, slots_detail.available FROM slots_detail WHERE slots_detail.screen_id=?1")
	List<Object[]> gettingSlotsDetailsByScreenId(@Param("screenId")int screenId);

	@Query(nativeQuery = true,value="SELECT sd.id, sd.name,sd.size,sd.location FROM screen_detail sd WHERE sd.user_id= ?1 ")
	List<Object[]> gettingAllScreenByOwnerId(@Param("ownerId")int ownerId);


}


