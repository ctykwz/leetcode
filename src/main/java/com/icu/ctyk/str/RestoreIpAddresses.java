package com.icu.ctyk.str;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ctykwz on 2021-06-03 20:35
 */
public class RestoreIpAddresses {


    public static void main(String[] args) {
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("0000"));
    }


    public List<String> restoreIpAddresses(String s) {
        if (Objects.isNull(s) || s.length() < 4) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void dfs(List<String> res, List<Integer> container, String s, int start) {
        if (container.size() == 4) {
            if (s.length() == start) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < container.size(); i++) {
                    builder.append(container.get(i));
                    if (i != container.size() - 1) {
                        builder.append('.');
                    }
                }
                res.add(builder.toString());
            } else {
                return;
            }
        }

        if (start >= s.length() || container.size() > 4) {
            return;
        }

        int address = 0;
        for (int i = start; i < s.length(); i++) {
            address = address * 10 + s.charAt(i) - '0';
            if (i > start && s.charAt(start) == '0') {
                break;
            }
            if (address == 0 || address > 0 && address <= 255) {
                container.add(address);
                dfs(res, container, s, i + 1);
                container.remove(container.size() - 1);
            }
        }
    }
}
