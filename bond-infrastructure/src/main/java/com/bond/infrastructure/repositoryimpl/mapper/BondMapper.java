package com.bond.infrastructure.repositoryimpl.mapper;

import com.bond.infrastructure.repositoryimpl.dataobject.BondDO;
import org.springframework.stereotype.Repository;

/**
 * @author anzj
 * @date 2022/12/19 15:00
 */
@Repository
public interface BondMapper {

    BondDO find(String bondCode);
}
