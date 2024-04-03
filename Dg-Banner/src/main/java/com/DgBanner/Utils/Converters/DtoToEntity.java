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
public class DtoToEntity {

	public Owner ownerResponseDtoToOwner(OwnerResponseDto dto) {
		Owner owner= new Owner();
	    owner.setName(dto.getName());
	    owner.setMailId(dto.getMailId());
	    owner.setContactNumber(dto.getContactNumber());
	    return owner;
	}

	public Screen ScreenDtoToScreen(ScreenDto dto){

		Screen screen= new Screen();
		screen.setName(dto.getName());
		screen.setResolution(dto.getResolution());
		screen.setMediaPreview(dto.getPreview());
		screen.setSize(dto.getSize());
		screen.setLocation(dto.getLocation());

		List<Slots> slotList= new ArrayList();

		for(SlotsDto slot : dto.getSlots()) {

			slotList.add(this.SlotsDtoToSlots(slot));
		}
		screen.setSlots(slotList);


		return screen;

	}

	public Slots SlotsDtoToSlots(SlotsDto slotsDto) {

		Slots slots = new Slots();
		slots.setInterval(slotsDto.getInterval());
		slots.setPrice(slotsDto.getPrice());

		return slots;
	}

	public Advertiser AdvertiserDtoToAdvertiser(AdvertiserDto advertiserDto) {
		Advertiser advertiser= new Advertiser();
		advertiser.setName(advertiserDto.getName());
		advertiser.setContactNumber(advertiserDto.getContactNumber());
		advertiser.setMailId(advertiserDto.getMailId());

		return advertiser;
	}

	}


