package hu.i_host.thespiralkata;

import android.util.Log;

import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

public class SpiralTable {
    private List<String> mDirectionList;
    private SpiralLine mLine;

    private int[][] mMatrix;
    private Iterator mDirectionListIterator;

    @Inject
    public SpiralTable(SpiralLine line, List<String> directionList) {
        mDirectionList         = directionList;
        mLine                  = line;
        mDirectionListIterator = directionList.iterator();
    }

    public int[][] go(int dimension) {

        if (dimension < 5) {
            throw new InvalidParameterException("The dimension minimal size is 5.");
        }

        mMatrix = new int[dimension][dimension];

        fillUpMatrix(dimension);

        int stripeBefore = 0;
        int stripeAfter  = 1;

        // Stripes 0+1
        drawLine(dimension, stripeBefore, stripeAfter);

        // Set the next stripe (1+1)
        stripeBefore = 1;

        // Travers the stripes (1+1, 1+1, 1+3, 1+3, 3+3, 3+3, 3+5, ...)
        // We know the length of the line from the stripes and the dimension 9 = 10 - (0 + 1)
        do {
            // Whe have twister stripe pairs (1+3, 1+3)
            for (int k = 0; k < 2; k++) {
                drawLine(dimension, stripeBefore, stripeAfter);
            }

            // We would like to step like this: 1+1, 3+1, 3+3, 5+3, 5+5
            if (stripeBefore == stripeAfter) {
                stripeBefore += 2;
            } else {
                stripeAfter = stripeBefore;
            }
        }
        while (stripeAfter + stripeBefore + 1 < dimension);

        return mMatrix;
    }

    private void fillUpMatrix(int dimension) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                mMatrix[i][j] = 1;
            }
        }
    }

    /** Returns the next direction. It will loop the list. */
    private String getNextDirection() {
        if (!mDirectionListIterator.hasNext()) {
            mDirectionListIterator = mDirectionList.iterator();
        }

        return (String)mDirectionListIterator.next();
    }

    private void drawLine(int dimension, int stripeBefore, int stripeAfter) {
        mLine.setLength(dimension - (stripeBefore + stripeAfter));

        String direction = getNextDirection();
        Log.e("Spiral", direction + " " + stripeBefore + " + " + stripeAfter);

        switch (direction) {
            case "left":
                // It is always 1+1 or 3+3 or 5+5 so on
                mLine.left(mMatrix);
                break;

            case "right":
                // It is always 0+1 or 1+3 or 3+5 so on
                mLine.right(mMatrix);
                break;

            case "down":
                // It is always 1+1 or 3+3 or 5+5 so on
                mLine.down(mMatrix);
                break;
            case "up":
                // It is always 1+3 or 3+5 so on
                mLine.up(mMatrix);
                break;
        }
    }

    void init() {
        mDirectionListIterator = mDirectionList.iterator();
        mLine.init();
    }
}
