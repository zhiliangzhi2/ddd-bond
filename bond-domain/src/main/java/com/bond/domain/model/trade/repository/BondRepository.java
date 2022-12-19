package com.bond.domain.model.trade.repository;

import com.bond.domain.model.trade.Bond;

/**
 * @author anzj
 * @date 2022/12/19 11:09
 */
public interface BondRepository {

    Bond find(String bondCode);

}
