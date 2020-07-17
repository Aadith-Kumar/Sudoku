class Main{
    
    public static int findPossNum (int [][][] sud, int x, int y){
         if(sud[x][y][0] != 0) return sud[x][y][0]; 
         
         int diagX =  3* (x/3); // Using round down division to get the starting index of the sub box
         int diagY =  3* (y/3);
         
         int tot = 0; // Stores the total number of possible numbers in a cell
         int possNum = 0; //Stores a particular possible number in the cell. 
         for(int n = 1; n <= 9; n++){
            if(sud[x][y][n] == 0){ 
                //Checking if there is only one possibile number in the cell
                possNum = n; 
                tot++;
                
                boolean anotherPoss = false; //Checks if there is another possible cell for given number n;
                //Checking if the current cell is the only possible cell in the sub-box for the given number n
                outer: for(int i = diagX; i < diagX + 3; i ++){
                    for (int j = diagY; j < diagY + 3; j++){
                       if (((i!=x) || (j!=y)) && (sud[i][j][n] == 0)){
                          anotherPoss = true;
                          break outer;                          
                       }
                    }
                }               
                if(!anotherPoss) return n;
                
                anotherPoss = false;
                //Checking if the current cell is the only possible cell for number n in the concerned row
                for(int i = 0; i < 9; i++){
                    if (sud[x][i][n] == 0 && (i!=y)){
                        anotherPoss = true;
                        break;
                    }                    
                }                
                if(!anotherPoss) return n;
                
                anotherPoss = false;
                //Checking if the current cell is the only possible cell for number n in the concerned coloumn
                for(int i = 0; i < 9; i++){
                    if (sud[i][y][n] == 0 && (i!=x)){
                        anotherPoss = true;
                        break;
                    }                    
                }
                
                if(!anotherPoss) return n;
            }
         }
         if(tot == 1) return possNum;
         return 0;  
    } 
    
    public static void insert(int [][][] sud, int x, int y, int num){
        
        sud[x][y][0] = num;
        for ( int i = 0; i  < 9;i++){
            sud [x][i][num] = 1; // 1 -- means already used (not availible at this position
            sud [i][y][num] = 1;
            sud [x][y][i+1] =1 ;
        }
       
        int diagX =  3* (x/3) ; // using round down division to get the starting index of the sub box
        int diagY =  3* (y/3) ;
        for ( int i = diagX; i < diagX + 3; i ++){
            for (int j = diagY; j < diagY + 3; j++){

                sud[i][j][num] = 1;
            }
        } 

    }
    
    public static void printSudoku (int [][][] sud){
        for ( int i = 0; i < sud.length; i ++){
            for ( int k = 0; k  < sud[i].length; k ++){
                if(sud[i][k][0] == 0) System.out.print ( "  | ");
                else System.out.print ( sud[i][k][0] + " | ");
            }
            System.out.println();
            System.out.println("-----------------------------------");
        }
        
    }
    
    public static int[][][] createBlank(){
        int[][][] sud = new int [9][9][10];
        for ( int i = 0; i < sud.length; i ++){
            for ( int k = 0; k  < sud[i].length; k ++){
                for(int j = 0; j < sud[i][k].length; j++){
          
                    sud[i][k][j] =0;
                }
                
            }
            
        }
        return sud;
    }

    
    public static int[][][] main(String[] args){
      int[][][] sud = createBlank();
      insert(sud,0,1,5);
      insert(sud,0,2,7);
      insert(sud,0,5,4);
      insert(sud,0,6,2);
      insert(sud,1,0,8);
      insert(sud,1,7,5);
      insert(sud,2,2,4);
      insert(sud,2,3,1);
      insert(sud,2,4,6);
      insert(sud,2,7,3);
      insert(sud,3,4,1);
      insert(sud,3,6,5);
      insert(sud,3,8,8);
      insert(sud,5,0,4);
      insert(sud,5,2,6);
      insert(sud,5,4,7);
      insert(sud,6,1,4);
      insert(sud,6,4,8);
      insert(sud,6,5,3);
      insert(sud,6,6,6);
      insert(sud,7,1,7);
      insert(sud,7,8,3);
      insert(sud,8,2,5);
      insert(sud,8,3,6);
      insert(sud,8,6,4);
      insert(sud,8,7,2);
      
      int x = 1;
      int y = 8;
      int num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 2; 
      y = 5;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 6; 
      y = 8;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 0; 
      y = 3;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 2; 
      y = 6;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 2; 
      y = 8;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 7; 
      y = 7;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 8; 
      y = 1;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 4; 
      y = 2;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 5; 
      y = 5;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 1; 
      y = 1;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 7; 
      y = 0;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 8; 
      y = 0;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 1; 
      y = 2;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 0; 
      y = 0;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 0; 
      y = 4;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 1; 
      y = 6;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 4; 
      y = 6;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 3; 
      y = 0;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 4; 
      y = 0;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 5; 
      y = 3;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);

      x = 7; 
      y = 4;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);

      x = 8; 
      y = 5;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);

      x = 8; 
      y = 8;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 8; 
      y = 4;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 6; 
      y = 7;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 7; 
      y = 6;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 5; 
      y = 6;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 6; 
      y = 3;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 7; 
      y = 2;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 6; 
      y = 0;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 6; 
      y = 2;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 3; 
      y = 2;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 7; 
      y = 3;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 7; 
      y = 5;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 2; 
      y = 0;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 2; 
      y = 1;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 4; 
      y = 4;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 1; 
      y = 4;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 1; 
      y = 3;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 1; 
      y = 5;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 4; 
      y = 3;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 3; 
      y = 3;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 4; 
      y = 1;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 5; 
      y = 1;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 3; 
      y = 1;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 4; 
      y = 5;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 3; 
      y = 5;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 3; 
      y = 7;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 5; 
      y = 7;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 4; 
      y = 7;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 0; 
      y = 7;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 0; 
      y = 8;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 4; 
      y = 8;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      x = 5; 
      y = 8;
      num = findPossNum(sud,x,y);
      insert(sud,x,y,num);
      
      printSudoku(sud);
      return sud;
 
    }
}