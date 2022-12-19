package com.bond.infrastructure.repositoryimpl;

import com.bond.domain.model.trade.Holding;
import com.bond.domain.model.trade.repository.HoldingRepository;

/**
 * @author anzj
 * @date 2022/12/19 16:23
 */
public class HoldingRepositoryImpl implements HoldingRepository {
    @Override
    public Holding find(String investorName, String bondCode) {
        return null;
    }

    @Override
    public void save(Holding holding) {

    }
}
