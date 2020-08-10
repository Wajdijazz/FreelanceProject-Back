package com.freelance.app.services;

import java.util.List;

import com.freelance.app.dto.ItemFamilyDto;
import com.freelance.app.entities.ItemFamily;



public interface IItemFamilyService {
	
	ItemFamily createItemFamilyt(ItemFamilyDto itemFamilyDto);

	List<ItemFamilyDto> getAllItemFamily(Long companyId);
	
	ItemFamily getItemFamilyById(Long itemFamilyId);

	void deleteItemFamily(Long itemFamilyId);
	
	ItemFamily updateItemFamily(ItemFamilyDto itemFamilyDto);

}
