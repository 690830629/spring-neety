package lang;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MyStr {

    public int get() {
        String str = "babaccdeff";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean flag = true;
            for (int j = 0; j < chars.length; j++) {
                if (chars[i] == chars[j] && j != i) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println(chars[i]);
                return chars[i];
            }
        }
        return 0;

    }

    public static char getMap() {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        String str = "babaccdeff";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                Integer integer = map.get(chars[i]);
                integer++;
                map.put(chars[i], integer);
            } else {
                map.put(chars[i], 1);

            }

        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return chars[i];
            }
        }
        return 0;

    }

    public static char getList() {
        String str = "babaoccdeff";
        char[] chars = str.toCharArray();
        int charLength = 256;
        char all[] = new char[charLength];
        for (int i = 0; i < charLength; i++) {
            all[i] = 0;
        }
        for (int i = 0; i < chars.length; i++) {
            all[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (all[chars[i]] == 1) {
                return chars[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }

}
