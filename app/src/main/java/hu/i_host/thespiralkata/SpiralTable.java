package hu.i_host.thespiralkata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by haka on 2017. 04. 26..
 */

public class SpiralTable {
    SpiralLine     mLine;
    List<String>   mDirectionList        = new ArrayList<>();
    Iterator       mDirectionListIterator;
    private String mDirection;

    public SpiralTable(SpiralLine line) {
        mLine = line;
        mDirectionList.add("right");
        mDirectionList.add("down");
        mDirectionList.add("left");
        mDirectionList.add("up");
    }

    public int[][] go(int dimension) {
        // kettesevel novekszunk, kiveve az elsot. Ezek a zsmaok azt mutatjak, elotte mennyi olyan sor van, amit nem erint, illetve mogotte menni van az adott lepesnek.
        // tehat (1 + 0 elso),
        // 1 + 1, 1 + 1
        // 3 + 1, 3 + 1
        // 3 + 3, 3 + 3
        // 5 + 3, 5 + 3  ha a dimensiobol kivonjuk az osszeget es az kisebb vagy egyenlo, mint a kovetkezo szam, akkor vege

        mDirectionListIterator = mDirectionList.iterator();

        // ciklusban
        int[][] matrix = new int[dimension][dimension];

        fillUpMatrix(dimension, matrix);

        int stripeBefore = 0;
        int stripeAfter  = 1;

        drawLine(dimension, stripeBefore, stripeAfter, matrix);
        stripeBefore = 1;

        // egyesevel lepgetetunk csak majd kettesevel adjuk hozza
        do {
            for (int k = 0; k < 2; k++) {
                drawLine(dimension, stripeBefore, stripeAfter, matrix);
            }

            // We would like to step like this: 0+1, 1+1, 3+1,3+3,5+3,5+5
            if (stripeBefore == stripeAfter) {
                stripeBefore += 2;
            } else {
                stripeAfter = stripeBefore;
            }
        }
        while (stripeAfter + stripeBefore + 1 < dimension);

        return matrix;
    }

    private void fillUpMatrix(int dimension, int[][] matrix) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = 1;
            }
        }
    }

    /**
     * Returns the next direction. It will loop the list.
     *
     * @return
     */
    private String getNextDirection() {
        if (!mDirectionListIterator.hasNext()) {
            mDirectionListIterator = mDirectionList.iterator();
        }

        return (String)mDirectionListIterator.next();
    }

    private void drawLine(int dimension, int stripeBefore, int stripeAfter, int[][] matrix) {
        mDirection = getNextDirection();
        mLine.setLength(dimension - (stripeBefore + stripeAfter));

        switch (mDirection) {
            case "left":
                // kivonjuk a mogotte levot a teljes dimensiobol és akkor megkapjuk honnan indul el balra pl
                // 3 + 1 eseten 10 es dimensional 9 ről indul vissza
                // It is always 1+1 or 3+3 or 5+5 so on
                mLine.left(matrix);
                break;

            case "right":
                // It is always 0+1 or 1+3 or 3+5 so on
                mLine.right(matrix);
                break;

            case "down":
                // It is always 1+1 or 3+3 or 5+5 so on
                mLine.down(matrix);
                break;
            case "up":
                // It is always 1+3 or 3+5 so on
                mLine.up(matrix);
                break;
        }
    }

    public void reset() {
        mLine.reset();
    }
}
