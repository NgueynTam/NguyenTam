//Programmer: Marvell Suhali, Farrel Harten, Rachit Khunderwal, Tam Nguyen
//Class: CS145
//Date: 25/4/2023
//Assignment: Lab 3: Deck of Cards
//Purpose: The purpose of this lab is to create a game using deck of cards and the game that I choose is blackjack.

public class Player {
    //input name
    private String name;

    // cards for player
    private Card[] hand = new Card[10];

    // number of cards in player's hand
    private int numCards;

    public Player (String aName){
        this.name = aName;

        this.emptyHand();
    }
    //when player has empty hand
    public void emptyHand(){
        for (int c=0; c < 10; c++) {
        this.hand[c] = null;
        }
        this.numCards = 0;
    }
    //adding card to player
    public boolean addCard(Card aCard){
        //error if card exceeds allowed number of cards
        if (this.numCards == 10){
            System.err.printf("%s's hand exceeds 10 cards");
            System.exit(1);
        } //adds new cards, adding to counter
        this.hand[this.numCards] = aCard;
        this.numCards++;

        return (this.getHandTotal() <= 21);
    }

    // To find cards total in hand
    public int getHandTotal(){
        int handTotal = 0;
        int cardNum;
        int numAces = 0;

        //calculating hand total
        for (int c=0; c < this.numCards; c++) {
            // number of current card
            cardNum = this.hand[c].getNumber();

            if (cardNum == 1) { // Ace
                numAces++;
                handTotal += 11;
            }  else if (cardNum > 10) {
                handTotal += 10;
            } else {
                handTotal += cardNum;
            }

            }
        while (handTotal < 21 && numAces > 0){
            handTotal -= 10;
            numAces--;
        }
        return handTotal;
    }
    //print player's cards
    public void printHand(boolean showFirstCard){
        System.out.printf("%s's cards :\n", this.name);
        for (int c = 0; c < this.numCards; c++){
            if (c == 0 && !showFirstCard) {
                System.out.println("(hidden)");
            } else {
                System.out.printf("  %s\n", this.hand[c].toString());
            }
        }
    }
}
