package tools;

import java.text.DecimalFormat;

/**
 * StringUtil 的主要职责:
 *
 * @ClassName StringUtil
 * @Description: TODO
 * @Author songbai yang
 * @Date 2019/9/8 17:41
 * @Version V1.0
 **/
public class StringUtil {

    public static String format(String pattern,double number){
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(number);
    }
}
