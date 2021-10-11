package cn.moquan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TypeTranslation {

    public static Date stringToDate (String dateString, String pattern) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.parse(dateString);
    }
}
