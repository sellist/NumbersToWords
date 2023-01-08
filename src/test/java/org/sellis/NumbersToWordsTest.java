package org.sellis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumbersToWordsTest {

    private NumbersToWords sut;

    @Before
    public void setup(){
        sut = new NumbersToWords();
    }

    @Test
    public void zero_returns_zero(){
        Assert.assertEquals("zero", sut.convertNumberToWords(0));
    }

    @Test
    public void ones_digit(){
        Assert.assertEquals("one", sut.convertNumberToWords(1));
        Assert.assertEquals("five", sut.convertNumberToWords(5));
        Assert.assertEquals("nine", sut.convertNumberToWords(9));
    }

    @Test
    public void between_ten_and_twenty(){
        Assert.assertEquals("ten", sut.convertNumberToWords(10));
        Assert.assertEquals("twelve", sut.convertNumberToWords(12));
        Assert.assertEquals("nineteen", sut.convertNumberToWords(19));
    }

    @Test
    public void less_than_one_hundred(){
        Assert.assertEquals("fifty seven", sut.convertNumberToWords(57));
        Assert.assertEquals("eighty two", sut.convertNumberToWords(82));
        Assert.assertEquals("seventy", sut.convertNumberToWords(70));
    }

    @Test
    public void negative_numbers(){
        Assert.assertEquals("negative one", sut.convertNumberToWords(-1));
        Assert.assertEquals("negative ninety nine", sut.convertNumberToWords(-99));
        Assert.assertEquals("negative one billion one", sut.convertNumberToWords(-1000000001));
    }

    @Test
    public void breakpoints_between_magnitudes(){
        Assert.assertEquals("one hundred one", sut.convertNumberToWords(101));
        Assert.assertEquals("one thousand one", sut.convertNumberToWords(1001));
        Assert.assertEquals("one million one", sut.convertNumberToWords(1000001));
        Assert.assertEquals("nine hundred ninety nine", sut.convertNumberToWords(999));
        Assert.assertEquals("nine hundred ninety nine thousand nine hundred ninety nine", sut.convertNumberToWords(999999));
    }

    @Test
    public void given_example_test_cases() {
        Assert.assertEquals("one", sut.convertNumberToWords(1));
        Assert.assertEquals("ninety", sut.convertNumberToWords(90));
        Assert.assertEquals("five thousand eight hundred eighty eight", sut.convertNumberToWords(5888));
        Assert.assertEquals("ten thousand one hundred eighty three", sut.convertNumberToWords(10183));
        Assert.assertEquals(
                "six hundred seventy four thousand three hundred nineteen",
                sut.convertNumberToWords(674319)
        );
        Assert.assertEquals("one million one", sut.convertNumberToWords(1000001));
    }
}
