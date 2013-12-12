package net.bieli.bhash;

import java.util.HashSet;
import java.util.Set;

public class BHashTools
{
    public static <T> Set<T> newHashSet(T... objs)
    {
        Set<T> set = new HashSet<T>();
        for (T o : objs) {
            set.add(o);
        }
        return set;
    }

    public static String replace(String str, int index, char replace){
        if(str==null){
            return str;
        }else if(index<0 || index>=str.length()){
            return str;
        }
        char[] chars = str.toCharArray();
        chars[index] = replace;
        return String.valueOf(chars);
    }
}
