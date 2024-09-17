package com.model;

public enum Perfil {
    ADMINISTRADOR(1),
    FUNCIONARIO(2),
    PADRAO(3);

    private int valor;

    Perfil(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static Perfil fromValor(int valor) {
        for (Perfil perfil : Perfil.values()) {
            if (perfil.getValor() == valor) {
                return perfil;
            }
        }
        throw new IllegalArgumentException("Perfil inválido: " + valor);
    }
}
