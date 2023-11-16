package org.ding.pinyin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author wangjiansheng
 * @version 1.0.0
 */
public class Chinese2Pinyin {

    public static String convertToPinyin(String input) throws BadHanyuPinyinOutputFormatCombination {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        StringBuilder result = new StringBuilder();

        String hanyuPinyinString = PinyinHelper.toHanyuPinyinString(input, format, "_");


        return  PinyinHelper.toHanyuPinyinString(input, format, "_");
    }

    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        System.out.println(convertToPinyin("建筑施工总包"));
    }
}
