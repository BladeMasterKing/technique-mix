package org.ding.qualification.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.ding.qualification.domain.QualificationsCate;
import org.ding.qualification.mapper.QualificationCateMapper;
import org.ding.qualification.service.InsertService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangjiansheng
 * @version 1.0.0
 */
@Service
@DS("sqlite")
public class InsertServiceImpl implements InsertService {
    @Resource
    private QualificationCateMapper dao;

    @Transactional
    @DS("sqlite")
    public int batchInsert(List<QualificationsCate> param){
//        int size = dao.batchInsert(param);
        int size = 0;
        for (;size<param.size(); size++){
            dao.insert(param.get(size));
        }
        System.out.println(size);
        return size;
    }
}
