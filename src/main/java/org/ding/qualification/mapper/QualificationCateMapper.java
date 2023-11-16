package org.ding.qualification.mapper;

import org.ding.qualification.domain.QualificationsCate;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface QualificationCateMapper {

    @Select("select * from t_qualifications_cate")
    @Results(value = {
            @Result(id = true,column = "id",property = "id",jdbcType = JdbcType.BIGINT),
            @Result(column = "qualification_cate_id",property = "qualificationCateId",jdbcType = JdbcType.BIGINT),
            @Result(column = "qualification_name",property = "qualificationName",jdbcType = JdbcType.VARCHAR),
            @Result(column = "parent_id",property = "parentId",jdbcType = JdbcType.BIGINT),
            @Result(column = "status",property = "status",jdbcType = JdbcType.INTEGER),
            @Result(column = "add_time",property = "addTime",jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time",property = "updateTime",jdbcType = JdbcType.TIMESTAMP)
    })
    List<QualificationsCate> queryAll();

    @Insert({
        "<script>",
        "insert into t_qualifications_cate(id,qualification_cate_id, qualification_name, parent_id, node_type, status,add_time, update_time) values ",
        "<foreach collection='param' item='a' index='index' separator=','>",
        "(#{a.id},#{a.qualificationCateId}, #{a.qualificationName}, #{a.parentId}, #{a.nodeType}, #{a.status}, #{a.addTime}, #{a.updateTime})",
        "</foreach>",
        "</script>"
    })
    int batchInsert(List<QualificationsCate> param);

    @Insert("insert into t_qualifications_cate(id,qualification_cate_id, qualification_name, parent_id, node_type, status,add_time, update_time) values " +
            "(#{id},#{qualificationCateId}, #{qualificationName}, #{parentId}, #{nodeType}, #{status}, #{addTime}, #{updateTime})")
    int insert(QualificationsCate q);
}
