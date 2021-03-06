/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmt.ic.posbd.energia.tableModel;

import br.ufmt.ic.posbd.energiamysql.entidade.Ambiente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class AmbienteTableModel extends AbstractTableModel {

    private List<Ambiente> lista;
    private final String[] titulos = new String[]{"Id","Nome Ambiente"};
    
    public AmbienteTableModel(List<Ambiente> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public String getColumnName(int column) {
        return titulos[column];
    }
    
    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object ret = null;
        Ambiente ambiente = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                ret = ambiente.getId();
                break;
            case 1:
                ret = ambiente.getAmbiente();
                break;
        }
        
        return ret;
    }
    
    public void atualizar(List<Ambiente> lista){
        this.lista = lista;
        fireTableDataChanged();
    }
    
    public Ambiente get(int index){
        return lista.get(index);
    }
    
}
