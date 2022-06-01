package toy.project.miniproduct.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import toy.project.miniproduct.dao.BasketProductOptionDao;
import toy.project.miniproduct.dto.BasketProductOptionReqDTO;
import toy.project.miniproduct.dto.BasketProductOptionResDTO;
import toy.project.miniproduct.model.BasketProductOptionModel;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BasketProductOptionService {

    private final BasketProductOptionDao basketBasketProductOptionDao;

    public int insertBasketProductOption(BasketProductOptionReqDTO basketBasketProductOptionReqDTO) {
        BasketProductOptionModel basketBasketProductOptionModel = new BasketProductOptionModel();
        BeanUtils.copyProperties(basketBasketProductOptionReqDTO, basketBasketProductOptionModel);
        return basketBasketProductOptionDao.insertBasketProductOption(basketBasketProductOptionModel);
    }

    public List<BasketProductOptionResDTO> selectBasketProductOptions(BasketProductOptionReqDTO basketBasketProductOptionReqDTO) {
        List<BasketProductOptionResDTO> result = new ArrayList<>();
        BasketProductOptionModel basketBasketProductOptionModel = new BasketProductOptionModel();
        BeanUtils.copyProperties(basketBasketProductOptionReqDTO, basketBasketProductOptionModel);

        List<BasketProductOptionModel> datas = basketBasketProductOptionDao.selectBasketProductOptions(basketBasketProductOptionModel);
        for (BasketProductOptionModel item : datas) {
            result.add(new BasketProductOptionResDTO(item));
        }
        return result;
    }

    public BasketProductOptionResDTO selectBasketProductOption(BasketProductOptionReqDTO basketBasketProductOptionReqDTO) {
        BasketProductOptionModel basketBasketProductOptionModel = new BasketProductOptionModel();
        BeanUtils.copyProperties(basketBasketProductOptionReqDTO, basketBasketProductOptionModel);
        BasketProductOptionModel data = basketBasketProductOptionDao.selectBasketProductOption(basketBasketProductOptionModel);
        return new BasketProductOptionResDTO(data);
    }
    public int updateBasketProductOption(BasketProductOptionReqDTO basketBasketProductOptionReqDTO) {
        BasketProductOptionModel basketBasketProductOptionModel = new BasketProductOptionModel();
        BeanUtils.copyProperties(basketBasketProductOptionReqDTO, basketBasketProductOptionModel);
        return basketBasketProductOptionDao.updateBasketProductOption(basketBasketProductOptionModel);
    }

    public int deleteBasketProductOption(BasketProductOptionReqDTO basketBasketProductOptionReqDTO) {
        BasketProductOptionModel basketBasketProductOptionModel = new BasketProductOptionModel();
        BeanUtils.copyProperties(basketBasketProductOptionReqDTO, basketBasketProductOptionModel);
        return basketBasketProductOptionDao.deleteBasketProductOption(basketBasketProductOptionModel);
    }
}
