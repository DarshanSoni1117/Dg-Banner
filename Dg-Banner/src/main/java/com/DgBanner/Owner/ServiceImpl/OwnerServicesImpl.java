package com.DgBanner.Owner.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.DgBanner.Owner.DTO.OwnerResponseDto;
import com.DgBanner.Owner.Entities.Owner;
import com.DgBanner.Owner.Repo.OwnerRepo;
import com.DgBanner.Owner.Service.OwnerServices;
import com.DgBanner.Utils.Converters.DtoToEntity;
import com.DgBanner.Utils.Converters.EntityToDto;

// method implmentation related to owner operation

@Service
public class OwnerServicesImpl implements OwnerServices {

	@Autowired
	OwnerRepo ownerRepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	DtoToEntity dtoToEntity;

	@Autowired
	EntityToDto entityToDto;


	@Override
	public OwnerResponseDto addingOwnerDetails(OwnerResponseDto ownerResponseDto) {

		Owner owner=dtoToEntity.ownerResponseDtoToOwner(ownerResponseDto);
		Owner savedOwner= ownerRepo.save(owner);
	   return entityToDto.ownerToOwnerResponseDto(savedOwner);

		}

	@Override
	public OwnerResponseDto updatingOwnerDetailsById(OwnerResponseDto ownerResponseDto, Integer id){

		Owner owner = ownerRepo.findById(id).orElseThrow(()-> new EmptyResultDataAccessException("Owner Does Not Exists",1));
			owner.setName(ownerResponseDto.getName());
			owner.setContactNumber(ownerResponseDto.getContactNumber());
			owner.setMailId(ownerResponseDto.getMailId());
		return entityToDto.ownerToOwnerResponseDto(ownerRepo.save(owner));

		//	return modelMapper.map(owner,OwnerResponseDto.class);

	}

	@Override
	public String deletingOwnerDetailsById(Integer id) {
		Owner owner = ownerRepo.findById(id).orElseThrow(()-> new EmptyResultDataAccessException("Owner Does Not Exists",1));
		if(owner.isActive()) {
			owner.setActive(false);
			ownerRepo.save(owner);
			return "User Deleted succesfully";
		}else
		{
			throw new EmptyResultDataAccessException("Owner Does Not Exists",1);
		}


	}

	@Override
	public OwnerResponseDto gettingOwnerDetailsById(Integer id) {

		Owner owner=ownerRepo.findById(id).orElseThrow(()-> new EmptyResultDataAccessException("Owner Does Not Exists",1));
		if(owner.isActive()) {
			return entityToDto.ownerToOwnerResponseDto(owner);
		}
		else {
			throw new  EmptyResultDataAccessException("Owner Does Not Exists",1);
		}
	}



}
