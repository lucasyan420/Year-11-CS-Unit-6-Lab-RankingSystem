public class User {
    private int rank;
    private int progress;

    public User(){
        rank = -8;
        progress = 0;
    }

    public void incProgress(int activityRank){
        if(rank == 8){
            return;
        }

        if(activityRank < -8 || activityRank > 8 || activityRank == 0){
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }

        if(activityRank == rank){
            progress = progress + 3;
        }
        else if(activityRank == rank - 1){
            progress = progress + 1;
        }
        else if(activityRank <= rank - 2){
            progress = progress;
        }
        else{
            int difference = activityRank - rank;
            progress = progress + (10 * difference * difference);
        }

        if(progress >= 100){
            if(rank == -1){
                rank = 1;
                progress = progress - 100;
            }
            else{
                rank++;
                progress = progress - 100;
            }
        }

    }

    public int getRank() {
        return rank;
    }

    public int getProgress() {
        return progress;
    }

    @Override
    public String toString() {
        return "User{" +
                "rank=" + rank +
                ", progress=" + progress +
                '}';
    }
}
