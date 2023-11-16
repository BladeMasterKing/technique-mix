package org.ding.qualification.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.ding.qualification.domain.QualificationsCate;
import org.ding.qualification.mapper.QualificationCateMapper;
import org.ding.qualification.service.QueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangjiansheng
 * @version 1.0.0
 */
@Service
public class QueryServiceImpl implements QueryService {
    @Resource
    private QualificationCateMapper dao;

    @DS("mysql")
    public List<QualificationsCate> getAll(){
        return dao.queryAll();
    }
}
