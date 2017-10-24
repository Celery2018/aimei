package com.bizconf.utils;


import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * description
 * User: zhaozengjun
 * Date: 2016/4/8
 * Time: 16:07
 */
public class StringUtil extends StringUtils {

    /**
     * 正则匹配非负整数
     */
    private static final String REG_NUMBER = "^\\d+$";

    /**
     * 字符串转数字，null和空串转为0
     * @param str
     * @return
     */
    public static Integer null2Zero(String str){
        if (isBlank(str)){
            return new Integer(0);
        }
        return Integer.parseInt(str);
    }

    /**
     * 判断字符串是否是非负整数
     * @param str
     * @return
     */
    public static boolean isNumber(String str){
        return str != null && str.matches(REG_NUMBER);
    }

    public static String list2String(List<? extends Object> list){
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null && !list.isEmpty()) {
            for (Object o : list) {
                if (o != null) {
                    stringBuffer.append(o).append(",");
                }
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        }
        return stringBuffer.toString();
    }

    public static boolean isBlank(Object object){
        if (object == null){
            return true;
        }
        return isBlank(object.toString());
    }

    public static boolean isNotBlank(Object object){
        return !isBlank(object);
    }


    public static boolean isEmpty(CharSequence str){
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args){

    }


}
