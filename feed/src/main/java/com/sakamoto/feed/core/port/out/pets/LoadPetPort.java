package com.sakamoto.feed.core.port.out.pets;

import comm.sakamoto.common.model.PetEntity;

public interface LoadPetPort {
    PetEntity loadPet(Long id);
}
