package toy.project.miniproduct.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import toy.project.miniproduct.dao.BasketDao;
import toy.project.miniproduct.dto.BasketReqDTO;
import toy.project.miniproduct.dto.BasketResDTO;
import toy.project.miniproduct.model.BasketModel;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BasketService {

    private final BasketDao productDao;

    public int insertBasket(BasketReqDTO basketReqDTO) {
        BasketModel basketModel = new BasketModel();
        BeanUtils.copyProperties(basketReqDTO, basketModel);
        return productDao.insertBasket(basketModel);
    }

    public List<BasketResDTO> selectBaskets(BasketReqDTO basketReqDTO) {
        List<BasketResDTO> result = new ArrayList<>();
        BasketModel basketModel = new BasketModel();
        BeanUtils.copyProperties(basketReqDTO, basketModel);

        List<BasketModel> datas = productDao.selectBaskets(basketModel);
        for (BasketModel item : datas) {
            result.add(new BasketResDTO(item));
        }
        return result;
    }

    public BasketResDTO selectBasket(BasketReqDTO basketReqDTO) {
        BasketModel basketModel = new BasketModel();
        BeanUtils.copyProperties(basketReqDTO, basketModel);
        BasketModel data = productDao.selectBasket(basketModel);
        return new BasketResDTO(data);
    }
    public int updateBasket(BasketReqDTO basketReqDTO) {
        BasketModel basketModel = new BasketModel();
        BeanUtils.copyProperties(basketReqDTO, basketModel);
        return productDao.updateBasket(basketModel);
    }

    public int deleteBasket(BasketReqDTO basketReqDTO) {
        BasketModel basketModel = new BasketModel();
        BeanUtils.copyProperties(basketReqDTO, basketModel);
        return productDao.deleteBasket(basketModel);
    }
}
