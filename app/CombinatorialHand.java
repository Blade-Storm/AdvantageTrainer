class CombinatorialHand{
    Hand.HandType handType;

    static class DealerCard{
        int dealerCard;

        static class PlayerHand{
            Actions action;
            Actions altAction;
            Actions deviationAction;
            int deviationCount;
            Settings.StrategyDeviationSign sign;
        }
    }
}