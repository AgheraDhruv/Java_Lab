class Driver {
    public static void main(String[] args) {
        Card[] card = new Card[5];

        card[0] = new Card("Ace", "Spades");
        card[1] = new Card("King", "Diamond");
        card[2] = new Card("Queen", "Hearts");
        card[3] = new Card("Ace", "Spades");
        card[4] = new Card("Queen", "Hearts");

        int distinct = 0;
        for (int i = 0; i < card.length; i++) {
            boolean alreadyExist = false;
            for (int j = 0; j < i; j++) {
                if (card[i].equals(card[j])) {
                    alreadyExist = true;
                    System.out.println("Dublicate found :" + card[i]);
                    break;
                }
            }
            if (!alreadyExist) {
                distinct++;
            }
        }
        System.out.println("Dublicate Cards :" + (card.length - distinct));
    }
}