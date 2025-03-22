package mx.hiro.aprovisionamiento.dao;
import mx.hiro.aprovisionamiento.dto.CifrasDTO;

public interface CifrasDAO {
    public int insertarCifras(CifrasDTO cifrasDTO);
    public int actualizarCifras(CifrasDTO cifrasDTO);
}
