package com.example.herokudemo.mapping.simple;


import com.example.herokudemo.models.Catalogue;
import com.example.herokudemo.pojo.CatalogueDto;

import java.util.HashSet;
import java.util.Set;

public class CatalogueMapping {
    public static CatalogueDto entityToDto(Catalogue object) {
        CatalogueDto catalogueDto = new CatalogueDto();

        // set parent
        catalogueDto.setParentId(object.getCatalogue().getId());

        // set children
        Set<Long> ids = new HashSet<>();
        for (Catalogue c : object.getCatalogueSet()) {
            ids.add(c.getId());
        }
        //catalogueDto.getChildrenIds().addAll(ids);
        catalogueDto.setChildrenIds(ids);

        return catalogueDto;
    }

    public static Catalogue dtoToEntity(CatalogueDto object) {
        Catalogue catalogue = new Catalogue();

        return null;
    }
}
