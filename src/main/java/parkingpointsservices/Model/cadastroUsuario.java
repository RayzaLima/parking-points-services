package parkingpointsservices.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class cadastroUsuario {

    private String nome;
    private String email;
    private String senha;
    private int cpf;
    private int telefone;

    //Get's e Set's do cadastro de usuário
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    //Garante que será chave primária - só vai existir 01
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(columnDefinition = "TEXT")
    private String texto;

    
}
