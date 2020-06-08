package com.ruoyi.common.utils;

import org.apache.commons.lang.ObjectUtils;

import java.math.BigDecimal;
import java.util.Map;

public class BigDecimalUtils {

    public static int ROUNDING_MODE = BigDecimal.ROUND_HALF_DOWN;


    /**
     * 加法
     *
     * @param x1
     * @param x2
     * @return
     */
    public static BigDecimal add(BigDecimal x1, BigDecimal x2) {
        return x1.add(x2).setScale(2, ROUNDING_MODE);
    }

    /**
     * 加法
     *
     * @param x1
     * @param x2
     * @return
     */
    public static BigDecimal add(BigDecimal x1, BigDecimal x2, int newScale) {
        return x1.add(x2).setScale(newScale, ROUNDING_MODE);
    }

    /**
     * 减法
     *
     * @param x1
     * @param x2
     * @return x1 - x2
     */
    public static BigDecimal subtract(BigDecimal x1, BigDecimal x2) {
        return x1.subtract(x2).setScale(2, ROUNDING_MODE);
    }

    /**
     * 减法
     *
     * @param x1
     * @param x2
     * @return x1 - x2
     */
    public static BigDecimal subtract(BigDecimal x1, BigDecimal x2, int newScale) {
        return x1.subtract(x2).setScale(newScale, ROUNDING_MODE);
    }

    /**
     * 乘法
     *
     * @param x1
     * @param x2
     * @return x1 * x2
     */
    public static BigDecimal multiply(BigDecimal x1, BigDecimal x2) {
        return multiply(x1, x2, 2);
    }

    /**
     * 乘法
     *
     * @param x1
     * @param x2
     * @param newScale
     * @return x1 * x2
     */
    public static BigDecimal multiply(BigDecimal x1, BigDecimal x2, int newScale) {
        return x1.multiply(x2).setScale(newScale, ROUNDING_MODE);
    }

    /**
     * 除法
     *
     * @param x1
     * @param x2
     * @return x1 / x2
     */
    public static BigDecimal div(BigDecimal x1, BigDecimal x2) {
        return x1.divide(x2, 2, ROUNDING_MODE);
    }

    /**
     * 除法
     *
     * @param x1
     * @param x2
     * @param newScale
     * @return x1 / x2
     */
    public static BigDecimal div(BigDecimal x1, BigDecimal x2, int newScale) {
        return x1.divide(x2, newScale, ROUNDING_MODE);
    }

    /**
     * 比较大小
     *
     * @param x1
     * @param x2
     * @return x1=x2返回0, x1>x2返回1, x1<x2返回-1
     */
    public static int compareTo(BigDecimal x1, BigDecimal x2) {
        return x1.compareTo(x2);
    }

    /**
     * String转BigDecimal(保留所有小数位)
     *
     * @param x1
     * @return
     */
    public static BigDecimal bigDecimal(String x1) {
        return new BigDecimal(x1);
    }

    /**
     * String转BigDecimal
     *
     * @param x1
     * @return
     */
    public static BigDecimal bigDecimal(String x1, int newScale) {
        return new BigDecimal(x1).setScale(newScale, ROUNDING_MODE);
    }

    /**
     * BigDecimal小数位
     *
     * @param x1
     * @return
     */
    public static BigDecimal bigDecimal(BigDecimal x1, int newScale) {
        return x1.setScale(newScale, ROUNDING_MODE);
    }

    /**
     * 根据Map获取BigDecimal类型的值
     *
     * @param map
     * @param key
     * @return
     */
    public static BigDecimal mapToBigDecimal(Map map, String key, String defaultValue) {
        BigDecimal bg = new BigDecimal(defaultValue);
        if (null != map.get(key)) {
            String value = ObjectUtils.toString(map.get(key));
            if (!"".equals(value)) {
                bg = toBigDecimal(value, defaultValue);
            }
        }
        return bg;
    }

    /**
     * 带判断的转换
     *
     * @param value
     * @return
     */
    public static BigDecimal toBigDecimal(String value, String defaultValue) {
        BigDecimal bg = new BigDecimal(defaultValue);
        if (null != value) {
            bg = new BigDecimal(value);
        }
        return bg;
    }


    /**
     * 四舍五入
     *
     * @param x1
     * @param newScale
     * @return
     */
    public static BigDecimal bigDecimalRound(BigDecimal x1, int newScale) {
        return x1.setScale(newScale, BigDecimal.ROUND_HALF_UP);
    }

}
