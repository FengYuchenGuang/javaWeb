package hxz.pro.tlias.service.impl;

import hxz.pro.tlias.pojo.PageBean;
import hxz.pro.tlias.service.EmpService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author hxz
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        return null;
    }

    @Override
    public void delete(List<Integer> ids) {

    }
}
