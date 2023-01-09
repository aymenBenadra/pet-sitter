package com.sakamoto.feed.core.port.out.users;

import comm.sakamoto.common.model.UserEntity;

public interface LoadUserPort {
    UserEntity loadUser(Long id);
}
