/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facepalm.model;

import java.util.HashMap;

/**
 *
 * @author Vinh
 */
public class Parameters extends HashMap<String, String> {
    public void add(String key, String value)
    {
        this.put(key, value);
    }
    
    @Override
    public String toString()
    {
        String parametes = "";
        for (HashMap.Entry<String, String> entry : this.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            
            parametes += key + "=" + value + "&";
        }
        
        parametes = parametes.substring(0, parametes.length() - 1);
        
        return parametes;
    }
}
