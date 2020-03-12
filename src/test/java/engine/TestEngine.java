package engine;

import org.junit.Assert;
import org.junit.Test;

public class TestEngine {

    @Test
    public void babyClassic() {
        String result = Engine.calculateSkiLength(120, Engine.BABY, Engine.CLASSIC, Engine.IS_COMPETING);
        String expected = "120";
        Assert.assertEquals(expected, result);

        result = Engine.calculateSkiLength(208, Engine.BABY, Engine.CLASSIC, Engine.IS_COMPETING);
        expected = Engine.CASE207;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void babyFreestyle() {
        String result = Engine.calculateSkiLength(100, Engine.BABY, Engine.FREESTYLE, Engine.IS_COMPETING);
        String expected = "100";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void childClassic() {
        String result = Engine.calculateSkiLength(140, Engine.CHILD, Engine.CLASSIC, Engine.IS_COMPETING);
        String expected = "150 to 160";
        Assert.assertEquals(expected, result);

        result = Engine.calculateSkiLength(198, Engine.CHILD, Engine.CLASSIC, Engine.IS_COMPETING);
        expected = Engine.CASE207;
        Assert.assertEquals(expected, result);

        //for body length from 188  up to 197
        result = Engine.calculateSkiLength(188, Engine.CHILD, Engine.CLASSIC, Engine.IS_COMPETING);
        expected = "198 to 207. " + Engine.CASE207;
        Assert.assertEquals(expected, result);

        result = Engine.calculateSkiLength(197, Engine.CHILD, Engine.CLASSIC, Engine.IS_COMPETING);
        expected = "207. " + Engine.CASE207;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void childFreestyle() {
        String result = Engine.calculateSkiLength(130, Engine.CHILD, Engine.FREESTYLE, Engine.IS_COMPETING);
        String expected = "140 to 150";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void grownupClassic() {
        String result = Engine.calculateSkiLength(180, Engine.GROWNUP, Engine.CLASSIC, Engine.IS_COMPETING);
        String expected = "200";
        Assert.assertEquals(expected, result);

        result = Engine.calculateSkiLength(188, Engine.GROWNUP, Engine.CLASSIC, Engine.IS_COMPETING);
        expected = Engine.CASE207;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void grownupFreestyle() {
        String result = Engine.calculateSkiLength(170, Engine.GROWNUP, Engine.FREESTYLE, Engine.IS_COMPETING);
        String expected = "180 to 185";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void noAge(){
        String result = Engine.calculateSkiLength(170, "age-type", Engine.FREESTYLE, Engine.IS_COMPETING);
        String expected = "180 to 185";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void noLength(){
        String result = Engine.calculateSkiLength(0, Engine.GROWNUP, Engine.FREESTYLE, Engine.IS_COMPETING);
        String expected = Engine.DATAMISSING;
        Assert.assertEquals(expected, result);

        result = Engine.calculateSkiLength(0, Engine.CHILD, Engine.CLASSIC, Engine.IS_COMPETING);
        expected = Engine.DATAMISSING;
        Assert.assertEquals(expected, result);

        result = Engine.calculateSkiLength(0, Engine.BABY, Engine.FREESTYLE, Engine.IS_COMPETING);
        expected = Engine.DATAMISSING;
        Assert.assertEquals(expected, result);
    }

}
