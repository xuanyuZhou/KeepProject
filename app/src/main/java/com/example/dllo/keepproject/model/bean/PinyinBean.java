package com.example.dllo.keepproject.model.bean;

/**
 * Created by dllo on 16/8/18.
 */
public final class PinyinBean {

    private PinyinBean() {
        //no instance
    }

    /**
     * return pinyin if c is chinese in uppercase, String.valueOf(c) otherwise.
     */
    public static String toPinyin(char c) {
        if (isChinese(c)) {
            if (c == PinyinDataBean.CHAR_12295) {
                return PinyinDataBean.PINYIN_12295;
            } else {
                return PinyinDataBean.PINYIN_TABLE[getPinyinCode(c)];
            }
        } else {
            return String.valueOf(c);
        }
    }

    /**
     * return whether c is chinese
     */
    public static boolean isChinese(char c) {
        return (PinyinDataBean.MIN_VALUE <= c && c <= PinyinDataBean.MAX_VALUE
                && getPinyinCode(c) > 0)
                || PinyinDataBean.CHAR_12295 == c;
    }

    private static int getPinyinCode(char c) {
        int offset = c - PinyinDataBean.MIN_VALUE;
        if (0 <= offset && offset < PinyinDataBean.PINYIN_CODE_1_OFFSET) {
            return decodeIndex(PinyinCodeOneBean.PINYIN_CODE_PADDING, PinyinCodeOneBean.PINYIN_CODE, offset);
        } else if (PinyinDataBean.PINYIN_CODE_1_OFFSET <= offset
                && offset < PinyinDataBean.PINYIN_CODE_2_OFFSET) {
            return decodeIndex(PinyinCodeTwoBean.PINYIN_CODE_PADDING, PinyinCodeTwoBean.PINYIN_CODE,
                    offset - PinyinDataBean.PINYIN_CODE_1_OFFSET);
        } else {
            return decodeIndex(PinyinCodeThreeBean.PINYIN_CODE_PADDING, PinyinCodeThreeBean.PINYIN_CODE,
                    offset - PinyinDataBean.PINYIN_CODE_2_OFFSET);
        }
    }

    private static short decodeIndex(byte[] paddings, byte[] indexes, int offset) {
        //CHECKSTYLE:OFF
        int index1 = offset / 8;
        int index2 = offset % 8;
        short realIndex;
        realIndex = (short) (indexes[offset] & 0xff);
        //CHECKSTYLE:ON
        if ((paddings[index1] & PinyinDataBean.BIT_MASKS[index2]) != 0) {
            realIndex = (short) (realIndex | PinyinDataBean.PADDING_MASK);
        }
        return realIndex;
    }
}

