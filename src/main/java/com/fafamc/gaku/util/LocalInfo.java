package com.fafamc.gaku.util;

import com.fafamc.gaku.domain.LocalUser;

public final class  LocalInfo {

    private LocalInfo() {}

    private static final ThreadLocal<LocalUser> conn = new ThreadLocal<>();

    public static LocalUser get() {
        return conn.get();
    }

    public static void set(LocalUser user) {
        conn.set(user);
    }

}
