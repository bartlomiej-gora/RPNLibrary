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

package com.github.bgora.rpnlibrary;

import com.github.bgora.rpnlibrary.exceptions.RPNException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setUp() {
        calc = Calculator.createCalculator();
    }

    @Test
    public void testCalculate() throws RPNException {
        BigDecimal result = calc.calculate("2^3*(12/6)+18/3+5.0/2");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("24.50"));
    }

    @Test
    public void testMultiply() throws RPNException {
        BigDecimal result = calc.calculate("2*8");
        assertEquals("2*8", BigDecimal.valueOf(16), result.setScale(0, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testMultiplyDouble() throws RPNException {
        BigDecimal result = calc.calculate("2*8.59");
        assertEquals("2*8.59", BigDecimal.valueOf(17.18), result);
    }

    @Test
    public void testMultiplyDouble3AfterDot() throws RPNException {
        BigDecimal result = calc.calculate("9*3.351");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("30.16"));
    }


    @Test
    public void testPower() throws RPNException {
        BigDecimal result = calc.calculate("2^8");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("256.00"));
    }


    @Test
    public void testPowerDouble() throws RPNException {
        BigDecimal result = calc.calculate("3.678^2");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("13.53"));
    }

    @Test
    public void testAdd() throws RPNException {
        BigDecimal result = calc.calculate("2+8");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("10.00"));
    }

    @Test
    public void testSub() throws RPNException {
        BigDecimal result = calc.calculate("2-5");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("-3.00"));
    }

    @Test
    public void testDiv() throws RPNException {
        BigDecimal result = calc.calculate("10.0/4");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("2.50"));
    }

    @Test
    public void testDivDouble() throws RPNException {
        BigDecimal result = calc.calculate("10.55/4");
        assertEquals("10.55/4", BigDecimal.valueOf(2.64), result.setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testDivDouble3AfterDot() throws RPNException {
        BigDecimal result = calc.calculate("10.505/4");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("2.63"));
    }

    @Test
    public void testSinus() throws RPNException {
        BigDecimal result = calc.calculate("sin(2)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("0.91"));
    }

    @Test
    public void testOneAddWhiteSpaceSinus() throws RPNException {
        BigDecimal result = calc.calculate("1 + sin(2)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("1.91"));
    }

    @Test
    public void testSinusPlus() throws RPNException {
        BigDecimal result = calc.calculate("sin(1+1)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("0.91"));
    }

    @Test
    public void testSinusMinus() throws RPNException {
        BigDecimal result = calc.calculate("sin(-1)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("-0.84"));
    }

    @Test
    public void testCosMinus() throws RPNException {
        BigDecimal result = calc.calculate("cos(-1)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("0.54"));
    }

    @Test
    public void testTgMinus() throws RPNException {
        BigDecimal result = calc.calculate("tg(-1)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("-1.56"));
    }

    @Test
    public void testCtgMinus() throws RPNException {
        BigDecimal result = calc.calculate("ctg(-1)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal(-0.6400000000, calc.getMathContext()).setScale(2));
    }

    @Test
    public void testCtgMinus5Zeros() throws RPNException {
        BigDecimal result = calc.calculate("ctg(-1.65091)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal(0.080, calc.getMathContext()).setScale(2));
    }

    @Test
    public void testAddTousands() throws RPNException {
        BigDecimal result = calc.calculate("12 000 + 15");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("12015.00"));
    }

    @Test(expected = RPNException.class)
    public void shouldThrowRPNException() throws RPNException {
        calc.calculate("aaaaa");
    }

    @Test
    public void shouldReturn2andHalf() throws RPNException {
        BigDecimal result = calc.calculate("5/2");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("2.50"));
    }

    @Test
    public void shouldReturn35() throws RPNException {
        BigDecimal result = calc.calculate("7/2");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("3.50"));
    }

}
