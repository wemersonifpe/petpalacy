/*MIT License

 Copyright (c) 2018 Daniel da Silva Calado, Izaquiel Cavalcante da Silva, 
                   Kaio Cesar Bezerra da Silva e Wemerson Diogenes da Silva

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */
package br.edu.ifpe.petshop.model.repositorio.implementacao;

import br.edu.ifpe.petshop.model.dao.PersistenciaDAO;
import br.edu.ifpe.petshop.model.repositorio.interfaces.RepositorioEmpresa;
import br.edu.ifpe.petshop.model.entidades.Empresa;
import java.util.List;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class RepositorioEmpresaImpDB implements RepositorioEmpresa<Empresa> {
    
    private static RepositorioEmpresaImpDB instance; 
    
    private RepositorioEmpresaImpDB(){
        
    }
    
    public static RepositorioEmpresaImpDB getInstance(){
        
        if(instance == null)
            instance = new RepositorioEmpresaImpDB();
        
        return instance;
    }
         
            
    @Override
    public void salvar(Empresa empresa) {
        PersistenciaDAO.getInstance().salvar(empresa);
    }

    @Override
    public void editar(Empresa empresa) {
        PersistenciaDAO.getInstance().editar(empresa);
    }

    @Override
    public Empresa buscar(Integer codigo) {
        return (Empresa) PersistenciaDAO.getInstance().listar("SELECT em FROM Empresa em WHERE em.id=" + codigo).get(0);
    }

    @Override
    public void deletar(Empresa empresa) {
        PersistenciaDAO.getInstance().deletar(empresa);
    }

    @Override
    public List<Empresa> listar() {
        return PersistenciaDAO.getInstance().listar("SELECT em FROM Empresa em");
    }
    
    @Override
    public Empresa buscarCnpj(String cnpj){
        return (Empresa) PersistenciaDAO.getInstance().listar("SELECT em FROM Empresa em WHERE em.cnpj=" + cnpj).get(0);
    }
}
