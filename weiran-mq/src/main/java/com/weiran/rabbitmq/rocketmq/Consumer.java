package com.weiran.rabbitmq.rocketmq;

import cn.hutool.json.JSONUtil;
import com.weiran.rabbitmq.common.SeckillMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 消费者类
 */
@Slf4j
@Component
@RequiredArgsConstructor
@RocketMQMessageListener(topic = "seckill-topic", consumerGroup = "seckill-consumer-group",
        selectorExpression = "tag1", selectorType = SelectorType.TAG,
        messageModel = MessageModel.CLUSTERING, consumeMode = ConsumeMode.CONCURRENTLY)
public class Consumer implements RocketMQListener<SeckillMessage> {


    @Override
    public void onMessage(SeckillMessage seckillMessage) {
        log.info("rocketmq 消费者接收消息: {}", JSONUtil.toJsonStr(seckillMessage));
        try {
            log.warn("写入订单表失败: {}", JSONUtil.toJsonStr(seckillMessage));
        } catch (Exception e) {
            Throwable cause = e.getCause();
            // 违反数据库唯一约束条件
            if (cause instanceof SQLIntegrityConstraintViolationException) {
                log.warn("{}订单写入异步操作问题");
            } else {
                e.printStackTrace();
            }
        }
    }
}

