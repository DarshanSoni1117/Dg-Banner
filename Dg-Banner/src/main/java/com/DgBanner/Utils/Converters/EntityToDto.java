package com.DgBanner.Utils.Converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.DgBanner.Advertiser.DTO.AdvertiserDto;
import com.DgBanner.Advertiser.Entities.Advertiser;
import com.DgBanner.DTO.ScreenDto;
import com.DgBanner.DTO.SlotsDto;
import com.DgBanner.Entities.Screen;
import com.DgBanner.Entities.Slots;
import com.DgBanner.Owner.DTO.OwnerResponseDto;
import com.DgBanner.Owner.Entities.Owner;

@Component
public class EntityToDto {

	public OwnerResponseDto ownerToOwnerResponseDto(Owner owner) {
		OwnerResponseDto dto= new OwnerResponseDto();
		dto.setName(owner.getName());
		dto.setMailId(owner.getMailId());
		dto.setContactNumber(owner.getContactNumber());
		return dto;
	}

	public ScreenDto screenToScreenDto(Screen screen ) {
		ScreenDto dto= new ScreenDto();

		dto.setName(screen.getName());
		dto.setLocation(screen.getLocation());
		dto.setPreview(screen.getMediaPreview());
		dto.setResolution(screen.getResolution());
		dto.setSize(screen.getSize());
		List<SlotsDto> dtoList= new ArrayList();
		for(Slots s : screen.getSlots()) {
			dtoList.add(this.slotsToSlotsDto(s));
		}

		dto.setSlots(dtoList);


		return dto;
	}

	public SlotsDto slotsToSlotsDto(Slots slots) {

		SlotsDto slotsDto = new SlotsDto();

		slotsDto.setInterval(slots.getInterval());
		slotsDto.setPrice(slots.getPrice());

		return slotsDto;
	}

	public AdvertiserDto advertiserToAdvertiserDto(Advertiser advertiser) {
		AdvertiserDto advertiserDto= new AdvertiserDto();
		advertiserDto.setContactNumber(advertiser.getContactNumber());
		advertiserDto.setMailId(advertiser.getMailId());
		advertiserDto.setName(advertiser.getName());
		return advertiserDto;

	}


}
