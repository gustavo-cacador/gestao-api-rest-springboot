package com.gustavo.gestao_api_rest.entities;

import com.gustavo.gestao_api_rest.dto.FuncionarioDTO;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String endereco;
    private Date dataNascimento;

    @Column(unique = true)
    private String emailPessoal;

    @Column(unique = true)
    private String emailWorkspace;

    private String telefone;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;

    @OneToMany(mappedBy = "funcionario")
    private List<Equipamento> equipamentos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "tb_funcionario_demanda",
    joinColumns = @JoinColumn(name = "funcionario_id"),
    inverseJoinColumns = @JoinColumn(name = "demanda_id"))
    private Set<Demanda> demandas = new HashSet<>();

    public Funcionario() {

    }

    public Funcionario(Long id, String nome, String cpf, String endereco, Date dataNascimento, String emailPessoal, String emailWorkspace, String telefone, Setor setor, List<Equipamento> equipamentos, Set<Demanda> demandas) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.emailPessoal = emailPessoal;
        this.emailWorkspace = emailWorkspace;
        this.telefone = telefone;
        this.setor = setor;
        this.equipamentos = equipamentos;
        this.demandas = demandas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id) && Objects.equals(cpf, that.cpf) && Objects.equals(emailPessoal, that.emailPessoal) && Objects.equals(emailWorkspace, that.emailWorkspace) && Objects.equals(telefone, that.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, emailPessoal, emailWorkspace, telefone);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmailPessoal() {
        return emailPessoal;
    }

    public void setEmailPessoal(String emailPessoal) {
        this.emailPessoal = emailPessoal;
    }

    public String getEmailWorkspace() {
        return emailWorkspace;
    }

    public void setEmailWorkspace(String emailWorkspace) {
        this.emailWorkspace = emailWorkspace;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public Set<Demanda> getDemandas() {
        return demandas;
    }

    public void setDemandas(Set<Demanda> demandas) {
        this.demandas = demandas;
    }
}
