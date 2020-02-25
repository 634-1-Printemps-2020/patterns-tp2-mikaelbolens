package game;

import materials.Coin;
import materials.CoinState;
import player.Player;
import utils.Statistics;

import java.util.*;

public class Game {

    private Coin coin;
    private Map<Player, List<CoinState>> history;
    private Statistics statistics;

    public Game() {
        coin = Coin.getCoin();
        history = new HashMap<>();
    }

    /**
     * Ajouter un nouveau joueur au jeu
     *
     * @param player le nouveau joueur
     */
    public void addPlayer(Player player) {
      history.put(player, new ArrayList<>());
    }

    /**
     * Faire joueur tous les joueurs et stocker chaque partie dans history
     */
    public void play() {
        int fewerMovesToWin = 0;
        int totalNumberMoves = 0;
        float avgToWin = 0;
        int mostMovesToWin = 0;
        
        Rules rules = new Rules();

            for (Player p : history.keySet()){
                fewerMovesToWin = 0;
                List<CoinState> lst = history.get(p);
                while (!rules.checkWin(lst)){
                    p.play(coin);
                    lst.add(coin.getState());
                    fewerMovesToWin += 1;
                    totalNumberMoves += 1;
                }

            }
            for (List<CoinState> lst : history.values()){
                avgToWin += lst.size();
                if (lst.size() > mostMovesToWin){
                    mostMovesToWin = lst.size();
                }
                if (lst.size() < fewerMovesToWin){
                    fewerMovesToWin = lst.size();
                }
            }
        avgToWin = avgToWin / history.size();
        statistics = new Statistics(avgToWin, fewerMovesToWin, mostMovesToWin, totalNumberMoves);
    }



    /**
     * Calculer des statistiques de la partie précédente
     *
     * @return Statistics
     */
    public Statistics getStatistics() {
      return statistics;
    }

    /**
     * Obtenir l'historique de tous les joueurs de la partie précédente
     *
     * @return Map contenant chaque joueur et la liste des ses lancers
     */
    public Map<Player, List<CoinState>> getHistory() {
      return history;
    }


    /**
     * Obtenir l'historique d'un joueur spécifique
     *
     * @param player instance du joueur pour lequel on veut avoir l'historique
     * @return la liste des lancers d'un joueur
     */
    public List<CoinState> getSpecificHistory(Player player) {
      return history.get(player);
    }

}
