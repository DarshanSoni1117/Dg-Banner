package com.DgBanner.Controller;

import java.util.List;

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

import com.DgBanner.DTO.ScreenDto;
import com.DgBanner.DTO.ScreenSpecificDetailDto;
import com.DgBanner.Owner.DTO.OwnerScreenDto;
import com.DgBanner.Services.ScreenServices;


@RestController
public class ScreenController {

	@Autowired
	ScreenServices screenServices;

	@PostMapping("/screen-details/screen/{ownerId}")
	ResponseEntity<ScreenDto> addingScreenDetails(@PathVariable("ownerId")int ownerId,@RequestBody ScreenDto screenDto){
		return new ResponseEntity<>(screenServices.addingScreenDetails(ownerId, screenDto),HttpStatus.CREATED );
	}

	@PutMapping("/screen-details/screen/{ownerId}/{screenId}")
	ResponseEntity<ScreenDto> updatingScreen(@PathVariable("ownerId")Integer ownerId,@PathVariable("screenId")Integer screenId, @RequestBody  ScreenDto screenDto){
	return new ResponseEntity<>(screenServices.updatingScreenDetails(ownerId,screenId, screenDto),HttpStatus.OK);
	}

	@DeleteMapping("/screen-details/screen/{ownerId}/{screenId}")
	ResponseEntity<String> deletingScreenById(@PathVariable("ownerId")Integer ownerId ,@PathVariable("screenId")Integer screenId){
	return new ResponseEntity<>(screenServices.deletingScreenDetails(ownerId,screenId),HttpStatus.OK);
	}

	@GetMapping("/screen-details/screen/{ownerId}/{screenId}")
	ResponseEntity<ScreenSpecificDetailDto> gettingdetails(@PathVariable("ownerId")int ownerId,@PathVariable("screenId") int screenId ) {
	return new ResponseEntity<>(screenServices.gettingSpecificScreendetailsById(ownerId, screenId),HttpStatus.FOUND);
	}

	@GetMapping("/screen-details/screens/{ownerId}")
	ResponseEntity<List<OwnerScreenDto>>gettingAllScreenByOwnerId(@PathVariable("ownerId")int ownerId){
		return new ResponseEntity<>(screenServices.gettingAllScreenByOwnerId(ownerId),HttpStatus.FOUND);

	}


}
