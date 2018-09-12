package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Arkhipov Ilya (mailto:ilya.arkhipov.89@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class CalculateTest {
	/**
	 * Test echo.
	 */

	@Test
	public void whenTakeNameThenTreePlusName() {
		String input = "Arkhipov Ilya";
		String expect = "Echo, echo, echo : Arkhipov Ilya";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}

}