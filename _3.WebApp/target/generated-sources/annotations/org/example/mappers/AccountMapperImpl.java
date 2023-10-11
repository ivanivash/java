package org.example.mappers;

import javax.annotation.processing.Generated;
import org.example.dto.account.RegisterDTO;
import org.example.entities.UserEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-09T22:07:21+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public UserEntity itemDtoToUser(RegisterDTO registerDTO) {
        if ( registerDTO == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.firstName( registerDTO.getFirstName() );
        userEntity.lastName( registerDTO.getLastName() );
        userEntity.email( registerDTO.getEmail() );
        userEntity.phone( registerDTO.getPhone() );

        return userEntity.build();
    }
}
