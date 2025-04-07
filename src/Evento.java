import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Evento {

    private String nome;
    private LocalDate data;

    private enum TipoEvento {CONCERTO, CONFERENZA, WORKSHOP, SPORT}

    public Evento(String nome, LocalDate data) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Il nome dell'evento non può essere nullo o vuoto.");
        }
        this.nome = nome;

        if (data.isBefore(LocalDate.now())) {
            throw new DateTimeException("La data non può essere nel passato");
        }
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData() {
        return data;
    }

    public String generaCodiceUnivoco() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dataFormattata = data.format(formatter);
        Random random = new Random();
        int numero = random.nextInt(100, 999);
        return "EVT-" + " " + dataFormattata + " " + numero;
    }
}
