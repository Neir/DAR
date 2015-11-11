package com.darparisianstroll.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Util {

    /**
     * Methode permettant de convertir une chaine de caractere en une cle md5
     * 
     * @param md5
     *            : chaine a convertir
     * @return chaine convertie
     */
    public static String MD5(String md5) {
	try {
	    java.security.MessageDigest md = java.security.MessageDigest
		    .getInstance("MD5");
	    byte[] array = md.digest(md5.getBytes());
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < array.length; ++i) {
		sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
			.substring(1, 3));
	    }
	    return sb.toString();
	} catch (java.security.NoSuchAlgorithmException e) {
	}
	return null;
    }

    /**
     * Methode utilitaire gerant la récupération de la valeur d'un cookie donne
     * depuis la requête HTTP.
     */
    public static String getCookieValue(HttpServletRequest request, String nom) {
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
	    for (Cookie cookie : cookies) {
		if (cookie != null && nom.equals(cookie.getName())) {
		    return cookie.getValue();
		}
	    }
	}
	return null;
    }

    public static void deleteCookie(HttpServletRequest request,
	    HttpServletResponse response, String nom) {
	Cookie[] cookies = request.getCookies();

	if (cookies != null) {
	    for (Cookie cookie : cookies) {
		if (cookie != null && nom.equals(cookie.getName())) {
		    cookie.setValue(null);
		    cookie.setMaxAge(0);
		    response.addCookie(cookie);
		}
	    }
	}
    }
}
