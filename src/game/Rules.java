package game;

import materials.CoinState;

import java.util.List;

public class Rules {

  /**
   * Cette méthode permet de déterminer si une suite d'états de pièce permet de gagner à une partie
   * @param states liste d'états pour un joueur
   * @return true si un joueur a gagné, false sinon
   */
  public boolean checkWin(List<CoinState> states) {
    for (int index = 0; index < states.size(); index++){
       if (checkRow(index, states)){
         return true;
       }
    }
    return false;
  }

  private boolean checkRow(int index, List<CoinState> states){
    if (states.size() > index + 2){
      if (states.get(index).equals(states.get(index + 1)) && (states.get(index + 1).equals(states.get(index + 2))) ){
        return true;
      }
    }
    return false;
  }
}
