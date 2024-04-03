package com.DgBanner.Advertiser.Services;

import com.DgBanner.Advertiser.DTO.AdvertiserDto;

public interface AdvertiserServices {

	AdvertiserDto addingAdvertiserDetails(AdvertiserDto advertiserDto);
	AdvertiserDto updatingAdvertiserDetails(Integer advertiserId,AdvertiserDto advertiserDto );
	String deletingAdvertiserDetails(Integer advertiserId);

}
