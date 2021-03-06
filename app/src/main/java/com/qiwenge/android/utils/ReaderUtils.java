package com.qiwenge.android.utils;

import android.content.Context;

import com.liuguangqiang.framework.utils.PreferencesUtils;
import com.qiwenge.android.constant.Constants;

/**
 * ReaderUtils
 * <p/>
 * Created by Eric on 2014-4-24
 */
public class ReaderUtils {

    private static final String TEXT_SIZE_KEY = "TEXT_SIZE_KEY";

    /**
     * 保存字体大小
     *
     * @param context
     * @param textSize
     */
    public static void saveTextSize(Context context, int textSize) {
        PreferencesUtils.putInt(context, Constants.PRE_SAVE_NAME, TEXT_SIZE_KEY, textSize);
    }

    /**
     * 获取字体大小
     *
     * @param context
     */
    public static int getTextSize(Context context) {
        return PreferencesUtils.getInt(context, Constants.PRE_SAVE_NAME, TEXT_SIZE_KEY, Constants.DEFAULT_TEXT_SIZE);
    }

    /**
     * Return a String that only has two spaces.
     *
     * @return
     */
    public static String getTwoSpaces() {
        return "\u3000\u3000";
    }

    /**
     * 格式化小说内容。
     * <p/>
     * <li>小说的开头，缩进2格。在开始位置，加入2格空格。
     * <li>所有的段落，缩进2格。所有的\n,替换为2格空格。
     *
     * @param str
     * @return
     */
    public static String formatContent(String str) {
        str = str.replaceAll("[ ]*", "");//替换来自服务器上的，特殊空格
        str = str.replaceAll("[ ]*", "");//
        str = str.replace("\n\n", "\n");
        str = str.replace("\n", "\n" + getTwoSpaces());
        str = getTwoSpaces() + str;
//        str = convertToSBC(str);
        return str;
    }

    public static String formatDesc(String str) {
        str = str.trim();
        str = str.replace(" ", "");
        str = str.replace("　", "");
        str = str.replace("\n\n", "\n");
        str = str.replace("\n", "\n" + getTwoSpaces());
        str = getTwoSpaces() + str;
        return str;
    }

    public static String formatItemDesc(String str) {
        str = str.replace(" ", "").replace("　", "");
        return str;
    }

    public static String convertToSBC(String input) {
        input = input.replaceAll("\\“", "\" ");
        input = input.replaceAll("\\”", "\" ");
        return input;
//        char[] c = input.toCharArray();
//        for (int i = 0; i < c.length; i++) {
//            if (c[i] == 12288) {
//                c[i] = (char) 32;
//                continue;
//            }
//            if (c[i] > 65280 && c[i] < 65375)
//                c[i] = (char) (c[i] - 65248);
//        }
//        return new String(c);
    }

}
