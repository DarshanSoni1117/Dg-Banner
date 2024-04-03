package com.DgBanner.Owner.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DgBanner.Owner.DTO.OwnerResponseDto;
import com.DgBanner.Owner.Service.OwnerServices;

import jakarta.validation.Valid;

@RestController
public class OwnerController {

	@Autowired
	OwnerServices ownerServices;

	@PostMapping("/owner-details/owner")
	ResponseEntity<OwnerResponseDto> createOwner(@RequestBody @Valid OwnerResponseDto ownerResponseDto)  {
	   return new ResponseEntity<>(ownerServices.addingOwnerDetails(ownerResponseDto), HttpStatus.CREATED);
	}

	@GetMapping("/owner-details/owners/{id}")
	ResponseEntity<OwnerResponseDto> getOwner(@PathVariable("id")Integer id) {
	return new ResponseEntity<>(ownerServices.gettingOwnerDetailsById(id), HttpStatus.FOUND);
	}

	@PutMapping("/owner-details/owner/{id}")
	ResponseEntity<OwnerResponseDto> updateOwner(@PathVariable("id")Integer id,@RequestBody @Valid OwnerResponseDto owner) {
	return new ResponseEntity<>(ownerServices.updatingOwnerDetailsById(owner, id), HttpStatus.OK);
	}

	@DeleteMapping("/owner-details/owners/{id}")
	ResponseEntity<String> deleteOwner(@PathVariable("id") Integer id) {
	return new ResponseEntity<>(ownerServices.deletingOwnerDetailsById(id),HttpStatus.OK);
	}


}
