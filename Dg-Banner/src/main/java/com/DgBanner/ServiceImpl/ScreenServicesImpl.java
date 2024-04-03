package com.DgBanner.ServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.DgBanner.DTO.ScreenDto;
import com.DgBanner.DTO.ScreenSpecificDetailDto;
import com.DgBanner.DTO.SlotAllDetailsDto;
import com.DgBanner.Entities.Screen;
import com.DgBanner.Entities.Slots;
import com.DgBanner.Owner.DTO.OwnerScreenDto;
import com.DgBanner.Owner.Entities.Owner;
import com.DgBanner.Owner.Repo.OwnerRepo;
import com.DgBanner.Repository.ScreenRepo;
import com.DgBanner.Services.ScreenServices;
import com.DgBanner.Utils.Converters.DtoToEntity;
import com.DgBanner.Utils.Converters.EntityToDto;

//---------------- Method related to Screen operation-----------------------


@Service
public class ScreenServicesImpl implements ScreenServices {


	@Autowired
	ScreenRepo screenRepo;

	@Autowired
	OwnerRepo ownerRepo;

	@Autowired
	DtoToEntity dtoToEntity;

	@Autowired
	EntityToDto entityToDto;


	@Override
	public ScreenDto addingScreenDetails(Integer ownerId, ScreenDto screenDto) {

		Owner owner = ownerRepo.findById(ownerId)
				.orElseThrow(() -> new EmptyResultDataAccessException("Owner Does not exists", 1));

		Screen screen = dtoToEntity.ScreenDtoToScreen(screenDto);
		  screen.setOwner(owner);
				     
//	     List<Slots> slots = new ArrayList<>();
//		    for (Slots slot : screen.getSlots()) {
//		        slot.setScreen(screen);
//		        slots.add(slot);
//		    }
//		    screen.setSlots(slots);


//		    ownerRepo.save(owner);
		  	screenRepo.save(screen);
		return entityToDto.screenToScreenDto(screen) ;
	}

	@Override
	public String deletingScreenDetails(Integer ownerId, Integer screenId) {

		Screen screen = screenRepo.findById(screenId)
				.orElseThrow(() -> new EmptyResultDataAccessException("Screen Does Not Exists", 0));
		Owner owner = ownerRepo.findById(ownerId)
				.orElseThrow(() -> new EmptyResultDataAccessException("Owner Does Not Exists", 0));
		screen.setActive(false);
	//	owner.getScreen().add(screen);
	//	ownerRepo.save(owner);
		
		
		screenRepo.save(screen);
		
		return "Screen Deleted successfully";
	}

	@Override
	public ScreenDto updatingScreenDetails(Integer ownerId, Integer screenId, ScreenDto screenDto) {
		Owner owner = ownerRepo.findById(ownerId)
				.orElseThrow(() -> new EmptyResultDataAccessException("Owner Does Not Exist", 0));
		Screen updatedScreen = dtoToEntity.ScreenDtoToScreen(screenDto);
		Screen screenPresent = owner.getScreen().stream().filter(screen -> screen.getId().equals(screenId)).findFirst()
				.orElseThrow(() -> new EmptyResultDataAccessException("Screen Does Not Exist", 0));

		screenPresent.setName(updatedScreen.getName());
		screenPresent.setLocation(updatedScreen.getLocation());
		screenPresent.setMediaPreview(updatedScreen.getMediaPreview());
		screenPresent.setResolution(screenDto.getResolution());
		screenPresent.setSize(updatedScreen.getSize());
		screenPresent.setSlots(updatedScreen.getSlots());

		screenPresent = screenRepo.save(screenPresent);

		return entityToDto.screenToScreenDto(screenPresent);
	}

	@Override
	public List<OwnerScreenDto> gettingAllScreenByOwnerId(Integer ownerId) {

		Owner owner = ownerRepo.findById(ownerId)
				.orElseThrow(() -> new EmptyResultDataAccessException(" Owner Does not Exists ", 0));

		List<Object[]> resultList = screenRepo.gettingAllScreenByOwnerId(ownerId);

		List<OwnerScreenDto> ownerScreenResult = new ArrayList();

		if (resultList.isEmpty()) {
			throw new EmptyResultDataAccessException("Screen does not exists", 0);
		} else {

			for (Object[] obj : resultList) {
				OwnerScreenDto dto = new OwnerScreenDto();
				dto.setScreenId((Integer) obj[0]);
				dto.setScreenName((String) obj[1]);
				dto.setSize((String) obj[2]);
				dto.setLocation((String) obj[3]);
				ownerScreenResult.add(dto);
			}
		}
		return ownerScreenResult;
	}

	@Override
	public List<SlotAllDetailsDto> gettingSlotsDetailsByScreenId(Integer screenId) {
		List<SlotAllDetailsDto> dtoList = new ArrayList();

		List<Object[]> objectList = screenRepo.gettingSlotsDetailsByScreenId(screenId);

		if (objectList.isEmpty()) {
			throw new EmptyResultDataAccessException("No slots for the particular screen", 1);
		} else {

			for (Object[] obj : objectList) {
				SlotAllDetailsDto dto = new SlotAllDetailsDto();

				dto.setSlotId((Integer) obj[0]);
				dto.setAdvertiserName(null);
				dto.setInterval((String) obj[2]);
				dto.setPrice((BigDecimal) obj[3]);
				dto.setAvailable((boolean) obj[4]);
				dtoList.add(dto);

			}

		}

		return dtoList;
	}

	@Override
	public ScreenSpecificDetailDto gettingSpecificScreendetailsById(Integer ownerId, Integer screenId) {

		Screen screen = screenRepo.findById(screenId)
				.orElseThrow(() -> new EmptyResultDataAccessException("Screen Does Not Exists", 0));
		Owner owner = ownerRepo.findById(ownerId)
				.orElseThrow(() -> new EmptyResultDataAccessException("Owner Does Not Exists", 0));

		Object[] object = screenRepo.gettingSpecificScreendetailsById(ownerId, screenId);
		
		System.out.println(object.toString());
		System.out.println("---------------------");
		System.out.println("");
		System.out.println("---------------------");
		
		ScreenSpecificDetailDto screenSpecificDetail = new ScreenSpecificDetailDto();
		screenSpecificDetail.setScreenName((String) object[0]);
		screenSpecificDetail.setResolution((String) object[1]);
		screenSpecificDetail.setSize((String) object[2]);
		screenSpecificDetail.setLocation((String) object[3]);
		screenSpecificDetail.setActiveStatus((boolean) object[4]);
	//	screenSpecificDetail.setMediaPreview((String) object[5]);

		screenSpecificDetail.setSlotDtoList(this.gettingSlotsDetailsByScreenId(screenId));

		System.out.println(object);
		System.out.println("---------------------");
		System.out.println(screenSpecificDetail);
		System.out.println("---------------------");
		return screenSpecificDetail;
	}

}
