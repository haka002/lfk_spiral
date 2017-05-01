package hu.i_host.thespiralkata;

public class SpiralLine {

    int mStartX;
    int mStartY;
    int mLength;

    public SpiralLine() {
        reset();
    }

    public int getStartX() {
        return mStartX;
    }

    public int getStartY() {
        return mStartY;
    }

    public int getLength() {
        return mLength;
    }

    public void down(int[][] matrix) {
        int i = 0;

        for (; i < mLength; i++) {
            matrix[mStartY + i][mStartX] = 0;
        }

        // -1 because of the loop variable
        setLastXY(mStartX, mStartY + (i - 1));
    }

    public void up(int[][] matrix) {
        int i = 0;

        for (;i < mLength; i++) {
            matrix[mStartY - i][mStartX] = 0;
        }

        // -1 because of the loop variable
        setLastXY(mStartX, mStartY - (i - 1));
    }

    public void left(int[][] matrix) {
        int i = 0;

        for (; i < mLength; i++) {
            matrix[mStartY][mStartX - i] = 0;
        }

        // -1 because of the loop variable
        setLastXY(mStartX - (i - 1), mStartY);
    }

    public void right(int[][] matrix) {
        int i = 0;

        for (; i < mLength; i++) {
            matrix[mStartY][mStartX + i] = 0;
        }

        // -1 because of the loop variable
        setLastXY(mStartX + (i - 1), mStartY);
    }

    private void setLastXY(int x, int y) {
        mStartX = x;
        mStartY = y;
    }

    public void setLength(int length) {
        mLength = length;
    }

    public void reset() {
        mStartX = 0;
        mStartY = 1;
        mLength = 0;
    }
}
