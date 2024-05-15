package medvoll.api.domain.remedio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medvoll.api.domain.consulta.Consulta;

import java.util.List;

@Table(name = "remedios", schema = "vollmed_api")
@Entity(name = "Remedio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class RemedioEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "resumo_medicamento")
    private String resumoMedicamento;

    @Column(name = "numero_registro")
    private String numeroRegistro;

    @Column(name = "estoque")
    private Long estoque;

    @Column(name = "dosagem")
    @Enumerated(EnumType.STRING)
    private Dosagem dosagem;

    @Column(name = "tipo_remedio")
    @Enumerated(EnumType.STRING)
    private TipoRemedio tipoRemedio;

    @JsonBackReference
    @ManyToMany(mappedBy = "remedios")
    private List<Consulta> consultas;


    public RemedioEntity(DadosCadastroRemedio dados) {
        this.descricao = dados.descricao();
        this.resumoMedicamento = dados.resumoMedicamento();
        this.numeroRegistro = dados.numeroRegistro();
        this.estoque = dados.estoque();
        this.dosagem = dados.dosagem();
        this.tipoRemedio = dados.tipoRemedio();
    }
}