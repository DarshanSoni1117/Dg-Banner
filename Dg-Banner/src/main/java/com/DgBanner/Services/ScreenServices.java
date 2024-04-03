package com.DgBanner.Services;

import java.util.List;

import com.DgBanner.DTO.ScreenDto;
import com.DgBanner.DTO.ScreenSpecificDetailDto;
import com.DgBanner.DTO.SlotAllDetailsDto;
import com.DgBanner.Owner.DTO.OwnerScreenDto;

public interface ScreenServices {


	ScreenDto addingScreenDetails(Integer ownerId, ScreenDto screen);

	ScreenDto updatingScreenDetails(Integer ownerId, Integer screenId, ScreenDto screen);

	String deletingScreenDetails(Integer ownerId, Integer screenId);

	List<SlotAllDetailsDto> gettingSlotsDetailsByScreenId(Integer screenId);

	ScreenSpecificDetailDto gettingSpecificScreendetailsById(Integer ownerId,Integer screenId);

	List<OwnerScreenDto> gettingAllScreenByOwnerId(Integer ownerId);
}
