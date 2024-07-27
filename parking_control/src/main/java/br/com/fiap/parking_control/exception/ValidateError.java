package br.com.fiap.parking_control.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidateError extends StandardError {

    private List<ValidateMessage> menssagens = new ArrayList<>();

    public List<ValidateMessage> getMessages() {
        return menssagens;
    }

    public void addMenssagens(String campo, String messagem) {
        menssagens.add(new ValidateMessage(campo, messagem));
    }
}