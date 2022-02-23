package com.wstro.service;

import com.baomidou.mybatisplus.service.IService;
import com.wstro.entity.SsqBonusEntity;

/**
 * 双色球server层
 */
public interface SsqBounsService extends IService<SsqBonusEntity> {

    void save(SsqBonusEntity entity);
}
