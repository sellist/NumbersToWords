package org.sellis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserInputHandlerTests {

    UserInputHandler sut;

    @Before
    public void setup() {
        sut = new UserInputHandler();
    }

    @Test
    public void happy_path_input(){
        Assert.assertEquals(Integer.valueOf(123456789), sut.convertInputToInteger("123456789"));
        Assert.assertEquals(Integer.valueOf(0), sut.convertInputToInteger("0"));
        Assert.assertEquals(Integer.valueOf(-123456789), sut.convertInputToInteger("-123456789"));
    }

    @Test
    public void null_input_returns_null() {
        Assert.assertNull(sut.convertInputToInteger(null));
    }
}
