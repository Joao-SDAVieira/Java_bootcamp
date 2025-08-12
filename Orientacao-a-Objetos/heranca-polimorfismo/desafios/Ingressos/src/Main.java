import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double UNITARY_PRICE = 20.00;
        Scanner myScanner = new Scanner(System.in);
        String messageFilmsOptions = """
                Choice your film (number):
                1-Batman
                2-Bat
                3-Man
                Ticket: $20.00
                """;
        System.out.println(messageFilmsOptions);
        String filmName = switch (myScanner.nextInt()) {
            case 1 -> "Batman";
            case 2 -> "Bat";
            case 3 -> "Man";
            default -> "Vende-se esta casa pior filme do mundo";
        };
        System.out.println("The film is Dubbed? [Y]es [N]o");
        String filmIsDubbedResponse = myScanner.next().toUpperCase();
        boolean isDubbed = filmIsDubbedResponse.equals("Y");

        String messageTicketType = """
                Insert your ticket type:
                [N] Normal
                [HP] Half Price Ticket
                [FT] Family Ticket
                """;
        System.out.println(messageTicketType);
        String ticketType = myScanner.next().toUpperCase();
        Ticket ticket;
        if (ticketType.equals("FT")) {
            System.out.println("What is the quantity of persons to see the movie?");
                    ticket = new FamilyTicket(
                    UNITARY_PRICE,
                    filmName,
                    isDubbed,
                    myScanner.nextInt());
            }
        else if (ticketType.equals("N")){
            ticket = new Ticket(UNITARY_PRICE,filmName, isDubbed);
        }
        else {
            ticket = new HalfPriceTicket(UNITARY_PRICE,filmName, isDubbed);
        }
        String finalMessage = String.format("""
                Resume:
                Film: %s
                %s
                Unitary price: %s
                Total: %s
                """, ticket.getMovieName(),
                ticket.getIsDubbed() ? "Dubbed": "Subtitled",
                ticket.getUnitaryPrice(),
                ticket.getTotalPrice()
        );
        System.out.println(finalMessage);
    }
}