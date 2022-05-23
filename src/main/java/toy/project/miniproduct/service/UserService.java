package toy.project.miniproduct.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toy.project.miniproduct.dao.UserDao;
import toy.project.miniproduct.dto.UserGetResDTO;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserDao userDao;

    public List<UserGetResDTO> getUsers() {
//        return userDao.getUsers();
        // 1) Mapstruct - 라이브러리 잇음

        // 2) hand by hand - 그냥 다 get set...

        // 3) copy vo - 함수고
        return null;
    }
}
