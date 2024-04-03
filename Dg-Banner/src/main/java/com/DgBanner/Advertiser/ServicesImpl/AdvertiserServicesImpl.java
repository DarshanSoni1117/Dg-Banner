package com.DgBanner.Advertiser.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DgBanner.Advertiser.DTO.AdvertiserDto;
import com.DgBanner.Advertiser.Repo.AdvertiserRepo;
import com.DgBanner.Advertiser.Services.AdvertiserServices;

@Service
public class AdvertiserServicesImpl implements AdvertiserServices{

	@Autowired
	AdvertiserRepo advertiserRepo;

	@Override
	public AdvertiserDto addingAdvertiserDetails(AdvertiserDto advertiserDto) {

		return null;
	}

	@Override
	public AdvertiserDto updatingAdvertiserDetails(Integer advertiserId, AdvertiserDto advertiserDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletingAdvertiserDetails(Integer advertiserId) {
		// TODO Auto-generated method stub
		return null;
	}


}
