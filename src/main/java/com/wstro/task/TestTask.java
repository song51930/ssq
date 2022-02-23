package com.wstro.task;

import com.wstro.entity.SsqBonusEntity;
import com.wstro.service.SsqBounsService;
import com.wstro.util.SsqJsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 测试定时任务(fixedRate在项目启动时会启动，cron不会启动)
 *
 * @author Joey
 * @Email 2434387555@qq.com
 */
@Component // 此注解必加
@EnableScheduling // 此注解必加
public class TestTask {

    private static final Logger logger = LoggerFactory.getLogger(TestTask.class);

    @Autowired
    private SsqBounsService ssqBounsService;

    //@Scheduled(fixedRate = 50000) // 每5秒执行一次
    public void task() {
        logger.info("测试定时任务!");
    }

    /**
     * 每周2，4，6晚上23点进行爬取
     * @throws Exception
     */
    @Scheduled(cron = "0 0 23 ? * 2,4,6")
    public void doSomething() throws Exception {
        logger.info("抓取双色球开奖信息线程开始。。。。");
        List<SsqBonusEntity> list= SsqJsoup.parse();
        if (list !=null ){
            for (SsqBonusEntity ssq:list){
                SsqBonusEntity sbe= ssqBounsService.selectById(ssq.getId());
                if (sbe == null){
                    ssq.setCreateTime(new Date());
                    ssqBounsService.insert(ssq);
                }

            }
        }
        logger.info("抓取双色球开奖信息线程结束");
    }


}
