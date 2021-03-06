public class Map {

    //constant for default map size
    private final static int DEFAULT_SIZE = 9;
    //Strings of statements that are outputted upon entering a cell
    private final static String[] ENTERTEXT_LIST = {
    "You have reached the end of the desert. Beyond this, a raging sandstorm blocks your path.", 
    "You have reached the end of the desert. Beyond this, a raging sandstorm blocks your path.", 
    "You have reached the end of the desert. Beyond this, a raging sandstorm blocks your path.",
    "The enormous steepness of the slope of the mountain to the north prevents you from going further up.",
    "The enormous steepness of the slope of the mountain to the north prevents you from going further up.", 
    "The enormous steepness of the slope of the mountain to the north prevents you from going further up.",
    "Empty vials and broken machinery are scattered across the end of this room.",
    "Inactive automatons line across the room. ",
    "This appears to be where the owner of the facility stays.", 
    //0
    "You have reached the Western end of the desert. Beyond this, a raging sandstorm blocks your path.", 
    "The Great Sand Dunes stretch on.", "The temperature is hot. The sun is scorching. You seem to be near a desert.", 
    "The area becomes rocky. You seem to be near a mountain", 
    "You are clearly in the ranges now. The jagged path of rock seems overwhelming to climb.",
    "You near the Eastern end of the mountain ranges. The long hills serve almost as a barrier of some sort...", 
    "The facility has a machine for... robot manufacturing? But why?", 
    "You have opened the security door with the Skeleton Key. Inside it is a strange factory.",
    "A library of research documents and notes can be seen here.",
    //1
    "You have reached the Western end of the desert. Beyond this, a raging sandstorm blocks your path.", 
    "A pristine river flows here. Wait, it's a mirage! You're still in the dunes...", 
    "Sand mixed with rock spans across the ground. The transition between mountain and desert is here.",
    "There is a suspicious small cave here. Man made or natural? Interesting.",
    "More mountains.", "You near the Eastern end of the mountain ranges. The long hills serve almost as a barrier of some sort...",
    "Ahead is a mysterious, tall grey building.", 
    "Ahead, there is the door to the mysterious grey building. There is a keyhole, without unlocking the door, it won't budge.",
    "Ahead is a mysterious, tall grey building.",
    //2
    "You have reached the Western end of the desert. Beyond this, a raging sandstorm blocks your path.",
    "The Great Sand Dunes stretch on.", "The sun is scorching. You seem to be near a desert.", 
    "You seem to be on the Southern end of a wide mountain range.", 
    "You seem to be on the Southern end of a wide mountain range.", 
    "You seem to be on the Southern end of a wide mountain range.",
    "It's freezing here!", 
    "The frost blows around. Permafrost lines the ground.",
    "This is the end of the glacial zone. To the east is a hopeless, infinite sea.",
    //3
    "Some broken pottery shards are scattered across the dusty ground. The giant stone wall blocks your way to the right.",
    "Abandoned buildings are all around you. What could this mean?", 
    "There is a large open space nearby, with many chairs.", 
    "Leaves begin to block out your vision. Overgrown plants are everywhere", 
    "Trunks of immense trees tower over you. You are deep inside the forest.",
    "The trees have become large enough to completely halt further exploration Eastward.",    
    "Signs of life seem to be lowering. The cold is too much to bear.",
    "You are in the middle of a glacier.",
    "This is the end of the glacial zone. To the east is a hopeless, infinite sea.",
    //4
    "Some broken pottery shards are scattered across the dusty ground. The giant stone wall blocks your way to the right.",
    "More abandoned buildings. Evidence of a ruined city.",
    "Here is a sacred statue of some of divine being. Its head has been vandalized.",
    "Leaves begin to block out your vision. Overgrown plants are everywhere",
    "Trunks of immense trees tower over you. You are deep inside the forest.", 
    "The forest continues on.",
    "The forest continues on.",
    "The trees grow even taller and wider.",
    "The trees have become large enough to completely halt further exploration Eastward.",

    //5
    "Some broken pottery shards are scattered across the dusty ground. The giant stone wall blocks your way to the right.", 
    "More abandoned buildings. Evidence of a ruined city.", "More abandoned buildings. Evidence of a ruined city.",
    "Leaves begin to block out your vision. Overgrown plants are everywhere",
    "Trunks of immense trees tower over you. You are deep inside the forest.", 
    "The forest continues on.", 
    "The forest continues on.",
    "The trees grow even taller and wider.",
    "The trees have become large enough to completely halt further exploration Eastward.",
    //6
    "Some broken pottery shards are scattered across the dusty ground. The giant stone wall blocks your way to the right.",
    "More abandoned buildings. Evidence of a ruined city.", "More abandoned buildings. Evidence of a ruined city.",
    "Leaves begin to block out your vision. Overgrown plants are everywhere",
    "Trunks of immense trees tower over you. You are deep inside the forest.", 
    "The forest continues on.", 
    "The forest continues on.",
    "The trees grow even taller and wider.",
    "The trees have become large enough to completely halt further exploration Eastward.",
  
    //7
    "Some broken pottery shards are scattered across the dusty ground. The giant stone wall blocks your way to the right.",
    "More abandoned buildings. Evidence of a ruined city.", 
    "More abandoned buildings. Evidence of a ruined city.",
    "Leaves begin to block out your vision. Overgrown plants are everywhere",
    "Trunks of immense trees tower over you. You are deep inside the forest.", 
    "The forest continues on.", 
    "The forest continues on.",
    "The trees grow even taller and wider.",
    "The trees have become large enough to completely halt further exploration Eastward.",
  
    //8
    };
    
    public Cell[][] map; //map made of Cell
    private int _playerRow; 
    private int _playerColumn;
    private String playerLocation;
    private Item item, pot, weapon, weapon2, boost, drain;   
    private Monster mountain,mountain2,mountain3,mountain4,
    desert, desert2, desert3, desert4, desert5, desert6, 
    soldier, soldier2, soldier3, soldier4, soldier5, soldier6, soldier7, soldier8, soldier9, soldier10, soldier11,
    robo, robo2, robo3,finalboss;
    private Slots slot; 
    private int stopMap = 0; 
    

    //default constructor intializes a
   // DEFAULT_SIZE*DEFAULT_SIZE map
    public Map() {
	    map = new Cell[DEFAULT_SIZE][DEFAULT_SIZE];
	    int x=0;
	    //counter for populating map with entertext'd cells
	     for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Cell k = new Cell(ENTERTEXT_LIST[x]);
                x++;
                map[i][j] = k; 
            }
	     }
	     Cell a = new Cell("O");
	     
	     int rowPlayer=4; // row of player's starting point 
	     int columnPlayer=4; // column of player's starting point
	     map[rowPlayer][columnPlayer] = a; 
	     _playerRow=rowPlayer;
	     _playerColumn=columnPlayer;
	     playerLocation = rowPlayer + "," + columnPlayer; //storing the starting point of the player marked as "0"
	     
	     //instantiates items,characters,games
         item = new Key();
         finalboss=new FinalBoss();
         mountain = new Mountain(); 
         mountain2 = new Mountain();
         mountain3 = new Mountain(); 
         mountain4= new Mountain();
         desert = new Desert();
         desert2 = new Desert();
         desert3 = new Desert();
         desert4 = new Desert(); 
         desert5 = new Desert(); 
         desert6 = new Desert(); 
         soldier = new Soldiers();
         soldier2 = new Soldiers();
         soldier3 = new Soldiers();
         soldier4 = new Soldiers();
         soldier5 = new Soldiers();
         soldier6 = new Soldiers();
         soldier7 = new Soldiers();
         soldier8 = new Soldiers();
         soldier9 = new Soldiers();
         soldier10 = new Soldiers();
         soldier11 = new Soldiers();   
         pot = new Potion();
         slot = new Slots(); 
         weapon = new Weapon(); 
         weapon2 = new Weapon(); 
         boost = new Booster(); 
         drain = new Drain(); 
         
         //adds it to specific cells 
         map[0][0].addItem(item);  
         map[0][1].addMonster(desert);
         map[0][3].addMonster(desert2); 
         map[0][4].addMonster(desert3);
         map[0][6].addItem(pot); 
         map[0][7].addMonster(robo);
         map[0][8].addMonster(finalboss);
         map[1][0].addMonster(desert5); 
         map[1][2].addMonster(mountain2);
         map[1][3].addItem(pot);
         map[1][4].addMonster(desert4); 
         map[1][6].addMonster(robo2); 
         map[1][7].addMonster(robo3);
         map[2][2].addMonster(desert6);
         map[2][4].addMonster(soldier); 
         map[2][6].addItem(drain); 
         map[2][8].addMonster(soldier); 
         map[3][3].addMonster(mountain3); 
         map[3][5].addMonster(mountain);
         map[3][8].addMonster(soldier2);
         map[4][2].addGame(slot); 
         map[4][8].addItem(pot);
         map[4][7].addMonster(soldier3); 
         map[5][1].addMonster(soldier4); 
         map[5][3].addMonster(soldier5);
         map[5][6].addMonster(soldier6);
         map[5][7].addItem(weapon); 
         map[6][4].addMonster(soldier7);
         map[6][5].addItem(weapon2);
         map[6][6].addMonster(mountain4);
         map[7][2].addMonster(soldier8);
         map[7][4].addItem(pot);
         map[7][6].addItem(drain);
         map[7][7].addMonster(soldier9);
         map[8][2].addMonster(soldier10);
         map[8][5].addMonster(soldier11);
         map[8][7].addItem(pot);
         map[8][8].addItem(boost);
         }
    
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
    //gets stopMap
    public int getStopMap(){
        return stopMap;
    }
    
