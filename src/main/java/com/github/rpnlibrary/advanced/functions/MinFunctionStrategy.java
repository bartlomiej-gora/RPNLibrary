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

package com.github.rpnlibrary.advanced.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Min Function - returns lesser number from two
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class MinFunctionStrategy extends AbstractFunctionStrategy {

    public MinFunctionStrategy() {
        super("min", 2, RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal execute(String... params) {
        BigDecimal param1 = new BigDecimal(params[0]);
        BigDecimal param2 = new BigDecimal(params[1]);
        return param1.min(param2);
    }
}
