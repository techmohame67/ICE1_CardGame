/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @modifier MohamedIdris, 991716127
 * @author srinivsi
 */

import java.util.Random;
import java.util.Scanner;

public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Random random = new Random();
        
        for (int i = 0; i < magicHand.length; i++)
        {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1);
            c.setSuit(Card.SUITS[random.nextInt(4)]);
            magicHand[i] = c;
        }

        for (Card card : magicHand) {
            System.out.println(card.getSuit() + " " + card.getValue());
        }
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter any card from 1 to 13: ");
        int userInput = scanner.nextInt();
        System.out.print("Enter a suit (0-3 where 0 for Hearts, 1 for Diamonds, 2 for Clubs, 3 for Spades): ");
        int userInputTwo = scanner.nextInt();
        
        Card userCard = new Card();
        userCard.setValue(userInput);
        userCard.setSuit(Card.SUITS[userInputTwo]);

        boolean inHand = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                inHand = true;
                break;
            }
        }
        
        if (inHand) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }

        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        
        inHand = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equals(luckyCard.getSuit())) {
                inHand = true;
                break;
            }
        }
        
        if (inHand) {
            System.out.println("The lucky card is in the magic hand!");
        } else {
            System.out.println("The lucky card is not in the magic hand.");
        }
    }
    }
}
