import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestoreEventi {

    ArrayList<Evento> listaEventi = new ArrayList<>();

    public void aggiungiEvento(Evento e) {
        listaEventi.add(e);
        System.out.println("Evento : " + e.getNome() + " aggiunto");
    }

    public List<Evento> cercaPerData(LocalDate data) {
        List<Evento> eventiTrovati = new ArrayList<>();
        for (Evento evt : listaEventi) {
            if (evt.getData().isEqual(data)) {
                eventiTrovati.add(evt);
            }
        }
        return eventiTrovati;
    }

    public List<Evento> cercaPerTipo(Evento.TipoEvento tipoEvento) {
        List<Evento> tipiEvento = new ArrayList<>();
        for (Evento evento : listaEventi) {
            if (evento.getTipoEvento() == tipoEvento) {
                tipiEvento.add(evento);
            }
        }
        return tipiEvento;
    }
}
