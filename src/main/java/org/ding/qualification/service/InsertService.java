package org.ding.qualification.service;

import org.ding.qualification.domain.QualificationsCate;

import java.util.List;

public interface InsertService {
    int batchInsert(List<QualificationsCate> param);
}
