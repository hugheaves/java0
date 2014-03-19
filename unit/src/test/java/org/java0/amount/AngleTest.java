package org.java0.amount;


import org.java0.amount.angle.Angle;
import org.java0.unit.angle.Degrees;
import org.java0.unit.angle.Radians;
import org.junit.Assert;
import org.junit.Test;

public class AngleTest {
	public static final double SMALL_AMOUNT = 0.00000000001;

	@Test
	public void test1() {
		Angle a = new Angle(360, Degrees.INSTANCE);
		double b = a.getValue(Degrees.INSTANCE).doubleValue();
		Assert.assertEquals(360.0, b, SMALL_AMOUNT);
	}

	@Test
	public void test2() {
		Angle a = new Angle(360, Degrees.INSTANCE);
		double b = a.getValue(Radians.INSTANCE).doubleValue();
		Assert.assertEquals(Math.PI * 2, b, SMALL_AMOUNT);
	}

	@Test
	public void test3() {
		Angle a = new Angle(Math.PI * 4, Radians.INSTANCE);
		double b = a.getValue(Degrees.INSTANCE).doubleValue();
		Assert.assertEquals(720.0, b, SMALL_AMOUNT);
	}
}
