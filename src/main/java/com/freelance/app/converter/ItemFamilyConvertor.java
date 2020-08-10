package com.freelance.app.converter;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.freelance.app.dto.ItemFamilyDto;
import com.freelance.app.entities.ItemFamily;
import com.freelance.app.services.ICompanyClientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ItemFamilyConvertor implements GenericsConverter<ItemFamily, ItemFamilyDto> {

	private ICompanyClientService companyClientService;

	@Override
	public ItemFamilyDto entityToDto(ItemFamily itemFamily) {
		return ItemFamilyDto.builder().itemFamilyId(itemFamily.getItemFamilyId())
				.description(itemFamily.getDescription()).creationDate(itemFamily.getCreationDate())
				.companyId(itemFamily.getCompanyClient().getCompanyId()).isActive(true).build();
	}

	@Override
	public ItemFamily dtoToEntity(ItemFamilyDto itemFamilyDto) {
		return ItemFamily.builder().itemFamilyId(itemFamilyDto.getItemFamilyId())
				.description(itemFamilyDto.getDescription()).creationDate(LocalDate.now())
				.companyClient(companyClientService.getCompanyById(itemFamilyDto.getCompanyId())).isActive(true)
				.build();
	}

}
