package com.bond.domain.model.trade.repository;

import com.bond.domain.model.trade.Holding;

/**
 * @author anzj
 * @date 2022/12/19 14:03
 */
public interface HoldingRepository {

    Holding find(String investorName,String bondCode);

    void save(Holding holding);
}
