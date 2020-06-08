package com.ruoyi.common.utils;

import com.ruoyi.common.constant.OrderConstants;
import com.ruoyi.common.exception.CustomException;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @Author zhuangchongyi
 * @Description 订单号生成工具类
 * @Date 2020/6/5 17:07
 */
public class OrderCodeUtils {

    private static Random random = new SecureRandom();
    // 订单流水号默认长度
    static final int DEFAULT_LENGTH = 4;
    // 订单随机数长度
    static final int RANDOM_LENGTH = 4;
    // 订单号最大长度
    static final int MAX_LENGTH = 30;

    static final String ORDER_PRIFIX = "DD";

    static final String ORDER_WX_PRIFIX = "100";

    /**
     * 处理流水号
     *
     * @param serialNum
     * @return
     */
    public static String getSequence(Integer serialNum) {
        if (serialNum == null) throw new CustomException("订单流水号获取失败");
        String str = serialNum.toString();
        int len = str.length();
        if (len >= DEFAULT_LENGTH) {
            return str;
        }
        int rest = DEFAULT_LENGTH - len;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rest; i++) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    /**
     * 获取订单号
     * @param prefix 订单号前缀 DD
     * @param type 类别 0/1
     * @param time 时间 202006051811
     * @param serialNum 1
     * @param length 5
     * @return
     */
    public static String generateOrderCode(String prefix,String type, String time, Integer serialNum,int length) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix)
                .append(type)
                .append(time)
                .append(getSequence(serialNum))
                .append(generateCode(length, OrderConstants.RANDOM_NUMBER_CODES));
        return sb.toString();
    }

    /**
     * 生成订单号
     * @param type
     * @param time
     * @param serialNum
     * @return
     */
    public static String getOrderCode(String type, String time, Integer serialNum) {
        return generateOrderCode(ORDER_PRIFIX,type,time,serialNum,0);
    }

    /**
     * 生成微信订单交易号
     * @param type
     * @param time
     * @param serialNum
     * @return
     */
    public static String getWxOrderCode(String type, String time, Integer serialNum) {
        return generateOrderCode(ORDER_WX_PRIFIX,type,time,serialNum,RANDOM_LENGTH);
    }

        /**
         * 使用指定源生成验证码
         *
         * @param size    长度
         * @param sources 验证码字符源
         * @return
         */
    public static String generateCode(int size, String sources) {
        if (size == 0)
            return "";
        if (sources == null || sources.length() == 0) {
            sources = OrderConstants.RANDOM_NUMBER_CODES;
        }
        int codesLen = sources.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder code = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            code.append(sources.charAt(rand.nextInt(codesLen - 1)));
        }
        return code.toString();
    }


}