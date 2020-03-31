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

package com.github.bgora.rpnlibrary.advanced.operators;

import java.math.BigDecimal;
import java.math.MathContext;

public class PowerOperatorStrategy extends AbstractOperatorStrategy {


    public PowerOperatorStrategy() {
        super("^", 3);
    }

    @Override
    public BigDecimal execute(String first, String second, final MathContext mathContext) {
        Double big1 = new Double(first);
        Double big2 = new Double(second);
        return BigDecimal.valueOf(Math.pow(big1, big2));
    }


}
