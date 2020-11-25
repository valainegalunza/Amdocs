package com.valainegalunza.amdocs.data;

import com.valainegalunza.amdocs.entities.Amdocs;

/**
 *
 * @author valainegalunza
 */
public interface AmdocsDao {
    
    void addAmdocs(Amdocs amdocs) throws AmdocsPersistenceException;
    
    void saveItems(Amdocs amdocs);
    
}
