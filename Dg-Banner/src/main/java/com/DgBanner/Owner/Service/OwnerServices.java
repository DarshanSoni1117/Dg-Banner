package com.DgBanner.Owner.Service;

import com.DgBanner.Owner.DTO.OwnerResponseDto;



public interface OwnerServices {

	OwnerResponseDto addingOwnerDetails(OwnerResponseDto  ownerResponseDto);
	OwnerResponseDto updatingOwnerDetailsById(OwnerResponseDto  ownerResponseDto, Integer id);
	OwnerResponseDto gettingOwnerDetailsById(Integer id);
	String deletingOwnerDetailsById(Integer id);








}
