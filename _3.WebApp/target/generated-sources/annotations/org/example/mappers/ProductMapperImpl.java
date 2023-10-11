package org.example.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.dto.product.ProductCreateDTO;
import org.example.dto.product.ProductItemDTO;
import org.example.dto.product.ProductUpdateDTO;
import org.example.dto.productImage.ProductImageItemDTO;
import org.example.entities.CategoryEntity;
import org.example.entities.ProductEntity;
import org.example.entities.ProductImageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-09T22:07:21+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private ProductImageMapper productImageMapper;

    @Override
    public ProductItemDTO productToItemDTO(ProductEntity product) {
        if ( product == null ) {
            return null;
        }

        ProductItemDTO productItemDTO = new ProductItemDTO();

        productItemDTO.setCategoryId( productCategoryId( product ) );
        productItemDTO.setImages( productImageEntityListToProductImageItemDTOList( product.getImages() ) );
        productItemDTO.setId( product.getId() );
        productItemDTO.setName( product.getName() );
        productItemDTO.setDescription( product.getDescription() );

        return productItemDTO;
    }

    @Override
    public List<ProductItemDTO> listProductsToItemDTO(List<ProductEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductItemDTO> list1 = new ArrayList<ProductItemDTO>( list.size() );
        for ( ProductEntity productEntity : list ) {
            list1.add( productToItemDTO( productEntity ) );
        }

        return list1;
    }

    @Override
    public ProductEntity productByCreateProductDTO(ProductCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        productEntity.category( ProductMapper.categoryIdToCategory( dto.getCategoryId() ) );
        productEntity.name( dto.getName() );
        productEntity.description( dto.getDescription() );
        productEntity.images( multipartFileListToProductImageEntityList( dto.getImages() ) );
        productEntity.categoryId( dto.getCategoryId() );

        return productEntity.build();
    }

    @Override
    public ProductEntity productByUpdateProductDTO(ProductUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        productEntity.category( ProductMapper.categoryIdToCategory( dto.getCategoryId() ) );
        productEntity.name( dto.getName() );
        productEntity.description( dto.getDescription() );
        productEntity.images( multipartFileListToProductImageEntityList( dto.getImages() ) );
        productEntity.categoryId( dto.getCategoryId() );

        return productEntity.build();
    }

    private int productCategoryId(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return 0;
        }
        CategoryEntity category = productEntity.getCategory();
        if ( category == null ) {
            return 0;
        }
        int id = category.getId();
        return id;
    }

    protected List<ProductImageItemDTO> productImageEntityListToProductImageItemDTOList(List<ProductImageEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductImageItemDTO> list1 = new ArrayList<ProductImageItemDTO>( list.size() );
        for ( ProductImageEntity productImageEntity : list ) {
            list1.add( productImageMapper.productImageToItemDTO( productImageEntity ) );
        }

        return list1;
    }

    protected ProductImageEntity multipartFileToProductImageEntity(MultipartFile multipartFile) {
        if ( multipartFile == null ) {
            return null;
        }

        ProductImageEntity.ProductImageEntityBuilder productImageEntity = ProductImageEntity.builder();

        return productImageEntity.build();
    }

    protected List<ProductImageEntity> multipartFileListToProductImageEntityList(List<MultipartFile> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductImageEntity> list1 = new ArrayList<ProductImageEntity>( list.size() );
        for ( MultipartFile multipartFile : list ) {
            list1.add( multipartFileToProductImageEntity( multipartFile ) );
        }

        return list1;
    }
}
