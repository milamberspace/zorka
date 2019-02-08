/*
 * Copyright 2012-2019 Rafal Lewczuk <rafal.lewczuk@jitlogic.com>
 * <p/>
 * This is free software. You can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * <p/>
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this software. If not, see <http://www.gnu.org/licenses/>.
 */
package com.jitlogic.zorka.core.normproc;

/**
 * Represents tokens generated by lexers and consumed by normalizers.
 *
 * @author rafal.lewczuk@jitlogic.com
 */
public class Token {

    /** Prefixes used by toString() method. */
    private final static String[] prefixes = { "u", "w", "s", "o", "l", "c", "k", "p" };


    /** Token type */
    private int type;


    /** Token text */
    private String text;


    /**
     * Creates new token intance.
     *
     * @param type token type
     * @param text token text
     */
    public Token(int type, String text) {
        this.type = type >= 0 ? type : 0;
        this.text = text != null ? text : "";
    }


    /**
     * Returns token type
     *
     * @return token type
     */
    public int getType() {
        return type;
    }

    /**
     * Sets token type.
     *
     * @param type token type
     */
    public void setType(int type) {
        this.type = type;
    }


    /**
     * Returns token text.
     *
     * @return token text
     */
    public String getText() {
        return text;
    }

    @Override
    public int hashCode() {
        return text.hashCode() + type;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Token &&
                ((Token)obj).type == type &&
                ((Token)obj).text.equals(text);
    }

    @Override
    public String toString() {
        return prefixes[type] + "(\"" + text + "\")";
    }
}
