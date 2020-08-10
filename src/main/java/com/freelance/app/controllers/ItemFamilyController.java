package com.freelance.app.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.app.dto.ItemFamilyDto;
import com.freelance.app.security.ResponseMessage;
import com.freelance.app.services.IItemFamilyService;
import com.freelance.app.util.Routes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(Routes.ITEMFAMILY)
@CrossOrigin(value = "*")
public class ItemFamilyController {

	private IItemFamilyService itemFamilyService;
	
	@PostMapping("/")
	public ResponseEntity<?> createItemFamily(@RequestBody ItemFamilyDto itemFamilyDto) {
		itemFamilyService.createItemFamilyt(itemFamilyDto);
		return new ResponseEntity<>(new ResponseMessage("Item-Family created successfully!"), HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<?> updateItemFamily(@RequestBody ItemFamilyDto itemFamilyDto) {
		itemFamilyService.updateItemFamily(itemFamilyDto);
		return new ResponseEntity<>(new ResponseMessage("Item-Family update successfully!"), HttpStatus.OK);
	}

	@GetMapping("/{companyId}")
	public List<ItemFamilyDto> getAllItemFamily(@PathVariable(value = "companyId") Long companyId) {
		return itemFamilyService.getAllItemFamily(companyId);
	}

	@DeleteMapping("/{itemFamilyId}")
	public ResponseEntity<?> deleteItemFamily(@PathVariable(value = "itemFamilyId") Long itemFamilyId) {
		itemFamilyService.deleteItemFamily(itemFamilyId);
		return new ResponseEntity<>(new ResponseMessage("Item-Family deleted successfully!"), HttpStatus.OK);
	}

}
