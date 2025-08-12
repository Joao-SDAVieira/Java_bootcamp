public class Ticket {
    private final double unitaryPrice;
    private final String movieName;
    private final boolean isDubbed;
    // atributos como final pois não possui setters

    public Ticket(double unitaryPrice, String movieName, boolean isDubbed){
        this.unitaryPrice = unitaryPrice;
        this.movieName = movieName;
        this.isDubbed = isDubbed;
    }
    public double getUnitaryPrice(){
        return this.unitaryPrice;
    }

    public double getTotalPrice(){
        return getUnitaryPrice();
    }
    public String getMovieName(){
        return this.movieName;
    }

    public boolean getIsDubbed(){
        return this.isDubbed;
    }
}