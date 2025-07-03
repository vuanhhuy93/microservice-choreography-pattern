package vn.gtel.qtudsso.redis.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import vn.gtel.qtudsso.models.userinfo.UserPrincipal;

@RedisHash("userinfo")
@Data
public class UserInfo {
    @Id
    private long id;

    private UserPrincipal principal;


}
