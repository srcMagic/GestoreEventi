import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Evento {

    private String nome;
    private LocalDate data;
    private TipoEvento tipoEvento;
    private String codice;

    public enum TipoEvento {CONCERTO, CONFERENZA, WORKSHOP, SPORT}

    public Evento(String nome, LocalDate data, TipoEvento tipoEvento) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Il nome dell'evento non può essere nullo o vuoto.");
        }
        this.nome = nome;

        if (data.isBefore(LocalDate.now())) {
            throw new DateTimeException("La data non può essere nel passato");
        }
        this.data = data;
        this.tipoEvento = tipoEvento;

    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData() {
        return data;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public String generaCodiceUnivoco() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String dataFormattata = data.format(formatter);
        Random random = new Random();
        int numero = random.nextInt(100, 999);
        return "EVT-" + dataFormattata + "-" + numero;
    }

    public String formattaNome(String nome) {
        if (nome.length() > 50) {
            nome = nome.substring(0, 50) + "...";
        }
        StringBuilder converted = new StringBuilder();
        boolean convertNext = true;
        for (char ch : nome.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }
        return converted.toString();
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", data=" + data +
                ", tipoEvento=" + tipoEvento +
                '}';
    }
}
