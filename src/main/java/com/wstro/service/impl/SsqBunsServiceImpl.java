package com.wstro.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wstro.dao.SsqBounsDao;
import com.wstro.entity.SsqBonusEntity;
import com.wstro.service.SsqBounsService;
import org.springframework.stereotype.Service;

@Service
public class SsqBunsServiceImpl extends ServiceImpl<SsqBounsDao, SsqBonusEntity> implements SsqBounsService {


    @Override
    public void save(SsqBonusEntity entity) {
        insert(entity);
    }

}
