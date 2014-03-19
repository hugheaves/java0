package org.java0.amount;


import org.java0.amount.angularvelocity.AngularVelocity;
import org.java0.unit.angularvelocity.DegreesPerMillisecond;
import org.java0.unit.angularvelocity.DegreesPerSecond;
import org.java0.unit.angularvelocity.RadiansPerSecond;
import org.junit.Assert;
import org.junit.Test;

public class AngularVelocityTest {
	public static final double SMALL_AMOUNT = 0.00000000001;

	@Test
	public void test1() {
		AngularVelocity a = new AngularVelocity(45, DegreesPerSecond.INSTANCE);
		double b = a.getValue(DegreesPerSecond.INSTANCE).doubleValue();
		Assert.assertEquals(45.0, b, SMALL_AMOUNT);
	}

	@Test
	public void test2() {
		AngularVelocity a = new AngularVelocity(45, DegreesPerSecond.INSTANCE);
		double b = a.getValue(RadiansPerSecond.INSTANCE).doubleValue();
		Assert.assertEquals(Math.PI / 4, b, SMALL_AMOUNT);
	}

	@Test
	public void test3() {
		AngularVelocity a = new AngularVelocity(45, DegreesPerMillisecond.INSTANCE);
		double b = a.getValue(RadiansPerSecond.INSTANCE).doubleValue();
		Assert.assertEquals(Math.PI / 4000, b, SMALL_AMOUNT);
	}

	@Test
	public void test4() {
		AngularVelocity a = new AngularVelocity(Math.PI / 1000, RadiansPerSecond.INSTANCE);
		double b = a.getValue(DegreesPerMillisecond.INSTANCE).doubleValue();
		Assert.assertEquals(180, b, SMALL_AMOUNT);
	}
}
