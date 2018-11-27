package ssautor.vo;

import base.vo.EntidadeVO;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author LUCAS
 */
public class AutorVO extends EntidadeVO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(length = 50, nullable = false)
    private String nome;

    public AutorVO() {
    }

    public AutorVO(String nome) {
        this.nome = nome;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public boolean isValido() {
        boolean resp = true;
        if (nome == null || nome.trim().isEmpty()) {
            this.validacaoMsg = "Nome vazio";
            resp = false;
        }

        if (nome.length() > 50) {
            this.validacaoMsg += "\nNome muito extenso!";
            resp = false;
        }

        return resp;
    }

}
