package com.sakamoto.feed.utils;

import com.sakamoto.feed.core.port.in.rest.PostCommand;
import com.sakamoto.feed.core.port.in.rest.PostDTO;
import com.sakamoto.feed.core.port.out.pets.LoadPetPort;
import com.sakamoto.feed.core.port.out.users.LoadUserPort;
import com.sakamoto.feed.domain.Pet;
import com.sakamoto.feed.domain.Post;
import com.sakamoto.feed.domain.User;
import comm.sakamoto.common.model.PetEntity;
import comm.sakamoto.common.model.PostEntity;
import comm.sakamoto.common.model.UserEntity;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    private final ModelMapper modelMapper;
    private final LoadUserPort loadUserPort;
    private final LoadPetPort loadPetPort;

    public PostMapper(LoadUserPort loadUserPort, LoadPetPort loadPetPort) {
        this.modelMapper = new ModelMapper();
        this.loadUserPort = loadUserPort;
        this.loadPetPort = loadPetPort;
    }

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(Post.class, PostEntity.class)
                .addMappings(mapper -> {
                    mapper.map(Post::getId, PostEntity::setId);
                    mapper.map(Post::getTitle, PostEntity::setTitle);
                    mapper.map(Post::getDescription, PostEntity::setDescription);
                    mapper.map(Post::getPrice, PostEntity::setPrice);
                    mapper.map(Post::getStatus, PostEntity::setStatus);
                    mapper.map(source -> loadUserPort.loadUser(source.getUser().id()), PostEntity::setUser);
                    mapper.map(source -> loadPetPort.loadPet(source.getPet().id()), PostEntity::setPet);
                });

        modelMapper.createTypeMap(PostEntity.class, Post.class)
                .addMappings(mapper -> {
                    mapper.map(PostEntity::getId, Post::setId);
                    mapper.map(PostEntity::getTitle, Post::setTitle);
                    mapper.map(PostEntity::getDescription, Post::setDescription);
                    mapper.map(PostEntity::getPrice, Post::setPrice);
                    mapper.map(PostEntity::getStatus, Post::setStatus);
                    mapper.map(PostEntity::getUser, (destination, value) -> {
                        UserEntity user = (UserEntity) value;
                        destination.setUser(new User(user.getId(), user.getUsername()));
                    });
                    mapper.map(PostEntity::getPet, (destination, value) -> {
                        PetEntity pet = (PetEntity) value;
                        destination.setPet(new Pet(pet.getId(), pet.getName(), pet.getType()));
                    });
                });

        modelMapper.createTypeMap(PostCommand.class, Post.class)
                .addMappings(mapper -> {
                    mapper.map(PostCommand::title, Post::setTitle);
                    mapper.map(PostCommand::description, Post::setDescription);
                    mapper.map(PostCommand::price, Post::setPrice);
                    mapper.map(PostCommand::userId, (destination, value) -> {
                        Long userId = (Long) value;
                        destination.setUser(new User(userId, null));
                    });
                    mapper.map(PostCommand::petId, (destination, value) -> {
                        Long petId = (Long) value;
                        destination.setPet(new Pet(petId, null, null));
                    });
                });
    }

    public PostEntity toEntity(Post post) {
        return modelMapper.map(post, PostEntity.class);
    }

    public Post toDomain(PostEntity postEntity) {
        return modelMapper.map(postEntity, Post.class);
    }

    public Post toDomain(PostCommand command) {
        return modelMapper.map(command, Post.class);
    }

    public Post toDomain(PostCommand command, Post post) {
        modelMapper.map(command, post);
        return post;
    }

    public PostDTO toDTO(PostEntity postEntity) {
        return PostDTO.builder()
                .id(postEntity.getId())
                .title(postEntity.getTitle())
                .description(postEntity.getDescription())
                .price(postEntity.getPrice())
                .status(postEntity.getStatus())
                .user(new User(postEntity.getUser().getId(), postEntity.getUser().getUsername()))
                .pet(new Pet(postEntity.getPet().getId(), postEntity.getPet().getName(), postEntity.getPet().getType()))
                .build();
    }
}