//changes where the player is according to the direction strung
       public void movePlayer (String direction) { 
        //w : north     
           if (direction.equals("w")) {
              _playerRow = (Integer.parseInt(playerLocation.substring(0,1)));
              _playerRow -= 1;
              _playerColumn = (Integer.parseInt(playerLocation.substring(2))); 
              playerLocation = _playerRow + "," + _playerColumn; 
           }
        //s : south   
           if (direction.equals("s")) {
               _playerRow = (Integer.parseInt(playerLocation.substring(0,1)));
               _playerRow+=1;
               _playerColumn = (Integer.parseInt(playerLocation.substring(2))); 
              playerLocation = _playerRow + "," + _playerColumn; 
           }
        //a : west 
           if (direction.equals("a")) { 
               _playerRow = (Integer.parseInt(playerLocation.substring(0,1)));
               _playerColumn = (Integer.parseInt(playerLocation.substring(2))); 
               _playerColumn -= 1; 
              playerLocation = _playerRow + "," + _playerColumn; 
           }
        //d : east    
           if (direction.equals("d")) { 
               _playerRow = (Integer.parseInt(playerLocation.substring(0,1)));
               _playerColumn = (Integer.parseInt(playerLocation.substring(2))); 
               _playerColumn+=1;
              playerLocation = _playerRow + "," + _playerColumn; 
           }
        //if a cell has a certain item - the map should not be printed
           if (((map[_playerRow][_playerColumn].hasItem()) && (map[_playerRow][_playerColumn].hasPotion())) ||
                ((map[_playerRow][_playerColumn].hasItem()) && (map[_playerRow][_playerColumn].hasWeapon())) || 
                 ((map[_playerRow][_playerColumn].hasItem()) && (map[_playerRow][_playerColumn].hasBooster())) ||
                 ((map[_playerRow][_playerColumn].hasItem()) && (map[_playerRow][_playerColumn].hasDrain()))) { 
                   stopMap = 1; 
                   }
                   
               else if (map[_playerRow][_playerColumn].hasItem()) {
          stopMap = 1; 
        }
        
        else if (map[_playerRow][_playerColumn].hasMonster()) {
            stopMap = 1; 
        }
        
        else if (map[_playerRow][_playerColumn].hasGame()) {
             stopMap = 1; 
        }
        
        else stopMap = 0; 
       }
//returns item at player location
    public Item theItem() { 
            return map[_playerRow][_playerColumn].getItem(); 
    }
//returns monster at player location 
    public Monster theMonster() { 
        return map[_playerRow][_playerColumn].getMonster(); 
    }
//returns game at player location 
    public Slots theGame() {
        return map[_playerRow][_playerColumn].getGame(); 
    }
//return column player is in 
    public int getPlayerColumn(){
        return this._playerColumn;
    }
//return row player is in 
    public int getPlayerRow(){
        return this._playerRow;
    }
//return a strung player location
    public String getPlayerLocation(){
        return this.playerLocation;
    }
//allows a way to stop the map in another class
    public void changeStop(int c) { 
        stopMap = c; 
    }
}
