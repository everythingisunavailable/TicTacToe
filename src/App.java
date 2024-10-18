
public class App {

    static final int fSize = 3;
    static final int nMoves = 9;
    static boolean gameOver = false;
    static int[][] field = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
        };
    static String[][] displayField ={
        {"1", "2", "3"},
        {"4", "5", "6"},
        {"7", "8", "9"}
        };
    static int playerMove = 0;
    static boolean[] movesAvailable = {true, true, true, true, true, true, true, true, true};
    static int nTruns = -1;

        
    static int afterClick(int playerMove, int player){
        nTruns++;
        movesAvailable[playerMove-1] = false;
        //update the field 
        update(playerMove, player);

        if (checkWin(playerMove) == 1){
            System.out.println("Player "+ player + " won, Congrats!");
            return 1;
        }
        int count = 0;
        for (int i = 0; i < movesAvailable.length; i++) {
            if (!movesAvailable[i]) {
                count++;
            }
        }
        //if its not a win and the nr of moves has sufficed(big words)
        if (nMoves == count) {
            System.out.println("Its a draw, Better luck next time! ");
            return 2;
        }
        //keep going
        return 0;
    }

    static int checkWin(int recentMove){
        //1 win
        //0 keep going
        switch (recentMove) {
            case 1:
                if (field [0][0] != 0) {
                    if (field[0][0] == field[0][1] && field[0][0] == field[0][2]) {
                        return 1;
                    }
                    else if (field[0][0] == field[1][1] && field[0][0] == field[2][2]){
                        return 1;
                    }
                    else if (field[0][0] == field[1][0] && field[0][0] == field[2][0]) {
                        return 1;
                    }
                }
               break;    
            case 2:
                if(field[0][1] != 0){
                    if (field[0][1] == field[0][0] && field[0][1] == field[0][2]) {
                        return 1;
                    }
                    else if (field[0][1] == field[1][1] && field[0][1] == field[1][2]){
                        return 1;
                    }
                }
                    break;
            case 3:
                if(field[0][2] != 0){           
                    if (field[0][0] == field[0][1] && field[0][0] == field[0][2]) {
                        return 1;
                    }
                    else if (field[0][2] == field[2][0] && field[1][1] == field[0][2]){
                        return 1;
                    }
                    else if (field[0][2] == field[1][2] && field[0][2] == field[2][2]) {
                        return 1;
                    }
                }
                break;
            case 4:
                if(field[1][0] != 0){
                    if (field[1][0] == field[1][1] && field[1][0] == field[1][2]) {
                        return 1;
                    }
                    else if (field[0][0] == field[1][0] && field[0][0] == field[2][0]) {
                        return 1;
                    }
                }
                break;
            case 5:
                if(field[1][1] != 0){
                    if (field [1][1] == field[0][0] && field[1][1] == field [2][2]){
                        return 1;
                    }
                    else if (field [1][1] == field [0][1] && field [1][1] == field [2][1]) {
                        return 1;
                    }
                    else if (field [1][1] == field [1][0] && field [1][1] == field [1][2] ) {
                        return 1;
                    }
                    else if (field [1][1] == field [2][0] && field [1][1] == field [0][2] ) {
                        return 1;
                    }
                }
                break;
            case 6:
                if(field[1][2] != 0){
                    if (field [1][2] == field [1][1] && field [1][2] == field [1][0]) {
                        return 1;
                    }
                    else if (field [1][2] == field [0][2] && field[1][2] == field[2][2]){
                        return 1;
                    }
                }
                        break;
            case 7:
                if(field[2][0] != 0){   
                    if (field[0][0] == field[1][0] && field[0][0] == field[2][0]) {
                        return 1;
                    }
                    else if (field [1][1] == field [2][0] && field [1][1] == field [0][2] ) {
                        return 1;
                    }
                    else if (field [2][0] == field[2][1] && field[2][0] == field[2][2]) {
                        return 1;
                    }
                }
                break;
            case 8:
                if(field[2][1] != 0){
                    if (field [2][0] == field[2][1] && field[2][1] == field[2][2]) {
                        return 1;
                    }
                    else if (field[0][1] == field[2][1] && field[1][1] == field[2][1]) {
                        return 1;
                    }
                }
                break;
            case 9:
                if(field[2][2] != 0){    
                    if (field[2][2] == field[2][1] && field[2][2] == field[2][0]) {
                        return 1;
                    }
                    else if (field [2][2] == field [1][2] && field [2][2] == field [0][2] ) {
                        return 1;
                    }
                    else if (field [0][0] == field[1][1] && field[0][0] == field[2][2]) {
                        return 1;
                    }
                }
                break;
        }
        return 0;
    }
    static void update(int playerMove, int factor){
        int count = 0;
        for (int i = 0; i < fSize; i++) {
            for (int j = 0; j < fSize; j++) {
                count++;
                if (count == playerMove ) {
                    field[i][j] = factor;
                    if (factor == 1) {
                        //player 1 = X, player 2 = O
                        displayField[i][j] = "x";
                    }
                    else{
                        displayField[i][j] = "o";
                    }
                }
            }
        }
    }

    static void print(){
        for ( int i = 0; i < fSize; i++){
            for ( int j = 0; j < fSize; j++){
                System.out.print(displayField[i][j] + " ");
            }
            System.out.println();
        }
    }
}
