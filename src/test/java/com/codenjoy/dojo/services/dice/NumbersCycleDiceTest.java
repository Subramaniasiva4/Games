package com.codenjoy.dojo.services.dice;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2018 - 2021 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.codenjoy.dojo.services.Dice;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NumbersCycleDiceTest {

    @Test
    public void shouldReturnAllNumbers_thenStartAgainValue() {
        // given
        Dice dice = new NumbersCycleDice(Arrays.asList(1, 2, 3, 4, 5), -1);

        // when then
        assertEquals(1, dice.next(100));
        assertEquals(2, dice.next(100));
        assertEquals(3, dice.next(100));
        assertEquals(4, dice.next(100));
        assertEquals(5, dice.next(100));

        assertEquals(1, dice.next(100));
        assertEquals(2, dice.next(100));
        assertEquals(3, dice.next(100));
        assertEquals(4, dice.next(100));
        assertEquals(5, dice.next(100));

        assertEquals(1, dice.next(100));
        assertEquals(2, dice.next(100));
    }

    @Test
    public void shouldReturnDefaultValue_whenEmpty() {
        // given
        Dice dice = new NumbersCycleDice(Arrays.asList(), -100);

        // when then
        assertEquals(-100, dice.next(100));
        assertEquals(-100, dice.next(100));
        assertEquals(-100, dice.next(100));
        assertEquals(-100, dice.next(100));
    }
}