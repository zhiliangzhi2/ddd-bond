package com.bond.domain.model.trade.repository;

import com.bond.domain.model.trade.Inventory;

/**
 * @author anzj
 * @date 2022/12/19 13:56
 */
public interface InventoryRepository {

    Inventory find(String bondCode);

    void update(Inventory inventory);
}
