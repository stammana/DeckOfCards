package com.practise.deckofcards

import Game.CARD

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
 * Created by stamma001c on 5/4/15.
 */


object Game extends App {

  object SuitEnum extends Enumeration {

    type Suit = Value

    val Diamond, Club, Hearts, Spades = Value

  }

  type Deck = List[CARD]

  import SuitEnum._

  object DeckOfCards {

    def apply(): Deck = {
      SuitEnum.values.flatMap(suit => (1 to 13).map(CARD(suit, _))).toList
    }
  }

  implicit class Shuffle(cards: Deck) {
    def shuffle(): Deck = {
      Random shuffle (cards)
    }
  }

  implicit class GetSuit(cards: Deck) {
    def getCardBySuit(suit: Suit): Deck = {
      cards filter (_.suit == suit)
    }
  }

  implicit class Order(cards: Deck) {
    def sort(): Deck = {
      def mergeSort(xs: Deck): Deck = {
        val n = xs.length / 2
        if (n == 0) xs
        else {
          def merge(xs: Deck, ys: Deck): Deck =
            (xs, ys) match {
              case (Nil, ys) => ys
              case (xs, Nil) => xs
              case (x :: xs1, y :: ys1) =>
                if (x < y) x :: merge(xs1, ys)
                else y :: merge(xs, ys1)
            }
          val (left, right) = xs splitAt (n)
          merge(mergeSort(left), mergeSort(right))
        }
      }
      mergeSort(cards)
    }
  }

  case class CARD(suit: Suit, num: Int) extends Ordered[CARD] {
    def compare(that: CARD): Int = {

      this.suit match {

        case that.suit => this.num.compare(that.num)

        case _ => this.suit.compare(that.suit)
      }
    }
  }
}
