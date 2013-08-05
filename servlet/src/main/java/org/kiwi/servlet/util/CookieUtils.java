package org.kiwi.servlet.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    public static boolean isCookieExist(HttpServletRequest req, String cookieName) {
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals(cookieName)) {
                return true;
            }
        }
        return false;
    }

    public static Object getCookieValue(HttpServletRequest req, String cookieName) {
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public static Cookie getCookie(HttpServletRequest req, String cookieName) {
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals(cookieName)) {
                return cookie;
            }
        }
        return null;
    }

    public static void clearCookie(HttpServletRequest req, HttpServletResponse resp, String cookieName) {
        Cookie cookie = getCookie(req, cookieName);
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
    }

    public static void createCookie(HttpServletResponse resp, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        resp.addCookie(cookie);
    }
}
