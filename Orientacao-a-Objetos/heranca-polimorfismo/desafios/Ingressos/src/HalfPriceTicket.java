public final class HalfPriceTicket extends Ticket{
    HalfPriceTicket(double unitaryPrice, String movieName, boolean isDubbed){
        super(unitaryPrice, movieName, isDubbed);
    }
    @Override
    public double getTotalPrice(){
        return this.getUnitaryPrice() / 2;
    }

}
