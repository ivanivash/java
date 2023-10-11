package org.example.mappers;

import javax.annotation.processing.Generated;
import org.example.dto.productImage.ProductImageItemDTO;
import org.example.entities.ProductEntity;
import org.example.entities.ProductImageEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-09T22:07:21+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ProductImageMapperImpl implements ProductImageMapper {

    @Override
    public ProductImageItemDTO productImageToItemDTO(ProductImageEntity productImage) {
        if ( productImage == null ) {
            return null;
        }

        ProductImageItemDTO productImageItemDTO = new ProductImageItemDTO();

        productImageItemDTO.setProductId( productImageProductId( productImage ) );
        productImageItemDTO.setId( productImage.getId() );
        productImageItemDTO.setImage( productImage.getImage() );

        return productImageItemDTO;
    }

    private int productImageProductId(ProductImageEntity productImageEntity) {
        if ( productImageEntity == null ) {
            return 0;
        }
        ProductEntity product = productImageEntity.getProduct();
        if ( product == null ) {
            return 0;
        }
        int id = product.getId();
        return id;
    }
}
