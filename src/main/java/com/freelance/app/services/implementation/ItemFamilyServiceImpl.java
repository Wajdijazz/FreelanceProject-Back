package com.freelance.app.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.freelance.app.converter.ItemFamilyConvertor;
import com.freelance.app.dto.ItemFamilyDto;
import com.freelance.app.entities.ItemFamily;
import com.freelance.app.exceptions.ApplicationException;
import com.freelance.app.repositories.ItemFamilyRepository;
import com.freelance.app.services.IItemFamilyService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ItemFamilyServiceImpl implements IItemFamilyService {

	private ItemFamilyRepository itemFamilyRepository;
	private ItemFamilyConvertor itemFamilyConvertor;

	@Override
	public ItemFamily createItemFamilyt(ItemFamilyDto itemFamilyDto) {
		return itemFamilyRepository.save(itemFamilyConvertor.dtoToEntity(itemFamilyDto));
	}

	@Override
	public List<ItemFamilyDto> getAllItemFamily(Long companyId) {
		return itemFamilyConvertor.entityListToDtoList(itemFamilyRepository.findAll());
	}

	@Override
	public ItemFamily getItemFamilyById(Long itemFamilyId) {
		return itemFamilyRepository.findById(itemFamilyId)
				.orElseThrow(() -> new ApplicationException("This ItemFamily with Id" + itemFamilyId + "not exist"));
	}

	@Override
	public void deleteItemFamily(Long itemFamilyId) {
		itemFamilyRepository.deleteById(itemFamilyId);
	}

	@Override
	public ItemFamily updateItemFamily(ItemFamilyDto itemFamilyDto) {
		ItemFamily itemFamilyToUpdate = getItemFamilyById(itemFamilyDto.getItemFamilyId());
		itemFamilyToUpdate.setDescription(itemFamilyDto.getDescription());
		return itemFamilyRepository.save(itemFamilyToUpdate);
	}

}
