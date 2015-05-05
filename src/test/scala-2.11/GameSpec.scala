import com.practise.deckofcards.Game
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by stamma001c on 5/5/15.
 */

import Game._
import Game.SuitEnum._

class GameSpec extends FlatSpec with Matchers {

  val expectedCards = List(CARD(Diamond, 1), CARD(Diamond, 2), CARD(Diamond, 3), CARD(Diamond, 4), CARD(Diamond, 5), CARD(Diamond, 6), CARD(Diamond, 7),
    CARD(Diamond, 8), CARD(Diamond, 9), CARD(Diamond, 10), CARD(Diamond, 11), CARD(Diamond, 12), CARD(Diamond, 13),
    CARD(Club, 1), CARD(Club, 2), CARD(Club, 3), CARD(Club, 4), CARD(Club, 5), CARD(Club, 6), CARD(Club, 7),
    CARD(Club, 8), CARD(Club, 9), CARD(Club, 10), CARD(Club, 11), CARD(Club, 12), CARD(Club, 13),
    CARD(Hearts, 1), CARD(Hearts, 2), CARD(Hearts, 3), CARD(Hearts, 4), CARD(Hearts, 5), CARD(Hearts, 6), CARD(Hearts, 7),
    CARD(Hearts, 8), CARD(Hearts, 9), CARD(Hearts, 10), CARD(Hearts, 11), CARD(Hearts, 12), CARD(Hearts, 13),
    CARD(Spades, 1), CARD(Spades, 2), CARD(Spades, 3), CARD(Spades, 4), CARD(Spades, 5), CARD(Spades, 6), CARD(Spades, 7),
    CARD(Spades, 8), CARD(Spades, 9), CARD(Spades, 10), CARD(Spades, 11), CARD(Spades, 12), CARD(Spades, 13))

  val expectedDiamondCards =  List(CARD(Diamond, 1), CARD(Diamond, 2), CARD(Diamond, 3), CARD(Diamond, 4), CARD(Diamond, 5), CARD(Diamond, 6), CARD(Diamond, 7),
    CARD(Diamond, 8), CARD(Diamond, 9), CARD(Diamond, 10), CARD(Diamond, 11), CARD(Diamond, 12), CARD(Diamond, 13))

  val expectedClubCards = List(CARD(Club, 1), CARD(Club, 2), CARD(Club, 3), CARD(Club, 4), CARD(Club, 5), CARD(Club, 6), CARD(Club, 7),
    CARD(Club, 8), CARD(Club, 9), CARD(Club, 10), CARD(Club, 11), CARD(Club, 12), CARD(Club, 13))

  val expectedHeartCards = List(CARD(Hearts, 1), CARD(Hearts, 2), CARD(Hearts, 3), CARD(Hearts, 4), CARD(Hearts, 5), CARD(Hearts, 6), CARD(Hearts, 7),
  CARD(Hearts, 8), CARD(Hearts, 9), CARD(Hearts, 10), CARD(Hearts, 11), CARD(Hearts, 12), CARD(Hearts, 13))

  val expectedSpadeCards = List(CARD(Spades, 1), CARD(Spades, 2), CARD(Spades, 3), CARD(Spades, 4), CARD(Spades, 5), CARD(Spades, 6), CARD(Spades, 7),
    CARD(Spades, 8), CARD(Spades, 9), CARD(Spades, 10), CARD(Spades, 11), CARD(Spades, 12), CARD(Spades, 13))

  "Deck of cards" should "have 52 count." in {
    val acutalCards = DeckOfCards()
    acutalCards.length shouldEqual 52
    acutalCards shouldEqual expectedCards
  }

  it should "shuffle" in {
    val cards = DeckOfCards()
    val shuffledCards = cards.shuffle()
    shuffledCards.length shouldEqual 52
    shuffledCards should not equal cards
  }

  it should "be ordered" in {
    val cards = DeckOfCards()
    val shuffledCards = cards.shuffle()
    val sortedCards = shuffledCards.sort()
    sortedCards.length shouldEqual 52
    sortedCards shouldEqual expectedCards
  }

  it should "get the same suit of cards when queried with suit" in {
    val cards = DeckOfCards()
    val shuffledCards = cards.shuffle()
    val actualDiamondCards  = shuffledCards.getCardBySuit(Diamond).sort()
    val actualClubCards = shuffledCards.getCardBySuit(Club).sort()
    val actualHeartCards = shuffledCards.getCardBySuit(Hearts).sort()
    val actualSpadeCards = shuffledCards.getCardBySuit(Spades).sort()

    actualDiamondCards.length shouldEqual 13
    actualClubCards.length shouldEqual 13
    actualHeartCards.length shouldEqual 13
    actualSpadeCards.length shouldEqual 13

    actualDiamondCards shouldEqual expectedDiamondCards
    actualClubCards shouldEqual expectedClubCards
    actualHeartCards shouldEqual expectedHeartCards
    actualSpadeCards shouldEqual expectedSpadeCards
  }

}
