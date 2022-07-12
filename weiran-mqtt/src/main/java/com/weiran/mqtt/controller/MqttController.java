package com.weiran.mqtt.controller;

import com.weiran.rabbitmq.rabbitmq.ResultMsgObj;
import com.weiran.mqtt.gateway.MqttGateway;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MQTT测试接口
 */
@Api(tags = "MqttController", description = "MQTT测试接口")
@RestController
@RequestMapping("/mqtt")
public class MqttController {

    @Autowired
    private MqttGateway mqttGateway;

    @PostMapping("/sendToDefaultTopic")
    @ApiOperation("向默认主题发送消息")
    public ResultMsgObj sendToDefaultTopic(String payload) {
        mqttGateway.sendToMqtt(payload);
        ResultMsgObj resultMsgObj = new ResultMsgObj();
        resultMsgObj.setMsg("发送成功");
        return resultMsgObj;
    }

    @PostMapping("/sendToTopic")
    @ApiOperation("向指定主题发送消息")
    public ResultMsgObj sendToTopic(String payload, String topic) {
        mqttGateway.sendToMqtt(payload, topic);
        ResultMsgObj resultMsgObj = new ResultMsgObj();
        resultMsgObj.setMsg("发送成功");
        return resultMsgObj;
    }
}
