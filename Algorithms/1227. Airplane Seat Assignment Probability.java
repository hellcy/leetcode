class Solution {
    public double nthPersonGetsNthSeat(int n) {
        /*
            the probability is the same as if there were only 2 people
            assume there are 100 people. if the next person's seat is not taken, he would sit there, so we can just ignore this person and his seat.
            until next person's seat has been taken, now his would randomly choose another seat
            Repeat the same procedure until there are only 2 people left, if the second last person found out his seat is taken
            he has 50% probability to take the last person's seat
        */
        if (n == 1) return 1.0;
        return 0.5;
    }
}