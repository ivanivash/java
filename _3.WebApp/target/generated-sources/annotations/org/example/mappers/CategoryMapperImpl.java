package org.example.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.dto.category.CategoryItemDTO;
import org.example.entities.CategoryEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-09T22:07:21+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryItemDTO categoryToItemDTO(CategoryEntity category) {
        if ( category == null ) {
            return null;
        }

        CategoryItemDTO categoryItemDTO = new CategoryItemDTO();

        categoryItemDTO.setId( category.getId() );
        categoryItemDTO.setName( category.getName() );
        categoryItemDTO.setImage( category.getImage() );
        categoryItemDTO.setDescription( category.getDescription() );

        return categoryItemDTO;
    }

    @Override
    public List<CategoryItemDTO> listCategoriesToItemDTO(List<CategoryEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryItemDTO> list1 = new ArrayList<CategoryItemDTO>( list.size() );
        for ( CategoryEntity categoryEntity : list ) {
            list1.add( categoryToItemDTO( categoryEntity ) );
        }

        return list1;
    }
}
