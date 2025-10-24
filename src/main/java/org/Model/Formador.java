package org.Model;

public class Formador {
    private String nome;
    private String dataNascimento;
    private String cc;
    private String email;
    private String contacto;
    private String areaEspecial;
    private String identificadorUnico;
    private Credenciais credenciais;

    public Formador() {
        this.identificadorUnico = "";
        this.credenciais = new Credenciais("", "");
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setAreaEspecial(String areaEspecial) {
        this.areaEspecial = areaEspecial;
    }

    public void setIdentificadorUnico(String identificadorUnico) {
        this.identificadorUnico = identificadorUnico;
    }

    public void setCredenciais(Credenciais credenciais) {
        this.credenciais = credenciais;
    }

    // Getters
    public String getNome() { return nome; }
    public String getDataNascimento() { return dataNascimento; }
    public String getCc() { return cc; }
    public String getEmail() { return email; }
    public String getContacto() { return contacto; }
    public String getAreaEspecial() { return areaEspecial; }
    public String getIdentificadorUnico() { return identificadorUnico; }
    public Credenciais getCredenciais() { return credenciais; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Data de nascimento: ").append(dataNascimento).append("\n");
        sb.append("CC: ").append(cc).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Contacto: ").append(contacto).append("\n");
        sb.append("Área de especialização: ").append(areaEspecial).append("\n");
        sb.append("Identificador único: ").append(identificadorUnico).append("\n");
        sb.append("Credenciais: ")
                .append(credenciais != null ? credenciais.toString() : "n/a")
                .append("\n");
        return sb.toString();
    }
}