package materials;
import java.util.Random;

public class Coin {

  private static CoinState coinState;
  private static Coin coin;
  /**
   * Change l'état de la pièce.
   * 50% de probabilité d'obtenir HEADS, 50% de probabilité d'obtenir TAILS
   */
  private Coin(){
    throwCoin();
  }


  public static void throwCoin() {
    Random rand = new Random();
    int value = rand.nextInt(2);

    if (value == 0){
        coinState = CoinState.HEADS;}
    else {coinState = CoinState.TAILS;
    }


  }

  public CoinState getState() {
    return coinState;
  }

  public static Coin getCoin(){
    if (coin == null){
      coin = new Coin();
    }
    return coin;
  }


}
