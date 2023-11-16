package org.ding.qualification.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangjiansheng
 * @version 1.0.0
 */
@Data
@TableName("t_qualifications_cate")
public class QualificationsCate implements Serializable {
    private static final long serialVersionUID = 4480332127503855115L;

    private Long id;
    private Long qualificationCateId;
    private String qualificationName;
    private Long parentId;
    private Integer nodeType;
    private Integer status;
    private Date addTime;
    private Date updateTime;
}
