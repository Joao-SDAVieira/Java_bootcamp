public final class FamilyTicket extends Ticket{
    private final int clientsQuantity;

    FamilyTicket(
            double unitaryPrice,
            String movieName,
            boolean isDubbed,
            int clientsQuantity
    ){
        super(unitaryPrice, movieName, isDubbed);
        this.clientsQuantity = clientsQuantity;
    }
    @Override
    public double getTotalPrice(){
        double productUnPriceQuantity = this.getUnitaryPrice() * this.clientsQuantity;
        if (this.clientsQuantity > 3){
            return productUnPriceQuantity - (productUnPriceQuantity * 0.05);
        }
        return productUnPriceQuantity;
    }
}
