package br.com.projetoJpa.modelo.namedNativeQuery;

import br.com.projetoJpa.modelo.basico.Entidade;

public class NotaFilme implements Entidade {

    private Double media;

    public NotaFilme(Double media) {
        this.media = media;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "NotaFilme{" +
                "media=" + media +
                '}';
    }
}

