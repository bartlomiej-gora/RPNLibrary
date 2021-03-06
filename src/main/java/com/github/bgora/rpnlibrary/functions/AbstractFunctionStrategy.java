/*
 * RPNLibrary - Reverse Polish Notation Library
 * Copyright (C) 2011  Bartłomiej Góra
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * Contact: bartlomiej.gora@gmail.com
 */

package com.github.bgora.rpnlibrary.functions;


import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Abstract class for arithmetic functions.
 * <p>
 * This class contains function name, param count.
 * It also provides execute method which is responsible for call the underlying math function.
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public abstract class AbstractFunctionStrategy {

    private final String name;
    private final int paramCount;
    private volatile int hashCode = 0;


    /**
     * Default Constructor.
     * Subclass need to provide required fields.
     *
     * @param name       Name of the function
     * @param paramCount parameters count
     */
    public AbstractFunctionStrategy(String name, int paramCount) {
        this.name = name;
        this.paramCount = paramCount;
    }


    /**
     * Returns Name value
     *
     * @return name value
     */
    public String getName() {
        return name;
    }


    /**
     * Return paramCount value
     *
     * @return paramCount value
     */
    public int getParamCount() {
        return paramCount;
    }


    /**
     * Executes underlying arithmetic function written in java.
     *
     * @param mathContext MathContext - Set Rounding Mode, and precision
     * @param params      Input param - A Table of Number, passed as string from Calculator.
     * @return BigDecimal object with resulting value.
     */
    public abstract BigDecimal execute(final MathContext mathContext, String... params);

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractFunctionStrategy) {
            AbstractFunctionStrategy rpn = (AbstractFunctionStrategy) obj;
            return (name != null ? name.equals(rpn.name) : false) && paramCount == rpn.paramCount;
        }
        return false;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        if (hashCode == 0) {
            int result = 17;
            result = 31 * result + name.hashCode();
            result = 31 * result + paramCount;
            hashCode = result;
        }
        return hashCode;
    }
}
