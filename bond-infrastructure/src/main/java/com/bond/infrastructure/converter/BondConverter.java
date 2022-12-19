package com.bond.infrastructure.converter;

import com.bond.domain.model.trade.Bond;
import com.bond.infrastructure.repositoryimpl.dataobject.BondDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author anzj
 * @date 2022/12/19 15:02
 */
@Mapper
public interface BondConverter {

    BondConverter INSTANCE = Mappers.getMapper(BondConverter.class);

    Bond toDomainObject(BondDO bondDO);
}
