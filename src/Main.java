import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        GestoreEventi gestoreEventi = new GestoreEventi();

        Evento evento1 = new Evento("musica classica", LocalDate.of(2025, 4, 10), Evento.TipoEvento.CONCERTO);
        Evento evento2 = new Evento("maratona", LocalDate.of(2025, 4, 10), Evento.TipoEvento.SPORT);
        Evento evento3 = new Evento("sviluppo software", LocalDate.of(2025, 6, 22), Evento.TipoEvento.WORKSHOP);
        Evento evento4 = new Evento("conferenza stampa", LocalDate.of(2025, 7, 1), Evento.TipoEvento.CONFERENZA);

        gestoreEventi.aggiungiEvento(evento1);
        gestoreEventi.aggiungiEvento(evento2);
        gestoreEventi.aggiungiEvento(evento3);
        gestoreEventi.aggiungiEvento(evento4);

        System.out.println("Lista degli eventi : ");
        for (Evento evento : gestoreEventi.listaEventi) {
            System.out.println(evento.getNome() + " " + evento.generaCodiceUnivoco());
        }

        System.out.println("Eventi di una determinata data : " + gestoreEventi.cercaPerData(LocalDate.of(2025, 4, 10)));
        System.out.println("Eventi per tipo : " + gestoreEventi.cercaPerTipo(Evento.TipoEvento.SPORT));
        System.out.println("Nome evento1 : " + evento1.formattaNome("musica classica"));
    }
}
