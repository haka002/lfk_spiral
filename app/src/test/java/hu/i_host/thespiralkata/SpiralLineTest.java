package hu.i_host.thespiralkata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpiralLineTest {
    SpiralLine mLine;

    @Before
    public void setup() {
        mLine = new SpiralLine();
    }

    @Test
    public void defaultConstruct() {
        assertEquals("The length is not good.", 0, mLine.getLength());
        assertEquals("The x point is not good.", 0, mLine.getStartX());
        assertEquals("The y point is not good.", 1, mLine.getStartY());
    }

    @Test
    public void setLength() {
        int length = 5;

        mLine.setLength(length);

        assertEquals("The set length is not working well.", length, mLine.getLength());
    }

    @Test
    public void down() {
        int[][] matrix = new int[5][5];
        fillUpMatrix(matrix);

        mLine.setLength(3);
        mLine.down(matrix);

        assertEquals("The down is not running well.", 0, matrix[1][0]);
        assertEquals("The down is not running well.", 0, matrix[2][0]);
        assertEquals("The down is not running well.", 0, matrix[3][0]);
    }

    @Test
    public void up() {
        int[][] matrix = new int[5][5];
        fillUpMatrix(matrix);

        mLine.setLength(2);
        mLine.up(matrix);

        assertEquals("The down is not running well.", 0, matrix[1][0]);
        assertEquals("The down is not running well.", 0, matrix[0][0]);
    }

    @Test
    public void right() {
        int[][] matrix = new int[5][5];
        fillUpMatrix(matrix);

        mLine.setLength(3);
        mLine.right(matrix);

        assertEquals("The down is not running well.", 0, matrix[1][0]);
        assertEquals("The down is not running well.", 0, matrix[1][1]);
        assertEquals("The down is not running well.", 0, matrix[1][2]);
    }

    @Test
    public void left() {
        int[][] matrix = new int[5][5];
        fillUpMatrix(matrix);

        mLine.setLength(1);
        mLine.left(matrix);

        assertEquals("The down is not running well.", 0, matrix[1][0]);
    }

    @Test
    public void round() {
        int[][] matrix = new int[5][5];
        fillUpMatrix(matrix);

        mLine.setLength(5);
        mLine.right(matrix);

        assertEquals("The down is not running well.", 0, matrix[1][0]);
        assertEquals("The down is not running well.", 0, matrix[1][1]);
        assertEquals("The down is not running well.", 0, matrix[1][2]);
        assertEquals("The down is not running well.", 0, matrix[1][3]);
        assertEquals("The down is not running well.", 0, matrix[1][4]);

        assertEquals("The x not the expected value.", 4, mLine.getStartX());
        assertEquals("The y not the expected value.", 1, mLine.getStartY());

        mLine.setLength(4);
        mLine.down(matrix);

        assertEquals("The down is not running well.", 0, matrix[1][4]);
        assertEquals("The down is not running well.", 0, matrix[2][4]);
        assertEquals("The down is not running well.", 0, matrix[3][4]);
        assertEquals("The down is not running well.", 0, matrix[4][4]);

        assertEquals("The x not the expected value.", 4, mLine.getStartX());
        assertEquals("The y not the expected value.", 4, mLine.getStartY());

        mLine.setLength(5);
        mLine.left(matrix);

        assertEquals("The down is not running well.", 0, matrix[4][4]);
        assertEquals("The down is not running well.", 0, matrix[4][3]);
        assertEquals("The down is not running well.", 0, matrix[4][2]);
        assertEquals("The down is not running well.", 0, matrix[4][1]);
        assertEquals("The down is not running well.", 0, matrix[4][0]);

        assertEquals("The x not the expected value.", 0, mLine.getStartX());
        assertEquals("The y not the expected value.", 4, mLine.getStartY());

        mLine.setLength(5);
        mLine.up(matrix);

        assertEquals("The down is not running well.", 0, matrix[4][0]);
        assertEquals("The down is not running well.", 0, matrix[3][0]);
        assertEquals("The down is not running well.", 0, matrix[2][0]);
        assertEquals("The down is not running well.", 0, matrix[1][0]);
        assertEquals("The down is not running well.", 0, matrix[0][0]);

        assertEquals("The x not the expected value.", 0, mLine.getStartX());
        assertEquals("The y not the expected value.", 0, mLine.getStartY());
    }

    private void fillUpMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 1;
            }
        }
    }
}