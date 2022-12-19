package com.bond.infrastructure.repositoryimpl;

import com.bond.domain.model.trade.Bond;
import com.bond.domain.model.trade.repository.BondRepository;
import com.bond.infrastructure.converter.BondConverter;
import com.bond.infrastructure.repositoryimpl.dataobject.BondDO;
import com.bond.infrastructure.repositoryimpl.mapper.BondMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author anzj
 * @date 2022/12/19 14:59
 */
public class BondRepositoryImpl implements BondRepository {

    @Autowired
    private BondMapper bondMapper;

    @Override
    public Bond find(String bondCode) {
        BondDO bondDO = bondMapper.find(bondCode);
        return BondConverter.INSTANCE.toDomainObject(bondDO);
    }

}
