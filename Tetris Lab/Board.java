import java.awt.Point;

/**
 * Represents a Tetris board -- essentially a 2D grid of booleans. Supports
 *      tetris pieces and row clearning.
 *  Has an "undo" feature that allows clients to add and remove pieces efficiently.
 *  Does not do any drawing or have any idea of pixels. Intead, just represents
 *      the abstract 2D board.
 *  See the lab documentation for an overview.
 *  
 *  @author    Nick Parlante
 *  @version   1.0, Mar 1, 2001
 */
 
 
 /*
  * NB: The board is naturally organized into rows and columns. However, pieces
  *      are organized on an x-y coordinate system. The conversion between rows
  *      and columns and y and x values can be confusing. Be careful.
  */


public class Board
{
    private int width;
    private int height;
    private boolean[][] grid;
    private int[] rowWidths;
    private int[] colHeights;
    private int maxHeight;

    // backup data structures to support undo
    private boolean[][] gridBackup;
    private int[] rowWidthsBackup;
    private int[] colHeightsBackup;
    private int maxHeightBackup;

    private boolean committed;

	// set DEBUG to true while developing the lab to enable sanity checks
    private boolean DEBUG = true;

    /**
     * Creates an empty board of the given width and height measured in blocks.
     * 
     * @param initialWidth  width of this board in units of blocks
     * @param initialHeight height of this board in units of blocks
     */
    public Board(int initialWidth, int initialHeight)
    {
        // TODO: implement constructor
    }

    /**
     * Returns the width of the board in blocks.
     * 
     * @return the width of the board in blocks
     */
    public int getWidth()
    {
        return this.width;
    }

    /**
     * Returns the height of the board in blocks.
     * 
     * @return the height of the board in blocks
     */
    public int getHeight()
    {
        return this.height;
    }

    /**
     * Returns the max column height present in the board.
     *  For an empty board this is 0.
     *  
     *  @return the max column height present in the board
     */
    public int getMaxHeight()
    {
        return this.maxHeight;
    }

    /**
     * Given a piece and a column, returns the row value where the bottom of the
     *      piece would come to rest if its left edge were dropped straight down
     *      at that column.
     *      
     *  Implementation hint: use the skirt and the column heights to compute this
     *      fast -- O(skirt length).
     *      
     *  @param piece    the piece that will be dropped
     *  @param col      the column in which the left-edge of the piece will be
     *                  dropped
     *  @return the row value where the bottom of the piece would come to rest
     */
    public int dropHeight(Piece piece, int col)
    {
        // TODO: implement method
    }

    /**
     * Returns the height of the specified column -- i.e. the row value of the
     *      highest block + 1.
     *  The height is 0 if the column contains no blocks.
     *  
     *  @param col  the column from which to compute the height
     *  @return the height of the specified column
     */
    public int getColumnHeight(int col)
    {
        return this.colHeights[col];
    }

    /**
     * Returns the number of filled blocks in the specified row.
     * 
     * @param row   the row from which to compute the width
     * @return the number of filled blocks in the specified row
     */
    public int getRowWidth(int row)
    {
        return this.rowWidths[row];
    }

    /**
     * Returns true if the given block is filled in the board.
     *  Blocks outside of the valid width/height area always return true.
     *  
     *  @param col  the specified column
     *  @param row  the specified row
     *  @return true if the given block is filled in the board
     */
    public boolean getGrid(int col, int row)
    {
        if(col < 0 || col > this.getWidth() || row < 0 || row > this.getHeight())
        {
            return true;
        }

        return this.grid[row][col];
    }

    public static final int PLACE_OK = 0;
    public static final int PLACE_ROW_FILLED = 1;
    public static final int PLACE_OUT_BOUNDS = 2;
    public static final int PLACE_BAD = 3;

    /**
     * Attempts to add the body of a piece to the board.
     *  Copies the piece blocks into the board grid.
     *      
     *  Error cases:
     *      If part of the piece would fall out of bounds, the placement does
     *          not change the board at all, and PLACE_OUT_BOUNDS is returned.
     *      If the placement is "bad" --interfering with existing blocks in the
     *          grid -- then the placement is halted partially complete and
     *          PLACE_BAD is returned. An undo() will remove the bad placement.
     *          
     *  @param piece    the piece to place its lower-left corner at the
     *                      specified column and row
     *  @return PLACE_OK for a regular placement or PLACE_ROW_FILLED for a
     *      regular placement that causes at least one row to be filled.
     *		PLACE_OUT_BOUNDS or PLACE_BAD for error cases.
     */
    public int place(Piece piece, int placeCol, int placeRow)
    {
    	/*
    	 * PSEUDOCODE:
    	 *	1. backup the current state of the board
    	 *  2. for each point in the piece's body:
         *      check if it collides with another piece,
         *      update the row widths,
         *      update the column height if needed,
         *      update the max height if needed,
         *  3. check for completed rows (could be part of step 2)
         *	4. return status code for the placement
         */
         
         // TODO: implement method
    }

    /**
     * Deletes rows that are filled all the way across, moving blocks above down.
     * 	Returns true if any row clearing happened.
     * 
     * Implementation hints:
     *      This is complicated.
     *      Ideally, you want to copy each row down to its correct location in one pass.
     *      Note that more than one row may be filled.
     *		Remember to update the column heights and max height if needed.
     *      
     *  @return true if any row clearing happened
     */
    public boolean clearRows()
    {
        // TODO: implement method
    }
    
    /**
     * If a place() happens, optionally followed by a clearRows(), a subsequent
     *      undo() reverts the board to its state before the place(). If the
     *      conditions for undo() are not met, such as calling undo() twice in a
     *      row, then the second undo() does nothing.
     *  See the lab document.
     */
    public void undo()
    {
        // TODO: implement method
    }

    /**
     * Puts the board in the committed state.
     * See the overview docs.
     */
    public void commit()
    {
        this.committed = true;
    }

    /**
     * Checks the board for internal consistency -- used for debugging.
     */
    public void sanityCheck()
    {
        if (DEBUG)
        {
            if(this.grid.length != this.getHeight())
            {
                throw new RuntimeException("grid height != board height");
            }

            if(this.grid[0].length != this.getWidth())
            {
                throw new RuntimeException("grid width != board width");
            }

            // check row widths
            for(int row = 0; row < this.getHeight(); row++)
            {
                int width = 0;
                for(int col = 0; col < this.getWidth(); col++)
                {
                    if(this.grid[row][col])
                    {
                        width++;
                    }
                }

                if(this.rowWidths[row] != width)
                {
                    throw new RuntimeException("row widths inconsistent");
                }
            }

            // check column heights
            for(int col = 0; col < this.getWidth(); col++)
            {
                int height = 0;
                for(int row = 0; row < this.getHeight(); row++)
                {
                    if(this.grid[row][col])
                    {
                        height = row + 1;
                    }
                }

                if(this.colHeights[col] != height)
                {
                    throw new RuntimeException("column heights inconsistent");
                }
            }

            // check max height
            int maxHeight = 0; 
            for(int col = 0; col < this.getWidth(); col++)
            {
                if(this.getColumnHeight(col) > maxHeight)
                {
                    maxHeight = this.getColumnHeight(col);
                }
            }

            if(this.getMaxHeight() != maxHeight)
            {
                throw new RuntimeException("max height inconsistent");
            }
        }
    }
}
