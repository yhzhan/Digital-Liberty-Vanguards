public class Map {

    //constant for default map size
    private final static int DEFAULT_SIZE = 5;

    
    private Cell[][] map;
    private int _playerRow;
    private int _playerColumn;
    private String playerLocation;
    private Item item; 
    public int stopMap = 0; 

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE map
    public Map() {
	    map = new Cell[DEFAULT_SIZE][DEFAULT_SIZE];
	     for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Cell k = new Cell(); 
                //MAKE ARRAY WITH REGULAR CONSTRUCTORS AND RANDOMS,
                //THEN STORE THE ONE WITH TRUE FOR HASPLAYER'S CellS IN A VARIABLE
                map[i][j] = k; // idea : make an array of string of diff location names + randomly populate the arrays? 
            }
	     }
	     
	     Cell a = new Cell("O");
	     int rowPlayer=(int)(Math.random()*4); // row of player's starting point 
	     int columnPlayer=(int)(Math.random()*4); // column of player's starting point
	     map[rowPlayer][columnPlayer] = a; 
	     _playerRow=rowPlayer;
	     _playerColumn=columnPlayer;
	     playerLocation = rowPlayer + "," + columnPlayer; //storing the starting point of the player marked as "0"
         map[0][0].addItem();
         }
    

/**

    //constructor intializes an a*a map
    public Map( int n ) {
	    map = new Cell[n][n];
    }
    **/
    
    //return String representation of this map
    // (make it look like a map)
    public String toString() {
	    String str = "";
            for(int rows = 0; rows < map.length ; rows++) {
                for (int column = 0; column < map[rows].length ; column++) {
                    if (rows==(Integer.parseInt(playerLocation.substring(0,1)))){
                        if (column==(Integer.parseInt(playerLocation.substring(2)))){
                            str+="O"+"\t";
                        }
                        else{
                            str+="X"+"\t";
                        }
                    }
                    else{
                        str+="X"+"\t";
                    }
                    
                }
                str += "\n";
            }
        return str; 
    }
    
    ///need to add the null and out of bounds cases 
    ///if incorrect directions >> output some correcting words 
       public void movePlayer (String direction) { 
        //   **== or .equals -- its not the same object right
           //glooks not commenting this
           
        
           if (direction.equals("i")) {
              
              _playerRow = (Integer.parseInt(playerLocation.substring(0,1)));
              _playerRow -= 1;
              _playerColumn = (Integer.parseInt(playerLocation.substring(2))); 
              playerLocation = _playerRow + "," + _playerColumn; 
           }
           
           if (direction.equals("k")) {
               _playerRow = (Integer.parseInt(playerLocation.substring(0,1)));
               _playerRow+=1;
               _playerColumn = (Integer.parseInt(playerLocation.substring(2))); 
              playerLocation = _playerRow + "," + _playerColumn; 
           }
           
           if (direction.equals("j")) { 
               _playerRow = (Integer.parseInt(playerLocation.substring(0,1)));
               _playerColumn = (Integer.parseInt(playerLocation.substring(2))); 
               _playerColumn -= 1; 
              playerLocation = _playerRow + "," + _playerColumn; 
           }
           
           if (direction.equals("l")) { 
               _playerRow = (Integer.parseInt(playerLocation.substring(0,1)));
               _playerColumn = (Integer.parseInt(playerLocation.substring(2))); 
               _playerColumn+=1;
              playerLocation = _playerRow + "," + _playerColumn; 
           }
           if (map[_playerRow][_playerColumn].hasItem()) {
               stopMap = 1; 
        System.out.println("You found a " + theItem() + "!" + " But, what's it for?"); 
        }
        else stopMap = 0; 
}
    
    public String theItem() { 
        String foo = "";
        if (map[0][0].hasItem())  {
        Cell a = new Cell();
        foo += map[0][0]._item.toString(); }
        return foo;
    }
/*** add mutator to Cell so u can change the Cells appearance (whats strung and seen on the map)
        when the player enters that Cell. 
        
        ****/

/**move player 
    -- idea : if we keep the store Cell aka (String where) >> then take the substrings parse to integer 
    and then do like map[whatever the substring is][whatever substring is that player is at] and do like +1 at the row 
    for when its  right arrow, left arrow or maybe even letters ? like JIKL instead. 
    ** will need to implement out of bounds , and nulls, empties. 
    
 
    
    
**/// 
        

    public static void main(String[] args) {
        Map a = new Map(); 
        System.out.println(a);
        System.out.println(a.playerLocation);
 //       System.out.println(a.theItem()); 
 //       System.out.println(a.Where());
       
  
    }
}