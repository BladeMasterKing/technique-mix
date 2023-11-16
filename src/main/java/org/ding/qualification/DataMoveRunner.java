package org.ding.qualification;

import org.ding.qualification.domain.QualificationsCate;
import org.ding.qualification.service.InsertService;
import org.ding.qualification.service.QueryService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangjiansheng
 * @version 1.0.0
 */
@Component
public class DataMoveRunner implements ApplicationRunner {
    @Resource
    private QueryService queryService;
    @Resource
    private InsertService insertService;

    private List<QualificationsCate> result = new ArrayList<>();


    @Override
    public void run(ApplicationArguments args) {
        List<QualificationsCate> all = queryService.getAll();
        List<QualificationsCate> l1 = all.stream().filter(a -> a.getParentId().equals(0l)).collect(Collectors.toList());
        Long offset = 100000L;
        for(int a=1; a <= l1.size(); a++){
            QualificationsCate domain = l1.get(a - 1);
            Long oId = domain.getQualificationCateId();
            Long nId = a * offset;
            domain.setQualificationCateId(a * offset);
            domain.setParentId(0L);
            domain.setNodeType(1);
            // 递归查询
            result.add(domain);
            recursion(oId, nId, all, offset/10L);
        }
        System.out.println("查询结果"+result.size());
        insertService.batchInsert(result);
    }

    public void recursion(Long oId, Long nId, List<QualificationsCate> all, Long offset){
        List<QualificationsCate> collect = all.stream().filter(b -> b.getParentId().equals(oId)).collect(Collectors.toList());
        for(int i=1; i<=collect.size(); i++){
            QualificationsCate domain = collect.get(i - 1);
            // 新节点的id
            Long ooId = domain.getQualificationCateId();
            Long nnId = i * offset + nId;
            domain.setQualificationCateId(i * offset + nId);
            domain.setParentId(nId);
            // 下属是否包含节点
            List<QualificationsCate> collect1 = all.stream().filter(a -> a.getParentId().equals(ooId)).collect(Collectors.toList());
            if(collect1 != null && collect1.size()>0){
                domain.setNodeType(1);
            }else {
                domain.setNodeType(2);
            }
            result.add(domain);
            recursion(ooId, nnId, all, offset/10L);
        }
    }

}
